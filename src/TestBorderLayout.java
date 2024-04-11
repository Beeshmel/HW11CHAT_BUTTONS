import javax.swing.*;
import java.awt.*;

public class TestBorderLayout extends JFrame {
    public static void main(String[] args) {
        var f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        var b1 = new JButton("Кнопка 1");
        var b2 = new JButton("Кнопка 2");
        var b3 = new JButton("Кнопка 3");
        var b4 = new JButton("Кнопка 4");
        var b5 = new JButton("Кнопка 5");

        panel.add(b1,BorderLayout.CENTER);
        panel.add(b2,BorderLayout.NORTH);
        panel.add(b3,BorderLayout.SOUTH);
        panel.add(b4,BorderLayout.WEST);
        panel.add(b5,BorderLayout.EAST);

        var c = f.getContentPane();
        f.setPreferredSize(new Dimension(500,500));
        f.pack();
        c.add(panel);
        f.setVisible(true);

    }
}
