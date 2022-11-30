package question9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static int PORT = 8080;
    public static final String SHUTDOWN = "SHUTDOWN";
    private boolean alive = true;

    public void communicate() {
        // FILL IN CODE:
        /*
        Write the code for the server program that:
        • listens for the connection requests from the clients on port 8080
        • once the client requests a connection, opens a connection socket and input/output streams
        • reads a single line sent by the client through the socket and prints the clients request to the console.
        • Sends the length of the request back to the client.
        • Make sure to catch IOException in this method.
        */
    }

    public static void main(String[] args) {
        Server s = new Server();
        s.communicate();
    }
}
