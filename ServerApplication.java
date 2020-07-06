import java.io.IOException;
import java.net.Socket;

public class ServerApplication {

    public static void main(String[] args) {
        new Server(8189);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    ClientHandler client = new ClientHandler(new Server(8189), new Socket("localhost", 8554));
//                    client.prepareGUI();
//                }catch (IOException e){e.printStackTrace();}
//            }
//        }).start();


    }
}
