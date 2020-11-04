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

/**
 * This class has a constructor that allows Circle objects to use
 * {@link #area()} method to calculate the area based on the {@link #radius}
 * length passed as an argument.
 */
public class Circle extends TwoDimensionalShape {

    private final int radius;

    /**
     * Constructor method to initialize radius field and calculate {@link #area()}
     * 
     * @param radius length of the line from the center to any point on circle's
     *               edge
     */
    public Circle(int radius) {
        this.radius = radius;
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

}
