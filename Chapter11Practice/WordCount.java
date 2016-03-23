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
        int t_char = 0;
        int t_words = 0;
        int t_sen = 0;
        while( scan.hasNext() )
        {
            String value = scan.next();
            if( value.contains(".") || value.contains("!") || value.contains("?") )
            {
                t_sen += 1;
                t_words += 1;
                for( int i = 0; i < value.length() - 1; i++ )
                {
                    t_char += 1;
                }
            }
            else
            {
                t_words += 1;
                for( int i = 0; i < value.length(); i++ )
                {
                    t_char += 1;
                }
            }
        }
        System.out.println( "Characters: " +t_char + "\nWords: " + t_words + "\nSentences: " + t_sen );
        in.close();
    }
}
