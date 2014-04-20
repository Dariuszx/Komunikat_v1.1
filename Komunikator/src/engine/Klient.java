package engine;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Klient {

    private Socket gniazdo = null;
    private DataInputStream console = null;
    private DataOutputStream streamOut = null;
    private DataInputStream streamIn = null;

    private String Host;
    private int Port;
    private boolean isconnected = false;

    public Klient(String Host, int Port) throws IOException {

        this.Host = Host;
        this.Port = Port;

        gniazdo = new Socket( Host, Port );
        System.out.println( "Connected: " + gniazdo );
        isconnected = true;
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

    public boolean isConnected() {
        return isconnected;
    }
    private void start() throws IOException {

        console = new DataInputStream( System.in );
        streamOut = new DataOutputStream( gniazdo.getOutputStream() );
        streamIn = new DataInputStream( new BufferedInputStream( gniazdo.getInputStream() ) );

    }
}
