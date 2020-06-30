import java.io.*;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    public static void main(String[] args) {
        new Client().start();
    }

    public void start() {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Поехали общаться!");

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread(new ReadMessage("Сервер",socket,in)).start();
                new Thread(new WhriteMessage(socket,out)).start();
            }
        }).start();
    }
}