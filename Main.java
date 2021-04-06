import Labs.Lab1;
import Labs.Lab2;
import static Labs.Lab2.FileOperation;
import static Labs.Lab2.catchInput;
import static Labs.Lab2.readFiles;
import static Labs.Lab2.splitter;
import Labs.Lab2_Runnable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
        catch (IOException ex) 
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void LAB2()
    {
        ArrayList<File> files = FileOperation(splitter(catchInput())); // Catch files //
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word : ");
        String scanned = scan_word.nextLine(); // catch keyword //
        Lab2_Runnable lab2 = new Lab2_Runnable(files,scanned);
        lab2.Start();
    }
    
    public static void main(String[] args) throws IOException
    {
       // LAB1();  
       LAB2();
    }
}
