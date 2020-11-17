/*
 * *****************************************************************************
 * FILE: Triangle.java
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
    public JPanel getShapePanel(){

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(String.format("Base: %d, Height: %d", base, height), 0, 15);
                String stats = String.format("The Area of your Triangle is : %.2f", area());
                FontMetrics metrics = g.getFontMetrics();

                // https://i.redd.it/7inz78of1ch51.jpg
                int triX1 = (this.getWidth() / 2 ) - base;
                int triX2 = this.getWidth() / 2;
                int triX3 = (this.getWidth() / 2) + base;
                int triY1 = (this.getHeight() - height )/2;
                int triY2 = (this.getHeight() + height )/2;
                int stringX = (this.getWidth() - metrics.stringWidth(stats))/2;
                int stringY = triY1 + height + 15;

                //All triangle corner x coordinate
                int[]x={triX1,triX2,triX3};
                //All triangle corner y coordinate
                int[]y={triY2,triY1,triY2};

                g.drawString(stats, stringX ,stringY);
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
