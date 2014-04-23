package engine;


import gui.KDialogs.WarningDialog;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Klient {

    public Socket gniazdo = null;
    private DataInputStream console = null;
    private DataOutputStream streamOut = null;
    private DataInputStream streamIn = null;

    public String host;
    public int port;
    private boolean connected = false;

    public Klient() {}

    public Klient( String Host, int Port ) {

        this.host = Host;
        this.port = Port;

/*
        start();

        String line = "";

        while( true ) {
            line = console.readLine();
            streamOut.writeUTF( line );
            streamOut.flush();

            String request = streamIn.readUTF();

            System.out.println( request );


            if( line.equals( "exit" ) ) break;
        }

        gniazdo.close();
        */
    }

    public void sendString( String s ) throws IOException {

        if ( isConnected() == true ) {
            streamOut.writeUTF(s);
            streamOut.flush();
        }
    }


    public void connect() throws IOException {

        gniazdo = new Socket( host, port );
        start();
        connected = true;
    }

    public boolean isConnected() {
        return connected;
    }

    private void start() throws IOException {

        console = new DataInputStream( System.in );
        streamOut = new DataOutputStream( gniazdo.getOutputStream() );
        streamIn = new DataInputStream( new BufferedInputStream( gniazdo.getInputStream() ) );

    }
}

abstract class MakeRequest implements Runnable {

    private Klient klient;
    private Object data;

    public MakeRequest( Klient klient, Object data ) {

        this.klient = klient;
        this.data = data;
    }

    @Override
    abstract public void run();
}
