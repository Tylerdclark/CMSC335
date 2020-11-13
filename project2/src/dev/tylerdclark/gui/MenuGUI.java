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

    Shape[] shapeList = new Shape[] { new Circle(), new Rectangle(), new Square(), new Triangle(), new Cone(),
            new Cube(), new Cylinder(), new Sphere(), new Torus() };
            
    JPanel panel = new JPanel();

    public MenuGUI(String title) {
        super(title);
        this.setSize(400, 200);
        JComboBox<Shape> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel introPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        shapeJComboBox.setSelectedIndex(-1);
        shapeJComboBox.addItemListener((event) -> {

            if (event.getStateChange() == ItemEvent.SELECTED) {

                Shape item = (Shape) event.getItem();
                String[] itemSpecifications = item.getSpecifications();

                panel = new JPanel(new GridLayout(1, itemSpecifications.length));

                for (String spec : itemSpecifications) {
                    panel.add(new JLabel(spec));
                    panel.add(new JTextField());

                }
                System.out.println(item);
                introPanel.add(panel);
                introPanel.updateUI();

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
        // this.pack();
    }
}
