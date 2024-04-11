import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseTest extends JFrame {
    JLabel label;
    JButton button;
    JTextArea textArea;
    String text;


    MouseTest(){
        var c = getContentPane();
        c.setLayout(new FlowLayout());
        label = new JLabel();
        button = new JButton("ок");
        textArea = new JTextArea(30,100);
        c.add(label);
        c.add(textArea);

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
               var x = e.getX();
               var y = e.getY();
               text += "x = " + x + ";y = " + y + "\n";
               textArea.setText(text);
            }
        });

        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Произошел клик");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Ушли из наблюдаемой области");
            }
        });

    }

    public static void main(String[] args) {
        new MouseTest().setVisible(true);
    }

}
