/*
 * *****************************************************************************
 * FILE: Circle.java
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 25 OCT 2020
 * *****************************************************************************
 */
package dev.tylerdclark.two_dimensional;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class has a constructor that allows Circle objects to use
 * {@link #area()} method to calculate the area based on the {@link #radius}
 * length passed as an argument.
 */
public class Circle extends TwoDimensionalShape {

    private int radius, width, height;

    /**
     * Constructor method to initialize radius field and calculate {@link #area()}
     */
    public Circle() {
    }

    /**
     * Uses formula: pi * r^2 to calculate the area of this circle
     *
     * @return the area of a circle based on given radius
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Radius"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShape(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                String stats = String.format("The Area of your shape is : %.2f", area());
                FontMetrics metrics = g.getFontMetrics();

                int circleX = (this.getWidth() - radius)/2;
                int circleY = (this.getHeight() - radius )/2;
                int stringX = (this.getWidth() - metrics.stringWidth(stats))/2;
                int stringY = circleY + radius + 15;

                g.drawOval(circleX, circleY , radius, radius);
                g.drawString(stats, stringX ,stringY);

            }
        };
    }
    /**
     * Passes values to the objects in a way that shapes with varying parameter counts can implement.
     *
     * @param values an arraylist of integers. First index is the first initialized data member and so on.
     */
    @Override
    public void passValues(ArrayList<Integer> values) {
        this.radius = values.get(0);
    }
}