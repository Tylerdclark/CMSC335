/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 28 OCT 2020
 * *****************************************************************************
 */
package dev.tylerdclark.three_dimensional;

/**
 * This class has a constructor that allows sphere objects to use
 * {@link #volume()} method to calculate the area based on the {@link #radius}
 * passed as an argument.
 */
public class Sphere extends ThreeDimensionalShape {

    private final int radius;

    /**
     * Constructor to create Sphere objects which can call {@link #volume()} to
     * calculate volume.
     * 
     * @param radius the distance from the center of sphere to any point on the
     *               surface
     */
    public Sphere(int radius) {

        this.radius = radius;
    }

    /**
     * Uses the formula 4/3 * pi * r^3 to calculate the volume of a sphere
     * 
     * @return The calculate volume based on this sphere.
     */
    @Override
    public double volume() {
        return 4.0d / 3.0d * Math.PI * Math.pow(radius, 3);
    }
}
