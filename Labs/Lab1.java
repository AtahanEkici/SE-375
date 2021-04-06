package Labs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lab1 
{
    public static String[] splitter(String input) // //
    {
        String[] temp = null;
        
        if(input.contains("WordCount"))
        {
            temp =  input.split("\\ ");
        }
        else
        {
            System.out.println("Unidentified Operation");
        }
        return temp;
    }
    public static ArrayList<File> FileOperation(String[] fileadresses)
    {
       String desktop = System.getProperty("user.home") +"/Desktop";
       ArrayList<File> files = new ArrayList<>();
       
        if(fileadresses != null && fileadresses.length > 1)
        {
           for (int i=1;i<fileadresses.length;i++) 
           {
               files.add(new File(desktop+"/"+fileadresses[i]+".txt"));
           }
        }
        else
        {
            System.out.println("Please input a valid file(s)");
            System.exit(1);
        }
       return files;
    }
    public static String catchInput()
    {
        String news;
        Scanner scan = new Scanner(System.in);
        news = scan.nextLine();
        return news;
    }
    
    public static void getFiles() throws IOException
    {
        File[] files;
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home") +"/Desktop");
        jfc.setMultiSelectionEnabled(true);
        jfc.setFileFilter(new FileNameExtensionFilter("TXT Files","txt"));
        int result = jfc.showSaveDialog(null);
        files = jfc.getSelectedFiles();
        String caught = catchInput();
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            readFile(files,caught);    
            JOptionPane.showMessageDialog(null,"Transaction Successfull","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void readFile(File[] files, String word) throws FileNotFoundException, IOException
    { 
        for (File file : files) 
        {
            String[] words;
            int counter = 0;
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
            {
                while ((line = reader.readLine()) != null)
                {
                    words = line.split(" ");
                    
                    for(String cont : words)
                    {
                        if (cont.equals(word)) 
                        {
                            counter++;
                        }
                    }
                }
            }
            System.out.println(file.getName() + ": " + counter + " found");
        }
    }
    
    public static void readFile( ArrayList<File> files, String word) throws FileNotFoundException, IOException
    { 
        for(int i = 0; i<files.size();i++)
        {    
            File file = files.get(i);
            String[] words;
            int counter = 0;
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    while ((line = reader.readLine()) != null)
                    {
                        words = line.split(" ");
                        
                        for(String cont : words) 
                        {
                            if (cont.equals(word))
                            {
                                counter++;
                            }
                        }
                    }
                }
            System.out.println(files.get(i).getName()+ ": "+counter+" found");
             }
    }
    public static void Setup(String Choice) throws IOException
    {
        try
        {
        if(Choice.matches("CLI"))
        {
            OperationByCLI();
        }
        else
        {
            OperationByGUI();
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }
    public static void OperationByCLI() throws IOException
    {
        ArrayList<File> files = FileOperation(splitter(catchInput()));
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word : ");
        String scanned = scan_word.nextLine();
        readFile(files,scanned);
    }
    public static void OperationByGUI() throws IOException
    {
        System.out.print("Please Specify search word: ");
        getFiles();
    }
}
