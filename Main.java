import Labs.*;
import java.io.IOException;

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
    
    public static void main(String[] args) throws IOException
    {
       //LAB1();  
       LAB2();
    }
}
