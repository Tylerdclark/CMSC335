/*
 * *****************************************************************************
 * FILE: Sphere.java
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
 * This class has a constructor that allows sphere objects to use
 * {@link #volume()} method to calculate the area based on the {@link #radius}
 * passed as an argument.
 */
public class Sphere extends ThreeDimensionalShape {

    private int radius;

    /**
     * Constructor to create Sphere objects which can call {@link #volume()} to
     * calculate volume.
     */
    public Sphere() {
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

    /**
     * Used to properly display the required fields of each shape object
     *
     * @return an array of required fields for shape creation
     */
    @Override
    public String[] getSpecifications() {
        return new String[]{"Radius"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShape() throws IOException {
        final BufferedImage image = ImageIO.read(new File("src/dev/tylerdclark/img/sphere.jpg"));
        Image reScaledImage = image.getScaledInstance(300, 300, image.getType());

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int imageX = (this.getWidth() - reScaledImage.getWidth(null)  )/2;
                int imageY = (this.getHeight() - reScaledImage.getHeight(null))/2;
                g.drawImage(reScaledImage, imageX, imageY, null);
                int stringY = imageY + (reScaledImage.getHeight(null)) + 15;
                g.drawString(String.format("The Volume of your shape is : %.2f", volume()), imageX ,stringY);
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
        this.radius = values.get(0);
    }
}
