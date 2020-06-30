import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadMessage implements Runnable{
    private Socket socket;
    private DataInputStream in;
    private String name;

    public ReadMessage(String name,Socket socket, DataInputStream in) {
        this.name=name;
        this.socket = socket;
        this.in = in;
    }

    @Override
    public void run() {
        try{
            String message="";
            while (!(message.equals("/end"))) {
                message = in.readUTF();
                System.out.println(name+":"+message);
            }
        }catch (IOException e){e.printStackTrace();}
    }

}
