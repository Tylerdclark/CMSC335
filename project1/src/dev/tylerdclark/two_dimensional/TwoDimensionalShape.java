/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 25 OCT 2020
 * *****************************************************************************
 */

package dev.tylerdclark.two_dimensional;

import dev.tylerdclark.Shape;

/**
 * Class to be extended by circle, square, triangle, and rectangle. Made
 * abstract as no instantiations of this class will be needed and implementation
 * of {@link #area()} will depend on child class. Calling toString will print
 * area information.
 */
public abstract class TwoDimensionalShape extends Shape {
    /**
     * To be implemented with the area formula specific to each shape.
     * 
     * @return the result from the calculation of area
     */
    public abstract double area();

    @Override
    public String toString() {
        return String.format("The area of the %s is %.1f.", getClass().getSimpleName(), area());
    }
}
