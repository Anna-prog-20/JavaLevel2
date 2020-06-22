import javax.swing.*;
import java.awt.*;

public class ChatWindow extends JFrame {

    public ChatWindow(String nameUser){
        setTitle("Чат("+nameUser+")");
        setBounds(50,50,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));


        JPanel textChat=new JPanel();

        JTextArea text=new JTextArea(25,40);
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textChat.add(scrollPane);
        text.setBackground(new Color(127648));

        add(textChat);

        JPanel message=new JPanel();
        message.setLayout(new FlowLayout());

        JTextField textMessage=new JTextField("Текст сообщения",26);
        textMessage.addKeyListener(new KeyListener(text,textMessage));
        textMessage.addMouseListener(new MouseListener(text,textMessage));
        textMessage.setText("Текст сообщения");

        JButton ok=new JButton("Отправить сообщение");
        ok.addActionListener(new ButtonListener(text,textMessage));

        message.add(textMessage);
        message.add(ok);

        add(message);

        setVisible(true);
    }
}
