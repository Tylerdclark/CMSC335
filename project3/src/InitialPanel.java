import javax.swing.*;
import java.awt.*;

public class InitialPanel {

    private final JPanel pnlMain;

    public InitialPanel(){

        pnlMain = new JPanel();
        pnlMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel info = new JLabel("Please select options for the traffic simulation");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 10);
        gbc.weightx = 1;
        pnlMain.add(info, gbc);





        JLabel rowLabel = new JLabel("Row count:");
        JSlider rowSlider = new JSlider(JSlider.HORIZONTAL, 15);
        JLabel columnLabel = new JLabel("Column count:");
        JSlider columnSlider = new JSlider(JSlider.HORIZONTAL, 15);
        JLabel carLabel = new JLabel("Initial Car Count:");
        JSlider carSlider = new JSlider(JSlider.HORIZONTAL, 45);

        /**/

    }

    public JPanel getPnlMain() {
        return pnlMain;
    }
}
