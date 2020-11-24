import javax.swing.*;
import java.awt.*;

public class InitialFrame extends JFrame {



    public InitialFrame(){
        /* All of the usual JFrame stuff */
        super("Choose Initial conditions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setLayout(new GridLayout(7,2));

        JLabel info = new JLabel("Please select options for the traffic simulation");
        JLabel rowLabel = new JLabel("Row count:");
        JSlider rowSlider = new JSlider(JSlider.HORIZONTAL, 15);
        JLabel columnLabel = new JLabel("Column count:");
        JSlider columnSlider = new JSlider(JSlider.HORIZONTAL, 15);
        JLabel carLabel = new JLabel("Initial Car Count:");
        JSlider carSlider = new JSlider(JSlider.HORIZONTAL, 45);

        /**/

    }

}
