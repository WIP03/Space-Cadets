package Client;

import java.io.IOException;
import java.util.Scanner;

public class MainClient {

  public static void main(String[] args) throws IOException {

    System.out.println("##############################################");
    System.out.println("# Please input the IP and Port of the server #");
    System.out.println("##############################################");
    System.out.print("IP: ");
    Scanner scanner = new Scanner(System.in);
    String Ip = scanner.nextLine();
    System.out.print("Port: ");
    String Port = scanner.nextLine();

    HandlerClientSide client = new HandlerClientSide();
    client.init(Ip, Integer.decode(Port));

    String userInput = "";

    while (!userInput.equals("!exit")){
      userInput = scanner.nextLine();

      System.out.println(client.sendMessage(userInput));
    }

    client.stop();
  }
}
