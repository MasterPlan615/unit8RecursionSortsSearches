import java.util.Random;

public class BubbleSort
{
    private static int[] bubble;
    private static Random generator = new Random();

    public static void main( String[] args )
    {
        fill( 10 );
        for( int i = 0; i < bubble.length; i++ )
        {
            System.out.println( bubble[i] );
        }
        sort();
        System.out.println( "\nSorted: " );
        for( int i = 0; i < bubble.length; i++ )
        {
            System.out.println( bubble[i] );
        }
    }

    public static void fill( int num )
    {
        bubble = new int[ num ];
        for( int i = 0; i < num; i++ )
        {
            bubble[i] = generator.nextInt( 10 );
        }
    }

    public static void sort()
    {
        int storage = 0;
        int storage2 = 0;
        for( int i = 0; i < bubble.length; i+=2 )
        {
            if( bubble[i] > bubble[i + 1] )
            {
                if( bubble[i] < storage )
                {
                    storage2 = bubble[i - 1];
                    bubble[i - 1] = bubble[i];
                    bubble[i] = storage2;
                    storage = bubble[i];
                    bubble[i] = bubble[i + 1];
                    bubble[i + 1] = storage;
                }
                else
                {
                    storage = bubble[i];
                    bubble[i] = bubble[i + 1];
                    bubble[i + 1] = storage;
                }
            }
        }
    }
}