import Labs.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main 
{
    public static ArrayList<URL> Url_Storage() throws IOException
    {
         ArrayList<URL> urls = new  ArrayList<>();
         
        try
        {
            URL file1 = new URL("http://homes.ieu.edu.tr/tdirek/file1.txt");
            URL file2 = new URL("http://homes.ieu.edu.tr/tdirek/file2.txt");
            URL file3 = new URL("http://homes.ieu.edu.tr/tdirek/file3.txt");
            
            urls.add(file1);
            urls.add(file2);
            urls.add(file3);   
        } 
        catch (MalformedURLException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return urls;
    } 
    
    private static void LAB1()
    {
        try 
        { 
            Lab1.Setup("CLI");
        } 
        catch (IOException e) 
        {
            System.out.println("Error: "+e.getLocalizedMessage()+"");
        }
    }
    
    private static void LAB2()
    {
        try
        {
            Lab2.Setup("CLI");
        }
        catch(IOException e)
        {
          System.out.println("Error: "+e.getLocalizedMessage()+"");
        }    
    }
    private static void LAB4() throws IOException
    {
        Lab4.OperationByCLI(Url_Storage());  
    }
    private static void LAB5()
    {
        try 
        { 
            Lab5.OperationByFile();
            //Lab5.OperationByURL(Url_Storage());
        } 
        catch (Exception e) 
        {
            System.out.println("Error: "+e.getLocalizedMessage()+"");
        }
    }
    
    public static void LAB6() throws IOException
    {
        String deneme = "deneme";
        Lab6.Setup(deneme);
    }
    
    public static void main(String[] args) throws IOException
    {
       //LAB1();  
       //LAB2();
        //LAB4();
        //LAB5();
        LAB6();
    }
}

class Server extends Thread 
{
  @Override
  public void run() 
  {
    System.out.println("This code is running in a thread");
  }
}

class Client extends Thread 
{
  @Override
  public void run() 
  {
    System.out.println("This code is running in a thread");
  }
}
