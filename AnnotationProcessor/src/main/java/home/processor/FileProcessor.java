package home.processor;

import home.antlr4.XMLParser;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

public class FileProcessor
{
    final private File srcRoot;
    final private File dstRoot;
    final private Set<String> pruneFiles = new HashSet<>();

    public FileProcessor(File srcDir, File dstDir)
    {
        this.srcRoot = srcDir;
        this.dstRoot = dstDir;
    }

    public boolean contains(String filePath)
    {
        return pruneFiles.contains(filePath);
    }

    public void prune(FileFilter filter)
    {
        relocate(srcRoot, dstRoot, filter);
    }

    private void relocate(File srcDir, File dstDir, FileFilter fileFilter)
    {
        if (fileFilter.accept(dstDir)) {
            if (!dstDir.exists()) {
                dstDir.mkdir();
            }

            for (File file : srcDir.listFiles()) {
                final String fn = file.getName();
                final File dst = new File(dstDir, fn);

                if (file.isDirectory()) {
                    final File src = new File(srcDir, fn);
                    relocate(src, dst, fileFilter);
                } else {
                    if (fileFilter.accept(dst)) {
                        try (
                            final InputStream fin = new FileInputStream(file);
                            final OutputStream fout = new FileOutputStream(dst)
                        ) {
                            final byte[] buffer = new byte[1024];

                            int byteCount;
                            while((byteCount = fin.read(buffer)) > 0) {
                                fout.write(buffer, 0, byteCount);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void addPruneFiles(XMLParser.ElementContext ctx)
    {
        if ("types:interfaceType".equals(ctx.getChild(1).getText())) {
            ParseTree tree = getInterfaceImp(ctx);
            pruneFiles.add(tree.getText().replace(".", File.separator) + ".java");
        } else if ("types:component".equals(ctx.getChild(1).getText())) {
            ParseTree tree = getComponentImp(ctx);

            for (ParseTree child : ((XMLParser.ElementContext) tree).children) {
                if (child instanceof XMLParser.ContentContext) {
                    XMLParser.ContentContext cntCtx = (XMLParser.ContentContext) child;

                    for (ParseTree gChild : cntCtx.children) {
                        if (gChild instanceof XMLParser.ElementContext) {
                            String fn = gChild.getChild(4).getChild(1).getChild(4).getText();
                            pruneFiles.add(fn.substring(0, fn.lastIndexOf('.')).replace(".", File.separator));
                        }
                    }
                }
            }
        }
    }

    private ParseTree getInterfaceImp(XMLParser.ElementContext ctx)
    {
        return ctx.getChild(5).getChild(3).getChild(4).getChild(1).getChild(4).getChild(1).getChild(4);
    }

    private ParseTree getComponentImp(XMLParser.ElementContext ctx)
    {
        for (ParseTree child : ctx.children) {
            if (child instanceof XMLParser.ContentContext) {
                XMLParser.ContentContext cntCtx = (XMLParser.ContentContext) child;

                for (ParseTree gChild : cntCtx.children) {
                    if (gChild instanceof XMLParser.ElementContext
                        && "implementationext:implementation".equals(gChild.getChild(1).getText())) {
                        return gChild;
                    }
                }
            }
        }

        return null;
    }
}
