package home.processor;

import home.annotation.Feature;
import home.annotation.FeatureOpt;
import home.antlr4.JavaBaseListener;
import home.antlr4.JavaLexer;
import home.antlr4.JavaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaProcessor extends JavaBaseListener
{
    final private TokenStream tokens;
    final private TokenStreamRewriter rewriter;
    final private Set<FeatureOpt> featureOptSet;

    public JavaProcessor(TokenStream tokens, FeatureOpt... featureOpts)
    {
        this.tokens = tokens;
        this.rewriter = new TokenStreamRewriter(tokens);
        this.featureOptSet = new HashSet<>(Arrays.asList(featureOpts));
    }

    @Override
    public String toString()
    {
        return this.rewriter.getText();
    }

    @Override
    public void exitImportDeclaration(final JavaParser.ImportDeclarationContext ctx)
    {
        if (Feature.class.getName().equals(ctx.getChild(1).getText())
            || FeatureOpt.class.getName().equals(ctx.getChild(1).getText())) {
            rewriter.delete(ctx.getStart(), ctx.getStop());
        } else {
            pruneBlock(ctx, new Consumer<Token>() {
                @Override
                public void accept(Token token) {
                    rewriter.delete(token, ctx.getStop());
                }
            });
        }
    }

    @Override
    public void exitStatement(final JavaParser.StatementContext ctx)
    {
        pruneBlock(ctx, new Consumer<Token>() {
            @Override
            public void accept(Token token) {
                rewriter.delete(token, ctx.getStop());
            }
        });
    }

    @Override
    public void exitSuperclass(final JavaParser.SuperclassContext ctx)
    {
        pruneBlock((ParserRuleContext) ctx.getChild(1), new Consumer<Token>() {
            @Override
            public void accept(Token token) {
                rewriter.delete(ctx.getStart(), ctx.getStop());
            }
        });
    }

    @Override
    public void exitFieldDeclaration(JavaParser.FieldDeclarationContext ctx)
    {
        prune(ctx);
    }

    @Override
    public void exitMethodDeclaration(JavaParser.MethodDeclarationContext ctx)
    {
        prune(ctx);
    }

    private void prune(final ParserRuleContext prCtx)
    {
        final ParserRuleContext classBodyDeclaration = prCtx.getParent().getParent();

        for (ParseTree child : classBodyDeclaration.children) {
            if (child instanceof JavaParser.ModifierContext) {
                final JavaParser.AnnotationContext annotationCtx = ((JavaParser.ModifierContext) child).classOrInterfaceModifier().annotation();

                if (isPruneAnnotation(annotationCtx)) {
                    rewriter.delete(classBodyDeclaration.getStart(), classBodyDeclaration.getStop());
                    break;
                } else if (isFeatureAnnotation(annotationCtx)) {
                    rewriter.delete(annotationCtx.getStart(), annotationCtx.getStop());
                    break;
                }
            }
        }
    }

    private void pruneBlock(final ParserRuleContext prCtx, final Consumer<Token> action)
    {
        final List<Token> leftHiddenTokens = ((CommonTokenStream) tokens).getHiddenTokensToLeft(
            prCtx.getStart().getTokenIndex(),
            JavaLexer.COMMENT_CHANNEL
        );

        if (leftHiddenTokens != null) {
            for (Token hiddenToken : leftHiddenTokens) {
                final String htText = hiddenToken.getText();
                final ANTLRInputStream htInputStream = new ANTLRInputStream(htText.substring("/*".length(), htText.length() - "*/".length()));

                final JavaLexer htLexer = new JavaLexer(htInputStream);
                final CommonTokenStream htStream = new CommonTokenStream(htLexer);

                final JavaParser htParser = new JavaParser(htStream);
                final JavaParser.AnnotationContext annotationCtx = htParser.annotation();

                if (isPruneAnnotation(annotationCtx)) {
                    action.accept(hiddenToken);
                    break;
                } else if (isFeatureAnnotation(annotationCtx)) {
                    rewriter.delete(hiddenToken);
                    break;
                }
            }
        }
    }

    private boolean isPruneAnnotation(final JavaParser.AnnotationContext ctx)
    {
        if (isFeatureAnnotation(ctx)) {
            final JavaParser.ElementValueArrayInitializerContext arrayInitializerCtx = ctx.elementValue().elementValueArrayInitializer();

            if (arrayInitializerCtx != null) {
                for (ParseTree child : arrayInitializerCtx.children) {
                    if (child instanceof JavaParser.ElementValueContext) {
                        final String fOptName = child.getText().replace(FeatureOpt.class.getSimpleName() + ".", "");

                        if (!featureOptSet.contains(FeatureOpt.valueOf(fOptName))) {
                            return false;
                        }
                    }
                }
            } else {
                final String fOptName = ctx.elementValue().getText().replace(FeatureOpt.class.getSimpleName() + ".", "");

                if (!featureOptSet.contains(FeatureOpt.valueOf(fOptName))) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    private boolean isFeatureAnnotation(final JavaParser.AnnotationContext annotationContext)
    {
        return annotationContext != null
            && Feature.class.getSimpleName().equals(annotationContext.annotationName().getText());
    }
}
