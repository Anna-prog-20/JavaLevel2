import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class WhriteMessage implements Runnable {
    private Socket socket;
    private DataOutputStream out;
    private Scanner sc= new Scanner(System.in);

    public WhriteMessage(Socket socket, DataOutputStream out) {
        this.socket = socket;
        this.out = out;
    }

    @Override
    public void run() {
        try{
            String message="";
            while (!(message.equals("/end"))) {
                message = sc.next();
                out.writeUTF(message);
            }
        }catch (IOException e){e.printStackTrace();}
    }

}
