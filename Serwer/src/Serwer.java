import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Serwer {

    private Socket gniazdo = null;
    private ServerSocket serwer = null;
    private DataInputStream streamIn = null;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public Serwer( int port ) throws IOException {

        serwer = new ServerSocket(port);

        while ( true ) {

            System.out.println("Waiting for request");
            Socket s = serwer.accept();
            executorService.submit(new ServiceRequest(s));
        }
    }
}

class ServiceRequest implements Runnable {

    private Socket socket;

    public ServiceRequest(Socket connection) {
        this.socket = connection;
    }

    public void run() {

        //Do your logic here. You have the `socket` available to read/write data.

        //Make sure to close
        try {
            socket.close();
        }catch(IOException ioe) {
            System.out.println("Error closing client connection");
        }
    }
}
