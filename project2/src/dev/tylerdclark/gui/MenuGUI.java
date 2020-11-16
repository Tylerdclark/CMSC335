package dev.tylerdclark.gui;

import dev.tylerdclark.Shape;
import dev.tylerdclark.three_dimensional.*;
import dev.tylerdclark.two_dimensional.*;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;

/*
todo: have an error message show when incorrect information is given. Have it show below the specifications
todo: redraw after the error is remedied
 */

public class MenuGUI extends JFrame {

    private final ArrayList<SpecificationPanel> panels = new ArrayList<>();
    private Shape currentShape;

    /**
     * Main constructor of the GUI objects. This GUI uses the default FlowLayout for ease since variable number
     * components are added and taken away. Contains an ActionListener for the JComboBox and one for the submit button.
     */
    public MenuGUI() {
        super("Project 2");
        this.setSize(400, 100);
        this.setLocationRelativeTo(null);
        Shape[] shapeList = new Shape[]{
                new Circle(), new Rectangle(), new Square(), new Triangle(),
                new Cone(), new Cube(), new Cylinder(), new Sphere(), new Torus()};
        JComboBox<dev.tylerdclark.Shape> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel introPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        /*
         * JCombobox ActionListener - Set index to -1 so that the ActionListener will fire when the first shape is
         * selected. This JComboBox will dynamically display the required specifications for the chosen shape.
         */
        shapeJComboBox.setSelectedIndex(-1);
        shapeJComboBox.addItemListener((event) -> {
            // first clear panels if there are any
            if (event.getStateChange() == ItemEvent.SELECTED) {
                for (JPanel p : panels) {
                    introPanel.remove(p);
                }
                panels.clear();
                introPanel.revalidate();
                this.currentShape = (Shape) event.getItem(); //get that shape
                String[] itemSpecifications = currentShape.getSpecifications();
                //get a panel with JLabels and JTextFields for every required shape input
                panels.add(new SpecificationPanel(itemSpecifications));
                for (JPanel p : panels) {
                    introPanel.add(p);
                }
                introPanel.add(submitButton);
            }
        });

        /*
         * Submit Button ActionListener - 
         */
        submitButton.addActionListener((event) -> {
            DrawFrame drawFrame = new DrawFrame(currentShape);
            try {
                ArrayList<Integer> values = new ArrayList<>();

                panels.forEach(
                        panel -> panel.getTextFields().forEach(
                                text -> values.add(Integer.parseInt(text.getText()))
                        )
                );

                currentShape.passValues(values);
                drawFrame.drawShape();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            drawFrame.setVisible(true);
        });

        introPanel.add(new JLabel("Please select a shape from the dropdown:"));
        introPanel.add(shapeJComboBox);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(introPanel);
        this.setVisible(true);
    }
}
