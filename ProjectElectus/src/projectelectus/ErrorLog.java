package projectElectus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static projectElectus.Game.bwFile;

/**
 * This class creates and writes to an Error Log when an error is encountered.
 * @author Michael Peterson and Jack Baumann
 */
public class ErrorLog {
    
    public static Scanner fileIn;
    public static BufferedWriter bwFile;
    /**
     * This method creates a new Error Log to write to called "ErrorLog.txt" or throws an error if it can not.
     */
    public static void create(){
        try
        {
            bwFile = new BufferedWriter(new FileWriter("Saves\\ErrorLog.txt"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Unable to create ErrorLog" + e);
            writeTo("Unable to create ErrorLog " + e);
        }
    }
    /**
     * This method writes the given text on a new line of the Error Log or throws an error if it can not.
     * @param text
     */
    public static void writeTo(String text)
    {
        try
        {
            bwFile.write(text);
            bwFile.newLine();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Unable to write to ErrorLog" + e); 
            writeTo("Unable to write to ErrorLog " + e);
        }
    }
    /**
     * This method closes the Error Log from being written in, or throws an error if it can not.
     */
    public static void close()
    {
        try
        {
            bwFile.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Unable to close ErrorLog" + e);
            writeTo("Unable to close ErrorLog " + e);
        }
    }
}
