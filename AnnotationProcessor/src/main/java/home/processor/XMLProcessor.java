package home.processor;

import home.annotation.FeatureOpt;
import home.antlr4.XMLLexer;
import home.antlr4.XMLParser;
import home.antlr4.XMLParserBaseListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XMLProcessor extends XMLParserBaseListener
{
    final private TokenStream tokens;
    final private FileProcessor fileProcessor;
    final private TokenStreamRewriter rewriter;
    final private Set<FeatureOpt> featureOptSet;

    public XMLProcessor(FileProcessor fileProcessor, TokenStream tokens, FeatureOpt... featureOpts)
    {
        this.tokens = tokens;
        this.fileProcessor = fileProcessor;
        this.rewriter = new TokenStreamRewriter(tokens);
        this.featureOptSet = new HashSet<>(Arrays.asList(featureOpts));
    }

    @Override
    public String toString()
    {
        return rewriter.getText();
    }

    @Override
    public void exitElement(XMLParser.ElementContext ctx)
    {
        final List<Token> tokenList =  ((CommonTokenStream) tokens).getHiddenTokensToLeft(
            ctx.getStart().getTokenIndex(),
            XMLLexer.COMMENT_CHANNEL
        );

        if (tokenList != null) {
            final Token token = tokenList.get(0);
            final String fOptName = token.getText().trim();
            final FeatureOpt featureOpt = FeatureOpt.valueOf(
                fOptName.substring("<!--".length(), fOptName.length() - "-->".length())
                        .trim()
                        .toUpperCase()
            );

            if (featureOptSet.contains(featureOpt)) {
                fileProcessor.addPruneFiles(ctx);
                rewriter.delete(token.getTokenIndex(), ctx.getStop().getTokenIndex());
            } else {
                rewriter.delete(token.getTokenIndex());
            }
        }
    }
}
