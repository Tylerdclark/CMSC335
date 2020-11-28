import javax.swing.*;
import java.awt.*;

public class InitialPanel {

    private final JPanel pnlMain;

    public InitialPanel(){

        pnlMain = new JPanel();
        pnlMain.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel info = new JLabel("Please select options for the traffic simulation");
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 0, 10);
        pnlMain.add(info, gbc);

        JLabel rowLabel = new JLabel("Row count:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        pnlMain.add(rowLabel, gbc);

        JSlider rowSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 3);
        rowSlider.setMajorTickSpacing(9);
        rowSlider.setMinorTickSpacing(1);
        rowSlider.setPaintTicks(true);
        rowSlider.setPaintLabels(true);
        rowSlider.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        pnlMain.add(rowSlider, gbc);

        JLabel columnLabel = new JLabel("Column count:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 10, 0, 0);
        pnlMain.add(columnLabel, gbc);

        JSlider columnSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 3);
        columnSlider.setMajorTickSpacing(9);
        columnSlider.setMinorTickSpacing(1);
        columnSlider.setPaintTicks(true);
        columnSlider.setPaintLabels(true);
        columnSlider.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 10, 5, 10);
        pnlMain.add(columnSlider, gbc);

        JLabel carLabel = new JLabel("Initial Car Count:");
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        pnlMain.add(carLabel, gbc);

        JSlider carSlider = new JSlider(JSlider.HORIZONTAL, 1, 10, 3);
        carSlider.setMajorTickSpacing(9);
        carSlider.setMinorTickSpacing(1);
        carSlider.setPaintTicks(true);
        carSlider.setPaintLabels(true);
        carSlider.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5, 10, 5, 10);
        pnlMain.add(carSlider, gbc);


        JButton submitBtn = new JButton("Submit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 4;
        gbc.insets = new Insets(5, 10, 10, 5);
        pnlMain.add(submitBtn, gbc);
        
        submitBtn.addActionListener( event -> {
            System.out.println(rowSlider.getValue());
            System.out.println(columnSlider.getValue());
            System.out.println(carSlider.getValue());
     
        });
        /**/

    }

    public JPanel getPnlMain() {
        return pnlMain;
    }
}
