import javax.swing.*;
import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {
    private JTextArea text;
    private JTextField textMessage;

    public MouseListener(JTextArea text, JTextField textMessage) {
        this.text = text;
        this.textMessage = textMessage;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        textMessage.setText(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
