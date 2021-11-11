package Server;

import java.net.ServerSocket;

public class MainServer {

    public static void main(String[] args) {
        InitaliseServer initServer = new InitaliseServer();
        initServer.init(11111);
    }
}
