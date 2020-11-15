package dev.tylerdclark.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpecificationPanel extends JPanel {

    private final ArrayList<JTextField> textFields = new ArrayList<>();

    public SpecificationPanel(String[] itemSpecifications) {

        this.setLayout(new GridLayout(1, itemSpecifications.length));

        for (String spec : itemSpecifications) {
            JLabel itemSpecLabel = new JLabel(spec);
            JTextField itemSpecTextField = new JTextField();

            textFields.add(itemSpecTextField);

            this.add(itemSpecLabel);
            this.add(itemSpecTextField);


        }
    }

    public ArrayList<JTextField> getTextFields() {
        return textFields;
    }
}
