import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    private JTextArea text;
    private JTextField textMessage;

    public KeyListener(JTextArea text, JTextField textMessage) {
        this.text = text;
        this.textMessage = textMessage;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER&&!textMessage.getText().isEmpty()) {
            text.append(textMessage.getText() + "\n");
            textMessage.setText(null);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
