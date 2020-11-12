/*
 * *****************************************************************************
 * FILE: ThreeDimensionalShape.java
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 28 OCT 2020
 * *****************************************************************************
 */

package dev.tylerdclark.three_dimensional;

/**
 * This class has a constructor that allows torus objects to use
 * {@link #volume()} method to calculate the area based on the
 * {@link #innerRadius} and {@link #outerRadius} passed as arguments.
 */
public class Torus extends ThreeDimensionalShape {
    private int innerRadius, outerRadius;

    /**
     * Creates a torus object which can call the {@link #volume()} method to
     * calculate volume
     * 
     * @param innerRadius radius inside the torus shape
     * @param outerRadius distance from the center of the hole to the center of the
     *                    inner shape
     */
    public Torus(int innerRadius, int outerRadius) {
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    public Torus() {

    }

    /**
     * Uses the formula 2 * pi^2 * R * r^2 to calculate volume
     * 
     * @return calculated volume of this torus
     */
    @Override
    public double volume() {
        return 2 * Math.pow(Math.PI, 2) * outerRadius * Math.pow(innerRadius, 2);
    }

    @Override
    public String[] getSpecifications() {
        return new String[]{"Inner Radius", "Outer Radius"};
    }
}
