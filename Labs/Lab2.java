package Labs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab2 extends Lab1
{  
    
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
                            if (cont.contains(word))
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
            System.out.println(e.getClass().toString() + e.getCause().toString() + e.getLocalizedMessage());
        } 
    }
    public static void OperationByCLI() throws IOException
    {
        ArrayList<File> files = FileOperation(splitter(catchInput())); // Catch files //
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word : ");
        String scanned = scan_word.nextLine(); // catch keyword //
        Lab3 lab3 = new Lab3(files,scanned,1);
        lab3.Start();
    }
    public static void OperationByGUI() throws IOException
    {
        System.out.print("Please Specify search word: ");
        getFiles();
    }
}
