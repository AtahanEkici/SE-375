import static Labs.Lab1.FileOperation;
import static Labs.Lab1.catchInput;
import static Labs.Lab1.getFiles;
import static Labs.Lab1.readFile;
import static Labs.Lab1.splitter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        try
        {
        //OperationByCLI();
        OperationByGUI();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Re-Called Function");
        } 
    }
    public static void OperationByCLI() throws IOException
    {
        ArrayList<File> files = FileOperation(splitter(catchInput()));
        Scanner scan_word = new Scanner(System.in);
        System.out.print("Plase input word : ");
        String scanned = scan_word.nextLine();
        readFile(files,scanned);
    }
    public static void OperationByGUI() throws IOException
    {
        System.out.print("Please Specify search word: ");
        getFiles();
    }
}
