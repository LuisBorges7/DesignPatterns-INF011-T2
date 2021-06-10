package interfaces;
/**
 *
 * @author luisborges
 */
public interface IIDEFactory {
    
   public abstract ISyntaxHighlighter createSyntaxHighligher();
   public abstract ICompiler createCompiler();
   public abstract String [] supportedExtensions();
}
