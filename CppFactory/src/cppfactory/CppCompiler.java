package cppfactory;

import java.io.File;
import interfaces.ICompiler;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author luisborges
 */
public class CppCompiler implements ICompiler{

    @Override
    public void compile(File file) {
        System.out.println("Compilando arquivo cpp " + file);
        String pathToCompile = file.toString();
        String fileName = pathToCompile.split("\\.")[0];
        System.out.println("FileName: " + fileName);

        String toCompile = "g++ " + pathToCompile + " -o " + fileName;

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
