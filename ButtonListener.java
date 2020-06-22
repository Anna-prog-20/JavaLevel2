import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    private JTextArea text;
    private JTextField textMessage;

    public ButtonListener(JTextArea text, JTextField textMessage) {
        this.text = text;
        this.textMessage = textMessage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!textMessage.getText().isEmpty()) {
            text.append(textMessage.getText() + "\n");
            textMessage.setText("Текст сообщения");
        }
    }

}
