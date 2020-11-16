/*
 * *****************************************************************************
 * FILE: Rectangle.java
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
 * This class has a constructor that allows Rectangle objects to use
 * {@link #area()} method to calculate the area based on the {@link #width} and
 * {@link #height} passed as arguments.
 */
public class Rectangle extends TwoDimensionalShape {

    private int width, height;

    /**
     * Constructor method to initialize width and height fields and calculate
     * {@link #area()}
     */

    public Rectangle() {

    }

    /**
     * Uses the formula w * h to calculate the area of this rectangle
     * 
     * @return the area of the given rectangle
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Width", "Height"};
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

                int rectX = (this.getWidth() - width)/2;
                int rectY = (this.getHeight() - width )/2;
                int stringX = (this.getWidth() - metrics.stringWidth(stats))/2;
                int stringY = rectY + height + 15;

                g.drawRect(rectX, rectY , width, height);
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
        this.width = values.get(0);
        this.height = values.get(1);
    }
}
