package Server;

import com.sun.tools.javac.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class InitaliseServer {

    public void init(Integer serverPort) {
        try {
            serverSocket = new ServerSocket(11111);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String message = in.readLine();
            System.out.println(message);
            if(!message.equals(null)){
                out.println("Message received, have a nice day.");
            }else{
                out.println("No message received :(");
            }

        } catch (IOException exception) {
        }
    }

    public ServerSocket serverSocket;
    public Socket clientSocket;
    public PrintWriter out;
    public BufferedReader in;
}
