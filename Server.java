import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 5000; // Port number to listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Accept client connections
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Read data from the client
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a response
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello from Server!");

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
