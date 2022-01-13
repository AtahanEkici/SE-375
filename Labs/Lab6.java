package Labs;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Lab6 extends Lab1
{
    public static void Setup(String word) throws IOException
    {
        JFileChooser fileChooser = new JFileChooser("Choose a File");
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser = new JFileChooser(System.getProperty("user.home") +"/Desktop");
        int result = fileChooser.showSaveDialog(null);
        File[] selectedFiles = fileChooser.getSelectedFiles();
        
        if(result == JFileChooser.APPROVE_OPTION)
        { 
            readFile(selectedFiles,word);
            System.out.println(Arrays.toString(selectedFiles));
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }
}
