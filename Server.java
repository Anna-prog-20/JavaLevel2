import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {

        new Server().start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {

            System.out.println(serverSocket.getInetAddress().toString());
            System.out.println(serverSocket.getLocalPort());

            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();

            System.out.println("Клиент подключился");
            System.out.println("Поехали общаться!");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
                new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new Thread(new ReadMessage("Клиент", socket, in)).start();
                            new Thread(new WhriteMessage(socket, out)).start();

                        }
                    }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
