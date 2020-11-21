import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        super("The title");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,400));
        panel.add(new JLabel("hello!"));
        setContentPane(panel);
        pack();
        setVisible(true);
    }
}
