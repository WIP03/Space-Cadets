package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HandlerClientSide {

    public void init(String serverIp, Integer serverPort){
        //INITALISE CONNECTION HERE
        try{
            clientSocket = new Socket(serverIp, serverPort);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException exception){

        }
    }

    public String sendMessage(String message){
        //ADD MESSAGE CODE
        String resp = null;

        try{
            out.println(message);
            resp = in.readLine();
        }catch(IOException exception){

        }

        return resp;
    }

    public Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

}
