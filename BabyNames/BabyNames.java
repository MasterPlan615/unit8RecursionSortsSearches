import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames
{
   public static final double LIMIT = 50;

   public static void main(String[] args) throws FileNotFoundException
   {  
      Scanner file_name = new Scanner( System.in );
      System.out.println( "Please enter a file name: " );
      File file = new File( file_name.next() );
      Scanner in = new Scanner( file ).useDelimiter(" ");
         
      RecordReader boys = new RecordReader(LIMIT); // Remember there are two separate RecordReaders reading the text
      RecordReader girls = new RecordReader(LIMIT); // Ditto
      
      while (boys.hasMore() || girls.hasMore())
      {
         boys.process(in);
         girls.process(in);
         System.out.println();
      }

      in.close();
   }
}	
