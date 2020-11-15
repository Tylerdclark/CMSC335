/*
 * *****************************************************************************
 * FILE: Square.java
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 27 OCT 2020
 * *****************************************************************************
 */

package dev.tylerdclark.two_dimensional;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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
    public JPanel getShape() throws IOException {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                int margin = 10;
                Dimension dim = getSize();
                super.paintComponent(g);
                g.drawRect(0, 0, 100, 100);
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
