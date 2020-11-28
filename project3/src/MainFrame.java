import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        /* All of the usual Jframe stuff */
        super("Traffic Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        /* Set layout Manager */

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel menu = new MenuPanel().getPnlMain();
        JPanel background = new Background().getPnlMain();
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        contentPanel.add(menu, BorderLayout.NORTH);
        contentPanel.add( background, BorderLayout.CENTER);
        getContentPane().add(contentPanel);
        pack();
        setVisible(true);
    }
}
