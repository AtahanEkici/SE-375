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
            Lab4.OperationByCLI();
        } 
        catch (MalformedURLException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws IOException
    {
       //LAB1();  
       //LAB2();
        LAB4();
    }
}
