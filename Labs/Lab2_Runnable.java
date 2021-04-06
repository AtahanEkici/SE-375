package Labs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab2_Runnable extends Lab2 implements Runnable 
{
    private ArrayList<Thread> threads = new ArrayList<>();
    private static int counter = 0;
    
    private final ArrayList<File> files;
    private final String word;
    
    public void Thread_The_Files(ArrayList<File> files)
     {
        for(int i=0;i<files.size();i++)
        {
            Thread temp = new Thread(this);
            threads.add(temp);
        }
     }
    
   public Lab2_Runnable(ArrayList<File> files, String word) 
   {
       this.files = files;
       this.word = word;
       Thread_The_Files(files);
   }
   public void Start()
   {
       for(int i=0;i<threads.size();i++)
       {
           System.out.println("deneme");
           threads.get(i).start();
       }
   }

   @Override
   public void run() 
   {
        try 
        {
            System.out.println("Thread " + Thread.currentThread().getId()+ " is running");
            Lab2.readFile(files.get((int) Thread.currentThread().getId() - 11), word);
            counter++;
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Lab2_Runnable.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}