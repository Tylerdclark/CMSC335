/*
 * *****************************************************************************
 * FILE: TwoDimensionalShape.java
 * NAME: Tyler D Clark
 * PROJECT: Project 2
 * COURSE: CMSC 335
 * DATE: 12 Nov 2020
 * *****************************************************************************
 */

package dev.tylerdclark.two_dimensional;

import dev.tylerdclark.Shape;

/**
 * Class to be extended by circle, square, triangle, and rectangle. Made
 * abstract as no instantiations of this class will be needed and implementation
 * of {@link #area()} will depend on child class.
 */
public abstract class TwoDimensionalShape extends Shape {
    /**
     * To be implemented with the area formula specific to each shape.
     * 
     * @return the result from the calculation of area
     */
    public abstract double area();
}
