package dev.tylerdclark.gui;

import javax.swing.*;
import java.awt.*;

public class SpecificationPanel extends JPanel {

    public SpecificationPanel(String[] itemSpecifications) {
        this.setLayout(new GridLayout(1, itemSpecifications.length));

        for (String spec : itemSpecifications) {
            JLabel itemSpecLabel = new JLabel(spec);
            JTextField itemSpecTextField = new JTextField();

            this.add(itemSpecLabel);
            this.add(itemSpecTextField);

        }
    }
}
