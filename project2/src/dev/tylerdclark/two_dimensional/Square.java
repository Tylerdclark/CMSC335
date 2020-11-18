/*
 * *****************************************************************************
 * FILE: Square.java
 * NAME: Tyler D Clark
 * PROJECT: Project 2
 * COURSE: CMSC 335
 * DATE: 12 Nov 2020
 * *****************************************************************************
 */

package dev.tylerdclark.two_dimensional;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class has a constructor that allows square objects to use
 * {@link #area()} method to calculate the area based on the {@link #side}
 * length passed as an argument.
 */
public class Square extends TwoDimensionalShape {

    private int side;

    /**
     * Constructor method to initialize side length field and calculate
     * {@link #area()}. Keeping in mind that all sides of a square are the same, so
     * only one length is needed.
     */
    public Square() {
    }

    /**
     * Uses the formula s^2 to calculate the area of the square.
     * 
     * @return the calculated area of this square
     */
    @Override
    public double area() {
        return side * side;
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[] {"Sides"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawString(String.format("Side: %d", side), 0, 15);
                String stats = String.format("The Area of your Square is : %.2f", area());
                FontMetrics metrics = g.getFontMetrics();

                int rectX = (this.getWidth()-side)/2;
                int rectY = (this.getHeight()-side )/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = rectY+side+30;

                g.drawRect(rectX, rectY , side, side);
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
        this.side = values.get(0);
    }
}
