package engine;


import gui.KDialogs.KDialog;
import gui.KDialogs.StatusPanel;
import gui.KDialogs.WarningDialog;

import java.awt.*;
import java.io.IOException;

public class Data {

    public Klient serwer;

    public Data() {
        serwer = new Klient();
    }

    public void connectToServer( final KDialog parent, String ip, int port ) {

        serwer.host = ip;
        serwer.port = port;

        Thread connect = new Thread( new MakeRequest( serwer, parent ) {
            @Override
            public void run() {
                try {
                    parent.statusPanel.setText( "Connecting.." );
                    serwer.connect();
                    parent.statusPanel.setText( "Connected" );

                    if( serwer.gniazdo.isConnected() ) new WarningDialog( parent, "Nawiązano połączenie!" );
                } catch( IOException e ) {
                    parent.statusPanel.setText( "Something went wrong ):" );
                    new WarningDialog( parent, e.toString() );
                }
            }
        });

        connect.start();
        if( !connect.isAlive() ) System.out.println( "asd" );

    }

    public boolean disconnectFromServer( final Component parent ) {

        if( serwer.gniazdo == null || !serwer.gniazdo.isConnected() ) return true;
        else {

            try {
                serwer.gniazdo.shutdownInput();
            } catch ( IOException e ) {
                new WarningDialog( parent, e.toString() );
                return false;
            }
        }
        return true;
    }


}

