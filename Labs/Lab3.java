package Labs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab3 extends Lab2 implements Runnable 
{
    private final ArrayList<Thread> threads = new ArrayList<>();
    protected final ArrayList<File> files;
    protected final ArrayList<URL> urls;
    protected final String word;
    
    public final void Thread_The_Files_FILE(ArrayList<File> files)
     {
        files.stream().map(_item -> new Thread(this)).forEachOrdered(temp ->
        {
            threads.add(temp);
        });
     }

    public final void Thread_The_Files_URL(ArrayList<URL> urls)
     {
        urls.stream().map(_item -> new Thread(this)).forEachOrdered(temp ->
        {
            threads.add(temp);
        });
     }

    
   public Lab3(ArrayList<File> files, String word, int mode) 
   {
       this.files = files;
       this.word = word;
       this.urls = null;
       Thread_The_Files_FILE(files);
   }

   public Lab3(ArrayList<URL> urls, String word) 
   {
       this.urls = urls;
       this.word = word;
       this.files = null;
       Thread_The_Files_URL(urls); 
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
            readFile(files.get((int) Thread.currentThread().getId() - (Runtime.getRuntime().availableProcessors()-1)), word);
        } 
        catch (IOException e) 
        {
            Logger.getLogger(Lab3.class.getName()).log(Level.SEVERE, null, e);
        }
   }
}