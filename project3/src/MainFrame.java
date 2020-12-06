import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        /* All of the usual Jframe stuff */
        super("Traffic Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setResizable(false);

        MenuPanel menu = new MenuPanel();
        Background background = new Background();
        InitialPanel initialPanel = new InitialPanel(this, menu, background);

        add(initialPanel);
        pack();
        setVisible(true);
    }
}
