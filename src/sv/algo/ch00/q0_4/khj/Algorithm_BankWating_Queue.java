import java.util.Scanner;

public class algorhm_0_4_1
{
    static int queueSize = 10;
    static int[] waitingQueue = new int[queueSize];
    static int header = 0;
    static int tail = 0;

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner( System.in );

        while( true )
        {

            int value = scanner.nextInt();

            if( value == -1 )
            {
                System.out.println( "Program Finish!" );
                break;
            }

            if( value == 0 )
            {

                dequeue();

            }
            else
            {

                enqueue( value );

            }

        }

    }

    public static void enqueue( int value )
    {

        if( tail == queueSize - 1 )
        {
            System.out.println( "[Error]queue is full" );
            return;
        }

        waitingQueue[tail] = value;
        System.out.println( "[+]enqueue = " + value );
        tail++;

    }

    public static void dequeue()
    {

        if( header == queueSize - 1 )
        {
            System.out.println( "[Error] header is end" );
            return;
        }

        if( header < tail )
        {
            int value = waitingQueue[header];
            System.out.println( "[-]dequeue = " + value );
            header++;
        }
        else
        {
            System.out.println( "[Error] queue does not have value" );
        }

    }

}
