package dev.tylerdclark;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MenuGUI extends JFrame {
    String[] shapeList = new String[]{"Circle", "Rectangle", "Square", "Triangle", "Cone", "Cube", "Cylinder", "Sphere", "Torus"};

    public MenuGUI(String title) {
        super(title);
        JComboBox<String> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel introPanel = new JPanel();
        JButton submitButton = new JButton("Submit");

        shapeJComboBox.addItemListener(e -> {
            System.out.println(e.getItem());
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
    private Object getShapeObject(String className, Object ctorArgument) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName(className);
        Constructor<?> ctor = clazz.getConstructor(String.class);

        return ctor.newInstance(ctorArgument);
    }
}
