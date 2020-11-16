package dev.tylerdclark.gui;

import javax.swing.*;
import java.util.ArrayList;

public class SpecificationPanel extends JPanel {

    private final ArrayList<JTextField> textFields = new ArrayList<>();

    public SpecificationPanel(String[] itemSpecifications) {

        for (String spec : itemSpecifications) {
            JLabel itemSpecLabel = new JLabel(spec);
            JTextField itemSpecTextField = new JTextField(2);

            textFields.add(itemSpecTextField);

            this.add(itemSpecLabel);
            this.add(itemSpecTextField);

        }
    }

    public ArrayList<JTextField> getTextFields() {
        return textFields;
    }
}
