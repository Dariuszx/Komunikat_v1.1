package engine;

import gui.KContainers.KWindow;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Serwer {

    ServerSocket serverSocket = null;
    Socket clientSocket = null;
    private DataInputStream streamIn = null;
    private ExecutorService executorService = Executors.newFixedThreadPool( 10 );

    public Serwer( int port ) throws IOException {

        serverSocket = new ServerSocket( port );
        System.out.println( "Server started: " + serverSocket );

        while( true ) {
            clientSocket = serverSocket.accept();

            executorService.submit( new ServiceRequest( clientSocket ) );
        }
    }
}

class ServiceRequest implements Runnable {

    private Socket gniazdo = null;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;

    public ServiceRequest( Socket s ) {
        this.gniazdo = s;
    }

    @Override
    public void run() {

        System.out.println( "Client accepted: " + gniazdo.getRemoteSocketAddress() );

        try {
            streamIn = new DataInputStream( new BufferedInputStream( gniazdo.getInputStream() ) );
            streamOut = new DataOutputStream( new BufferedOutputStream( gniazdo.getOutputStream() ) );

        } catch ( IOException e) {
            System.out.println( e.toString() );
        }

        while( true ) {
            try {

                String line = streamIn.readUTF();
                System.out.println( line + " from " + gniazdo.getRemoteSocketAddress() );

                streamOut.writeUTF( line );
                streamOut.flush();

                if( line.equals( "exit" ) ) {
                    gniazdo.close();
                    break;
                }
            } catch ( IOException e ) {
                System.out.println( e.toString() );
            }
        }
    }
}
