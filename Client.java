import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame  {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    private JTextField msgInputField;
    private JTextArea chatArea;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Client client = new Client();
                client.start();
                client.prepareGUI();
            }
        }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               Client client = new Client();
               client.start();
               client.prepareGUI();
           }
       }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Client client = new Client();
                client.start();
                client.prepareGUI();
            }
        }).start();

    }

    public void start() {
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

            new Thread(new Runnable() {
            @Override
            public void run() {
                String incomeMessage ="";
                try {
                    while (!(incomeMessage.equalsIgnoreCase("/end"))) {
                        System.out.println("Ожидание сообщения");
                        incomeMessage = in.readUTF();
                        chatArea.append(incomeMessage);
                        chatArea.append("\n");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        })
                .start();
    }

    public void send() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                out.writeUTF(msgInputField.getText());
                msgInputField.setText("");
                msgInputField.grabFocus();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
            }
        }
    }

    public void prepareGUI() {
        // Параметры окна
        setBounds(600, 200, 500, 400);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Текстовое поле для вывода сообщений
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);

        btnSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send();
            }
        });
        msgInputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send();
            }
        });

        // Настраиваем действие на закрытие окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("/end");
                    close();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public void close() {

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.dispose();
    }

}