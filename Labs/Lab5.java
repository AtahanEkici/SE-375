package Labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab5 extends Lab3 implements Runnable
{ 
    private int counter = -1;
    
    public Lab5(ArrayList<File> files, String word,int a) 
    {
        super(files, word,1);
    }
    
    public Lab5(ArrayList<URL> urls, String word) 
    {
        super(urls, word);
    }
    
    public static void readFile(File file, String word) throws FileNotFoundException, IOException
    { 
            String[] words;
            int counter_1 = 0;
            String line;
            
            
            try (RandomAccessFile RAF = new RandomAccessFile(file, "rw"); FileChannel channel = RAF.getChannel()) 
                {
                    FileLock lock = channel.lock(); // file lock
                    System.out.println("Thread " + Thread.currentThread().getId()+ " has locked the file: "+file.getName()+"");
                    
                        while ((line = RAF.readLine()) != null) 
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
                    lock.release();
                    System.out.println("Thread " + Thread.currentThread().getId()+ " has UNlocked the file: "+file.getName()+"");
                    System.out.println(file.getName()+ ": "+counter_1+" found");
                } // file lock
        // file lock
            }
    
    @Override
   public void run() 
   {
        try 
        {
            if(this.urls == null) // if the File mod is engaged //
            {
            System.out.println("Thread " + Thread.currentThread().getId()+ " is running"); 
            Lab5.readFile(files.get(++counter), word);
            }
            else // if the URL mode is engaged //
            {
              Lab4.readFileUsingURI(urls.get(++counter), word);  
            }           
        } 
        catch (IOException e) 
        {
            Logger.getLogger(Lab5.class.getName()).log(Level.SEVERE, null, e);
        }
   }
    
    public static void OperationByFile() throws IOException
    {
        ArrayList<File> files = FileOperation(splitter(catchInput())); // Catch files //
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word : ");
        String scanned = scan_word.nextLine(); // catch keyword //
        Lab5 lab5 = new Lab5(files,scanned,1);
        lab5.Start();
    }
    
    public static void OperationByURL(ArrayList<URL> urls) throws IOException
    {
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word for scanning: ");
        String scanned = scan_word.nextLine(); // catch keyword //
        Lab5 lab5 = new Lab5(urls,scanned);
        lab5.Start();
    }
}
