/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 25 OCT 2020
 * *****************************************************************************
 */

package dev.tylerdclark.two_dimensional;

public class Rectangle extends TwoDimensionalShape{

    private final int width, height;

    /**
     * Constructor method to initialize width and height fields and calculate {@link #area()}
     * @param width How wide the rectangle is to be
     * @param height How tall the rectangle is to be
     */
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    /**
     * Uses the formula w * h to calculate the area of this rectangle
     * @return the area of the given rectangle
     */
    @Override
    public double area() {
        return width * height;
    }
    
}