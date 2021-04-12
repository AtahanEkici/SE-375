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

public class Lab2 extends Lab1
{  
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
            readFiles(files,caught);    
            JOptionPane.showMessageDialog(null,"Transaction Successfull","Success",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void readFiles(File[] files, String word) throws FileNotFoundException, IOException
    { 
        for (File file : files) 
        {
            String[] words;
            int counter_1 = 0;
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
                            counter_1++;
                        }
                    }
                }
            }
            System.out.println(file.getName() + ": " + counter_1 + " found");
        }
    }
    
    public static void readFiles(ArrayList<File> files, String word) throws FileNotFoundException, IOException
    { 
        for(int i = 0; i<files.size();i++)
        {    
            File file = files.get(i);
            String[] words;
            int counter_1 = 0;
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
                                counter_1++;
                            }
                        }
                    }
                }
            System.out.println(files.get(i).getName()+ ": "+counter_1+" found");
             }
    }
    
     public static void readFile(File file, String word) throws FileNotFoundException, IOException
    { 
            String[] words;
            int counter_1 = 0;
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
                                counter_1++;
                            }
                        }
                    }
                    System.out.println("Thread " + Thread.currentThread().getId()+ " has read file: "+file.getName()+"");
                }
            System.out.println(file.getName()+ ": "+counter_1+" found");
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
        ArrayList<File> files = FileOperation(splitter(catchInput())); // Catch files //
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word : ");
        String scanned = scan_word.nextLine(); // catch keyword //
        Lab2_Runnable lab2 = new Lab2_Runnable(files,scanned);
        lab2.Start();
    }
    public static void OperationByGUI() throws IOException
    {
        System.out.print("Please Specify search word: ");
        getFiles();
    }
}
