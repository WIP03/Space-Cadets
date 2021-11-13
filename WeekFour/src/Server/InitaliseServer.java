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
      while(true){
        new ClientConnection(serverSocket.accept()).start();
      }

    } catch (IOException exception) {
    }
  }

  public ServerSocket serverSocket;
}
