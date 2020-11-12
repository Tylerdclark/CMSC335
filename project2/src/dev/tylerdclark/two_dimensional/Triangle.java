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
     * 
     * @param base   length of the base of the triangle
     * @param height length of the height of the triangle
     */
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

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

    @Override
    public String[] getSpecifications() {
        return new String[0];
    }
}
