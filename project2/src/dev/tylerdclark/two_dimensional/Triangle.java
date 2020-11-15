/*
 * *****************************************************************************
 * FILE: Triangle.java
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
 * This class has a constructor that allows triangle objects to use
 * {@link #area()} method to calculate the area based on the {@link #base} and
 * {@link #height} passed as arguments.
 */
public class Triangle extends TwoDimensionalShape {

    private int base, height;

    /**
     * Constructor method to initialize base and height fields and calculate
     * {@link #area()}
     */
    public Triangle() {

    }

    /**
     * Using the formula: b * h / 2 to calculate the area
     * 
     * @return the calculated area of the triangle
     */
    @Override
    public double area() {
        return (base * height) / 2.0d;
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Base", "Height"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShape() throws IOException {

        //All triangle corner x coordinate
        int[]x={0,150,300};

        //All triangle corner y coordinate
        int[]y={200,0,200};


        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawPolygon( x, y, 3);
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
        this.base = values.get(0);
        this.height = values.get(1);
    }
}
