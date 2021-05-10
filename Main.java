import Labs.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main 
{
    public static void LAB1()
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
        try 
        {
            URL file1 = new URL("http://homes.ieu.edu.tr/tdirek/file1.txt");
            URL file2 = new URL("http://homes.ieu.edu.tr/tdirek/file2.txt");
            URL file3 = new URL("http://homes.ieu.edu.tr/tdirek/file3.txt");

            ArrayList<URL> urls = new  ArrayList<>();

            urls.add(file1);
            urls.add(file2);
            urls.add(file3);
        
            Lab4.OperationByCLI(urls); 
        } 
        catch (MalformedURLException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static void LAB5()
    {
        try 
        { 
            Lab5.OperationByCLI();
        } 
        catch (IOException e) 
        {
            System.out.println("Error: "+e.getLocalizedMessage()+"");
        }
    }
    
    public static void main(String[] args) throws IOException
    {
       //LAB1();  
       //LAB2();
        //LAB4();
        LAB5();
    }
}
