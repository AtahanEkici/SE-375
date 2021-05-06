package Labs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Lab4 extends Lab2 implements Runnable 
{
    private static final ArrayList<Thread> threads = new ArrayList<>();
    private final ArrayList<URL> urls;
    private final String word;
    
    public void Thread_The_Files(ArrayList<URL> files)
     {
        files.stream().map(_item -> new Thread(this)).forEachOrdered(temp ->
        {
            threads.add(temp);
        });
     }
    
   public Lab4(ArrayList<URL> files, String word) 
   {
       this.urls = files;
       this.word = word;
       Thread_The_Files(files);
   }
   public static void Start()
   {
       for(int i=0;i<threads.size();i++)
       {
           threads.get(i).start();
       }
       threads.clear(); // clear all object after the operation is complete //
   }
   
    public static void OperationByCLI(ArrayList<URL> urls) throws IOException
    {    
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word for scanning: ");
        String scanned = scan_word.nextLine(); // catch keyword //
        
        Lab4 deneme = new Lab4(urls,scanned);
        Lab4.Start();
    }
    
    public static void ReadArray(Object[] a)
    {
        for(int i = 0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
   
   public static void readFileUsingURI(URL FileURI, String word) throws FileNotFoundException, IOException
    { 
            String[] words;
            int counter_1 = 0;
            String line;

            try (BufferedReader in = new BufferedReader(new InputStreamReader(FileURI.openStream()))) 
                {
                    while ((line = in.readLine()) != null)
                    {
                        //line = line.replaceAll("\\,", "");
                        //line = line.replaceAll("\\.", "");
                        
                        words = line.split(" "); 
                        
                        for(int i = 0;i<words.length;i++) 
                        {
                            if (words[i].contains(word))
                            {
                                counter_1++;
                            }
                        }
                    }
                    System.out.println("Thread " + Thread.currentThread().getId()+ " has read file: "+FileURI.getPath()+"");
                }
            System.out.println(FileURI.getPath()+ ": "+counter_1+" found");
    }

   @Override
   public void run() 
   {
        try 
        {
            readFileUsingURI(urls.get((int)Thread.currentThread().getId() - 11), word);    
        } 
        catch (IOException e) 
        {
            Logger.getLogger(Lab4.class.getName()).log(Level.SEVERE, null, e);
        }
   }
}

