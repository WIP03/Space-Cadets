package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection extends Thread {

  public ClientConnection(Socket socket) {
    this.clientSocket = socket;
  }

  public void run() {
    try {
      out = new PrintWriter(clientSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      String message;

      while ((message = in.readLine()) != null) {
        System.out.println(message);

        if (!message.equals("!exit")) {
          out.println("Message received, have a nice day.");
        } else {
          out.println("Bye Then :(");
          break;
        }
      }
    } catch (IOException exception) {
    }
  }

  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;
}
