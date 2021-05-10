package Labs;

import static Labs.Lab1.FileOperation;
import static Labs.Lab1.catchInput;
import static Labs.Lab1.splitter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab5 extends Lab3 implements Runnable
{ 
    public Lab5(ArrayList<File> files, String word) 
    {
        super(files, word);
    }
    
    public static void readFile(File file, String word) throws FileNotFoundException, IOException
    { 
            String[] words;
            int counter_1 = 0;
            String line;
            
            try (RandomAccessFile RAF = new RandomAccessFile(file, "rw")) 
                {
                    FileChannel channel = RAF.getChannel();
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
                    channel.close();
                } // file lock
    }
    
    @Override
   public void run() 
   {
        try 
        {
            System.out.println("Thread " + Thread.currentThread().getId()+ " is running"); 
            Lab5.readFile(files.get((int) Thread.currentThread().getId() - 11), word);
        } 
        catch (IOException e) 
        {
            Logger.getLogger(Lab5.class.getName()).log(Level.SEVERE, null, e);
        }
   }
    
    public static void OperationByCLI() throws IOException
    {
        ArrayList<File> files = FileOperation(splitter(catchInput())); // Catch files //
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word : ");
        String scanned = scan_word.nextLine(); // catch keyword //
        Lab5 lab5 = new Lab5(files,scanned);
        lab5.Start();
    }
}
