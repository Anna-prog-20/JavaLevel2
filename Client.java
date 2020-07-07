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

public class Client extends JFrame {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    private JTextField msgInputField,loginField,passField;
    private JTextArea chatArea;

    private long a;
    private String incomeMessage;

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
        //System.out.println(String.valueOf(System.currentTimeMillis()/1000L));

        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        a=System.currentTimeMillis()/1000L;
            Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                       incomeMessage = in.readUTF();
                       //System.out.println(System.currentTimeMillis()/1000L-a);
                       if(incomeMessage.startsWith("/authok")) {
                            chatArea.append("Вы успешно авторизовались!");
                            chatArea.append("\n");
                            break;
                        }
                        chatArea.append(incomeMessage);
                        chatArea.append("\n");
                    }
                    while (true) {
                        incomeMessage = in.readUTF();
                        if (incomeMessage.equalsIgnoreCase("/end")) {
                            break;
                        }
                        chatArea.append(incomeMessage);
                        chatArea.append("\n");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
            thread.setDaemon(true);
            thread.start();
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
        setLayout(new GridLayout(3,1));
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

        // панель авторизации
        JPanel authPanel = new JPanel(new BorderLayout());
        JButton auth = new JButton("Авторизоваться");
        authPanel.setLayout(new BoxLayout(authPanel,BoxLayout.X_AXIS));

        loginField = new JTextField();
        passField = new JTextField();

        JLabel login=new JLabel("Логин: ");
        JLabel pas=new JLabel("Пароль: ");

        add(authPanel);
        authPanel.add(login);
        authPanel.add(loginField);
        authPanel.add(pas);
        authPanel.add(passField);
        authPanel.add(auth);
        auth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                onAuthClick();
            }
        });
        loginField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAuthClick();
            }
        });
        passField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAuthClick();
            }
        });
        //System.out.println(String.valueOf(System.currentTimeMillis()/1000L));

        //auth.doClick(30);

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

    public void onAuthClick() {
        if (socket == null || socket.isClosed()) {
            start();
        }
        try {
            //System.out.println(String.valueOf(System.currentTimeMillis()/1000L));
            out.writeUTF("/auth " + loginField.getText() + " " + passField.getText());
            loginField.setText("");
            passField.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
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