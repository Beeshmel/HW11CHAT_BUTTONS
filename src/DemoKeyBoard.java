import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DemoKeyBoard  extends JFrame {
    String str = "";

    DemoKeyBoard(){
        setLayout(new FlowLayout());
        var text = new JTextField(10);
        var label = new JLabel();
        add(text); add(label);
        setSize(400,400);

        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
//                str += e.getKeyChar();
                str += e.getKeyCode() + " ";
                label.setText(str);
            }
        });

    }

    public static void main(String[] args) {
        new DemoKeyBoard().setVisible(true);
    }
}
