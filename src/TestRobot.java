import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TestRobot {
    Robot robot;

    public TestRobot() throws AWTException {
        robot = new Robot();
        var frame = new JFrame();
        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);
        frame.setLocation(0,0);
        frame.setLayout(new FlowLayout());
        JButton btn[] = new JButton[3];
        Listener listener = new Listener();
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();
            btn[i].setName("b"+i);
            btn[i].addActionListener(listener);
            frame.add(btn[i]);
        }
        btn[0].setText("Поисковик");
        btn[1].setText("Калькулятор");
        btn[2].setText("Демо моргание клавиш");
        frame.pack();
        frame.setVisible(true);
    }
    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String titleButton = button.getName();//имя кнопки
            switch (titleButton){
                case "b0":
                    var builder = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe",
                            "https://yandex.ru");
                    try {
                        builder.start();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "b1":
                    try {
                        new ProcessBuilder("calc").start();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "b2":
                    for (int i = 0; i < 10; i++) {
                        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
                        robot.delay(500);
                        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);

                        robot.keyPress(KeyEvent.VK_NUM_LOCK);
                        robot.delay(500);
                        robot.keyRelease(KeyEvent.VK_NUM_LOCK);
                    }
            }
        }
    }

    public static void main(String[] args) throws AWTException {
        new TestRobot();
    }

}
