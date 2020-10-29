package dev.tylerdclark.three_dimensional;

public class Cylinder extends ThreeDimensionalShape{

    private final int radius, height;

    /**
     * Creates a cylinder object that can call {@link #volume()} method to calculate volume
     * @param radius the distance from the center pole to the outside
     * @param height how tall the cylinder is
     */
    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    /**
     * Calculates the volume of the cylinder using the formula: pi * r^2 * h
     * @return calculated volume of this cylinder
     */
    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
