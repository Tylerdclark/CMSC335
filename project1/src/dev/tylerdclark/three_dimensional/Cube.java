/*
 * *****************************************************************************
 * FILE: Cube.java
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 28 OCT 2020
 * *****************************************************************************
 */
package dev.tylerdclark.three_dimensional;

/**
 * This class has a constructor that allows cube objects to use
 * {@link #volume()} method to calculate the area based on the {@link #edge}
 * length passed as argument.
 */
public class Cube extends ThreeDimensionalShape {

    private final int edge;

    /**
     * Constructor to create cube objects which can call {@link #volume()} to
     * calculate volume. Note that there is only needed one edge parameter because
     * all others are implied to be the same length.
     * 
     * @param edge length of one of the 12 edges of the cube
     */
    public Cube(int edge) {

        this.edge = edge;
    }

    /**
     * Uses the formula edge^3 to calculate the volume of a cube
     * 
     * @return The calculate volume based on this edge.
     */
    @Override
    public double volume() {
        return Math.pow(edge, 3);
    }
}
