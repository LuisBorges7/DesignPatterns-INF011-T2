package cppfactory;

import interfaces.ISyntaxHighlighter;
import interfaces.IIDEFactory;
import interfaces.ICompiler;
/**
 *
 * @author luisborges
 */
public class CppFactory implements IIDEFactory{
    
    static String[] extensions = {"cpp"};
    private static CppFactory instance;
    
    protected CppFactory() {
    }
    
    public static IIDEFactory getInstance() {
        if (instance == null) {
                    instance = new CppFactory();
                }
        return instance;
    }
    
    @Override
    public ISyntaxHighlighter createSyntaxHighligher() {
        return new CppSyntaxHighlighter();
    }

    @Override
    public ICompiler createCompiler() {
        return new CppCompiler();
    }

    @Override
    public String[] supportedExtensions() {
        return extensions;
    }
}
