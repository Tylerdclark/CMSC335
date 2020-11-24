import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        /* All of the usual Jframe stuff */
        super("Traffic Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        /* Set layout Manager */
        getContentPane().add(new InitialPanel().getPnlMain());
        pack();
        setVisible(true);
    }
}
