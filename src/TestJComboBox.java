import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TestJComboBox extends JFrame{
    JComboBox<String> comboBox;

    TestJComboBox(){
        var c = getContentPane();
        c.setLayout(new FlowLayout());

        comboBox = new JComboBox<>(new String[]{"red","green","blue"});
        c.add(comboBox);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource() == comboBox){
                    if(e.getStateChange() == ItemEvent.SELECTED){
                        JOptionPane.showMessageDialog(null,comboBox.getSelectedItem());
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        new TestJComboBox().setVisible(true);
    }
}
