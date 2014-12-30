package home.processor;

import home.annotation.FeatureOpt;
import home.antlr4.JavaLexer;
import home.antlr4.JavaParser;
import home.antlr4.XMLLexer;
import home.antlr4.XMLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class ProductLineProcessor
{
    private final File archFile;
    private final File sourceDir;
    private final File destinationDir;

    public ProductLineProcessor(File sourceDir, File archFile, File destinationDir)
    {
        this.archFile = archFile;
        this.sourceDir = sourceDir;
        this.destinationDir = destinationDir;
    }

    public void pruneFeatures(FeatureOpt... opts)
    {
        pruneArch(opts);

        for (File srcFile : getSrcFiles(destinationDir, new LinkedList<File>())) {
            pruneSource(srcFile, opts);
        }
    }

    private List<File> getSrcFiles(File srcDir, List<File> srcFiles)
    {
        for (File file : srcDir.listFiles()) {
            if (!file.isHidden()) {
                if (file.isDirectory()) {
                    getSrcFiles(file, srcFiles);
                } else if (file.getName().endsWith(".java")) {
                    srcFiles.add(file);
                }
            }
        }

        return srcFiles;
    }

    private void pruneSource(File srcFile, FeatureOpt... opts)
    {
        try (final InputStream fileStream = new FileInputStream(srcFile)) {
            final ANTLRInputStream antIS = new ANTLRInputStream(fileStream);

            final JavaLexer lexer = new JavaLexer(antIS);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);

            final JavaParser parser = new JavaParser(tokens);
            final ParseTree tree = parser.compilationUnit();

            final ParseTreeWalker walker = new ParseTreeWalker();
            final JavaProcessor srcPruner = new JavaProcessor(tokens, opts);

            walker.walk(srcPruner, tree);

            try (FileWriter writer = new FileWriter(srcFile)) {
                writer.write(srcPruner.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pruneArch(FeatureOpt... opts)
    {
        try (final InputStream fileStream = new FileInputStream(archFile)) {
            final ANTLRInputStream antIS = new ANTLRInputStream(fileStream);

            final XMLLexer lexer = new XMLLexer(antIS);
            final CommonTokenStream tokens = new CommonTokenStream(lexer);

            final XMLParser parser = new XMLParser(tokens);
            final ParseTree tree = parser.document();

            final ParseTreeWalker walker = new ParseTreeWalker();

            final FileProcessor filePruner = new FileProcessor(sourceDir, destinationDir);
            final XMLProcessor archPruner = new XMLProcessor(filePruner, tokens, opts);

            walker.walk(archPruner, tree);

            try (FileWriter writer = new java.io.FileWriter(new File(destinationDir, archFile.getName()))) {
                writer.write(archPruner.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            filePruner.prune(new FileFilter() {
                @Override public boolean accept(File file) {
                    return !file.isHidden()
                        && !file.getName().endsWith("xml")
                        && !filePruner.contains(file.getPath().replace(destinationDir.getPath() + File.separator, ""));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
