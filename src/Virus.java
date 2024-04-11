import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Virus extends JFrame {
    Robot robot;//объект для создания скриншотов
    Timer timer;//таймер по которому будем создавать скриншоты экрана
    int countScreens;//счетчик скриншотов
    Frame frame; //окно блокировщика

    Virus() throws AWTException {
        robot = new Robot();
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveScreen();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        timer.start();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setVisible(false);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher((KeyEventDispatcher) new KeyDispetcher());

    }

    class KeyDispetcher implements KeyEventDispatcher{

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_SHIFT){//по нажатию на левый шифт
                System.exit(0);
            }
            return false;
        }
    }

    private void saveScreen() throws IOException {
        countScreens++;

        Dimension dimension  = Toolkit.getDefaultToolkit().getScreenSize();
        int w = dimension.width;
        int h = dimension.height;
        var screen = robot.createScreenCapture(new Rectangle(0,0,w,h));
        ImageIO.write(screen,"PNG",new File("D:\\1\\screens\\img"+countScreens+".png")); //нужно ЗАДАТЬ ПРАВИЛЬНЫЙ ПУТЬ К КАРТИНКЕ

        if(countScreens == 2) {
            timer.stop();
            frame = new Frame();//окно блокировщика
            frame.setBounds(0, 0, w, h);
            frame.setResizable(false);//запрет менять размер окна
            frame.setUndecorated(true);//убрали все кнопки с окна
            frame.setAlwaysOnTop(true);//чтобы окно перекрывало любые окна
            frame.setBackground(Color.GREEN);
            frame.setOpacity(0.5f);//устанавливаем прозрачность

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowIconified(WindowEvent e) {
                    frame.setExtendedState(Frame.MAXIMIZED_BOTH);
                }
            });

            frame.setVisible(true);

            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.toFront();//чтобы окно было всегда поверх всех окон
                }
            });
            timer.start();
        }

    }

    public static void main(String[] args) throws AWTException {
        new Virus();
    }
}
