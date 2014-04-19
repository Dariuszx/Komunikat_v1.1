
import engine.*;

public class Main {

    public static void main( String[] args ) {

        Runnable a = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("A=" + i);
                        Thread.sleep(100);
                    }
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        };

        Thread c = new Thread( a );
        Thread gui = new Thread( new createUI() );

        c.start();
        gui.start();





    }
}
