import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestWindowListener extends JFrame {
    public TestWindowListener(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Реакция на сворачивание окна");
            }
        });
    }

    public static void main(String[] args) {
        new TestWindowListener().setVisible(true);
    }
}
