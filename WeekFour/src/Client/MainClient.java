package Client;

import java.io.IOException;
import java.util.Scanner;

public class MainClient {

  public static void main(String[] args) throws IOException {
    HandlerClientSide client = new HandlerClientSide();
    client.init("127.0.0.1", 11111);

    String userInput = "";

    while (!userInput.equals("!exit")){
      Scanner scanner = new Scanner(System.in);
      userInput = scanner.nextLine();

      System.out.println(client.sendMessage(userInput));
    }

    client.stop();
  }
}
