package dev.tylerdclark;

import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JFrame {
    String[] shapeList = new String[]{"Circle", "Rectangle", "Square", "Triangle", "Cone", "Cube", "Cylinder", "Sphere", "Torus"};

    public MenuGUI(String title) {
        super(title);
        JComboBox<String> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel introPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        introPanel.add(new JLabel("Please select a shape from the dropdown:"));
        introPanel.add(shapeJComboBox);

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
