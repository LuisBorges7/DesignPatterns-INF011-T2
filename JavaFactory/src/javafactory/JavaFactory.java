package javafactory;

import interfaces.ISyntaxHighlighter;
import interfaces.IIDEFactory;
import interfaces.ICompiler;
/**
 *
 * @author luisborges
 */
public class JavaFactory implements IIDEFactory{
    
    static String[] extensions = {"java"};
    private static JavaFactory instance;
    
    protected JavaFactory() {
    }
    
    public static IIDEFactory getInstance() {
        if (instance == null) {
                    instance = new JavaFactory();
                }
        return instance;
    }
        
    @Override
    public ISyntaxHighlighter createSyntaxHighligher() {
        return new JavaSyntaxHighlighter();
    }

    @Override
    public ICompiler createCompiler() {
        return new JavaCompiler();
    }

    @Override
    public String[] supportedExtensions() {
        return extensions;
    }
}
