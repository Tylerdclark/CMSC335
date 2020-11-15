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

    dev.tylerdclark.Shape[] shapeList = new dev.tylerdclark.Shape[] { new Circle(), new Rectangle(), new Square(), new Triangle(), new Cone(),
            new Cube(), new Cylinder(), new Sphere(), new Torus() };
            
    ArrayList<SpecificationPanel> panels = new ArrayList<>();
    Shape currentShape;

    public MenuGUI(String title) {
        super(title);
        this.setSize(400, 100);
        this.setLocationRelativeTo(null);
        JComboBox<dev.tylerdclark.Shape> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel introPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        shapeJComboBox.setSelectedIndex(-1);
        shapeJComboBox.addItemListener((event) -> {

            if (event.getStateChange() == ItemEvent.SELECTED) {
                for (JPanel p: panels) {
                    introPanel.remove(p);
                }
                panels.clear();
                introPanel.revalidate();
                currentShape = (Shape) event.getItem();
                String[] itemSpecifications = currentShape.getSpecifications();

                panels.add(new SpecificationPanel(itemSpecifications));

                for (JPanel p: panels) {
                    introPanel.add(p);
                }
                introPanel.add(submitButton);

            }
        });

        submitButton.addActionListener((event) -> {

            DrawFrame drawFrame = new DrawFrame(currentShape);

            try {
                ArrayList<Integer> values = new ArrayList<>();

                panels.forEach( panel ->
                        panel.getTextFields().forEach(text ->
                                values.add(Integer.parseInt(text.getText()))
                        )
                );


                currentShape.passValues(values);
                values.forEach(System.out::println);
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
