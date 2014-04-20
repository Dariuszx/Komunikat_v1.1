
import engine.*;

public class MainKlient {

    public static void main( String[] args ) {

        Data data = new Data();

        Thread gui = new Thread( new createUI( data ) );

        gui.start();

/*
        System.out.println( "Start" );
        try {
            new Klient( "127.0.1.1", 4564 );
        } catch ( IOException e ) {
            System.out.println( e.toString() );
        }
 */

    }
}
