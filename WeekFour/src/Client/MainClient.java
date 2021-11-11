package Client;

public class MainClient {

  public static void main(String[] args) {
    HandlerClientSide client = new HandlerClientSide();
    client.init("127.0.0.1", 11111);
    System.out.println(client.sendMessage("HI"));
    System.out.println(client.sendMessage("!exit"));
  }
}
