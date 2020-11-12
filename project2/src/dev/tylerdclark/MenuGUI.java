package dev.tylerdclark;

import dev.tylerdclark.three_dimensional.*;
import dev.tylerdclark.two_dimensional.Circle;
import dev.tylerdclark.two_dimensional.Rectangle;
import dev.tylerdclark.two_dimensional.Square;
import dev.tylerdclark.two_dimensional.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;



public class MenuGUI extends JFrame {

    Shape[] shapeList = new Shape[]{
            new Circle(), new Rectangle(), new Square(), new Triangle(), new Cone(),
            new Cube(), new Cylinder(), new Sphere(), new Torus() };

    public MenuGUI(String title) {
        super(title);
        JComboBox<Shape> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel introPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        shapeJComboBox.setSelectedIndex(-1);
        shapeJComboBox.addItemListener( (event) -> {

            if (event.getStateChange() == ItemEvent.SELECTED){
                Shape item = (Shape) event.getItem();
                String[] itemSpecifications = item.getSpecifications();
                for (String spec: itemSpecifications) {
                    System.out.println(spec);
                }
                System.out.println(item);

            }
        });


        submitButton.addActionListener((event) -> {
            System.out.println(shapeJComboBox.getSelectedItem());
        });

        introPanel.add(new JLabel("Please select a shape from the dropdown:"));
        introPanel.add(shapeJComboBox);
        introPanel.add(submitButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(introPanel);
        this.pack();
    }

    private static void addComponents(Panel panel, Component[] components){
        for (Component component: components) {
            panel.add(component);
        }
    }
}
