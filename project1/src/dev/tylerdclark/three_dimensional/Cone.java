/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 28 OCT 2020
 * *****************************************************************************
 */
package dev.tylerdclark.three_dimensional;

public class Cone extends ThreeDimensionalShape{

    private final int baseRadius, height;

    /**
     * Constructor to create cone objects which can call {@link #volume()} to calculate
     * volume
     * @param baseRadius distance from the center of the base to the edge
     * @param height how tall the cone is to be
     */
    public Cone(int baseRadius, int height) {

        this.baseRadius = baseRadius;
        this.height = height;
    }

    /**
     * Uses the formula pi * r^2 * h / 3 to calculate the volume of a cone
     * @return The calculate volume based on this cone.
     */
    @Override
    public double volume() {
        return Math.PI * Math.pow(baseRadius, 2) * height / 3;
    }
}
