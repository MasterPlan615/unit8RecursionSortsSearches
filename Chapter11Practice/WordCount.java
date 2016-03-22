import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class WordCount 
{

    public static void main( String[] args ) throws FileNotFoundException
    {
        System.out.println( "File name: " );
        Scanner in = new Scanner(System.in);
        File input = new File( in.next() );
        Scanner scan = new Scanner( input );
        while( scan.hasNext() )
        {
            String value = scan.next();
            if(value.contains("."))
            {
                System.out.print( value+"\n" );
            }
            else
            {
                System.out.print( value );
            }
        }
        in.close();
    }
}
