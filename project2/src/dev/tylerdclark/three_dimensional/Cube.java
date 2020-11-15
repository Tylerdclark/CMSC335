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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class has a constructor that allows cube objects to use
 * {@link #volume()} method to calculate the area based on the {@link #edge}
 * length passed as argument.
 */
public class Cube extends ThreeDimensionalShape {

    private int edge;

    /**
     * Constructor to create cube objects which can call {@link #volume()} to
     * calculate volume. Note that there is only needed one edge parameter because
     * all others are implied to be the same length.
     */
    public Cube() {}

    /**
     * Uses the formula edge^3 to calculate the volume of a cube
     * 
     * @return The calculate volume based on this edge.
     */
    @Override
    public double volume() {
        return Math.pow(edge, 3);
    }

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Edge"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShape() throws IOException {
        final BufferedImage image = ImageIO.read(new File("src/dev/tylerdclark/img/Cube.jpg"));
        Image reScaledImage = image.getScaledInstance(300, 300, image.getType());

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(reScaledImage, 0, 0, null);
            }
        };
    }

    /**
     * Passes values to the objects in a way that shapes with varying parameter counts can implement.
     *
     * @param values an arraylist of integers. First index is the first initialized data member and so on.
     */
    @Override
    public void passValues(ArrayList<Integer> values) {
        this.edge = values.get(0);
    }
}
