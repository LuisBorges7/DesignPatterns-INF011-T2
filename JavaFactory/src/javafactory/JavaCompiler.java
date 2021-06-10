package javafactory;

import java.io.File;
import interfaces.ICompiler;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author luisborges
 */
public class JavaCompiler implements ICompiler{
    
        @Override
    public void compile(File file) {
        System.out.println("Building...");
        String pathToCompile = file.toString();
        String toCompile = "javac -cp . " + pathToCompile;
        System.out.println("String toCompile: " + toCompile);

        try {
            Process process = Runtime.getRuntime().exec(toCompile);
            process.waitFor();
            System.out.println(toCompile + " exitValue() " + process.exitValue());
            int result = process.exitValue();
            if (result == 0) {
                JOptionPane.showMessageDialog(null, "Build completed successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Build not completed!");
            }
        } catch (HeadlessException | IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

    }
}
