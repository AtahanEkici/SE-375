package Labs;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class Lab6 extends Lab5 implements Runnable
{
    public Lab6(ArrayList<File> files, String word, int a) 
    {
        super(files, word, a);
    }
    
    public Lab6(ArrayList<URL> urls, String word) 
    {
        super(urls, word);
    }
}
