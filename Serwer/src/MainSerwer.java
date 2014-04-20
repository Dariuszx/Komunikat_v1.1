
import engine.Serwer;
import engine.createUI;

import java.io.IOException;

public class MainSerwer {

    public static void main( String[] args ) {

        new createUI();

        try {
            new Serwer( 4564 );
        } catch ( IOException e ) {
            System.out.println( e.toString() );
        }
    }
}
