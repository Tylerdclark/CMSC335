package dev.tylerdclark;

import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JFrame {
    JComboBox<Shape> shapeJComboBox;

    public MenuGUI(String title) {
        super(title);

        JPanel introPanel = new JPanel();
        introPanel.add(new JLabel("Please select a shape from the dropdown:"));


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
