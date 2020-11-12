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
     * 
     * @param side the length of the sides
     */
    public Square(int side) {
        this.side = side;
    }

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
}
