/*
 * *****************************************************************************
 * FILE: Cylinder.java
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 28 OCT 2020
 * *****************************************************************************
 */
package dev.tylerdclark.three_dimensional;

/**
 * This class has a constructor that allows cylinder objects to use
 * {@link #volume()} method to calculate the area based on the {@link #radius}
 * and {@link #height} passed as arguments.
 */
public class Cylinder extends ThreeDimensionalShape {

    private final int radius, height;

    /**
     * Creates a cylinder object that can call {@link #volume()} method to calculate
     * volume
     * 
     * @param radius the distance from the center pole to the outside
     * @param height how tall the cylinder is
     */
    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    /**
     * Calculates the volume of the cylinder using the formula: pi * r^2 * h
     * 
     * @return calculated volume of this cylinder
     */
    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
