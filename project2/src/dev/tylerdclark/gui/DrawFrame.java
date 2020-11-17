/*
 * *****************************************************************************
 * FILE: DrawFrame.java
 * NAME: Tyler D Clark
 * PROJECT: Project 2
 * COURSE: CMSC 335
 * DATE: 12 Nov 2020
 * *****************************************************************************
 */
package dev.tylerdclark.gui;

import dev.tylerdclark.Shape;

import javax.swing.*;
import java.io.IOException;

/**
 * JFrame class that will display the drawn shape and calculated area or volume
 */
public class DrawFrame extends JFrame {

    private final Shape currentShape;

    /**
     * Creates a JFrame for the given shape. This JFrame will receive a JPanel from the shape object to display.
     *
     * @param currentShape the shape which will have measurements passed and will return a JPanel to be displayed
     */
    public DrawFrame(Shape currentShape) {
        super(currentShape.toString());
        this.currentShape = currentShape;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 375);
    }

    /**
     * Gets the JPanel from the chosen shape and sets it visible
     *
     * @throws IOException if there is issues with the image pathing for the 3d shapes
     */
    public void drawShape() throws IOException {
        JPanel shapePanel = currentShape.getShapePanel();
        this.setContentPane(shapePanel);
        this.setVisible(true);
    }

}
