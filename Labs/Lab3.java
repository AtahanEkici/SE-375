package Labs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 extends Lab2 implements Runnable 
{
    private static final ArrayList<Thread> threads = new ArrayList<>();
    protected final ArrayList<File> files;
    protected final String word;
    
    public void Thread_The_Files(ArrayList<File> files)
     {
         files.stream().map(_item -> new Thread(this)).forEachOrdered(temp ->
        {
            threads.add(temp);
        });
     }
    
   public Lab3(ArrayList<File> files, String word) 
   {
       this.files = files;
       this.word = word;
       Thread_The_Files(files);
   }
   public void Start()
   {
       for(int i=0;i<threads.size();i++)
       {
           threads.get(i).start();
       }
   }

   @Override
   public void run() 
   {
        try 
        {
            System.out.println("Thread " + Thread.currentThread().getId()+ " is running"); 
            readFile(files.get((int) Thread.currentThread().getId() - 11), word);
        } 
        catch (IOException e) 
        {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, e);
        }
   }
}