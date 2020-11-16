/*
 * *****************************************************************************
 * FILE: Shape.java
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 25 OCT 2020
 * *****************************************************************************
 */

package dev.tylerdclark;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class exists mainly for other classes of project to extend. Made
 * abstract since it is designed to be subclassed. It implicitly extends
 * {@link Object}.
 */
public abstract class Shape {

    /**
     * Used to properly display the required fields of each shape object
     * 
     * @return an array of required fields for shape creation
     */
    public abstract String[] getSpecifications();

    /**
     * Prints the name of the class
     * 
     * @return String name of the class
     */
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the
     * object.
     * 
     * @return returns a JPanel containing the shape
     */
    public abstract JPanel getShape() throws IOException;

    /**
     * Passes values to the objects in a way that shapes with varying parameter
     * counts can implement.
     * 
     * @param values an arraylist of integers. First index is the first initialized
     *               data member and so on.
     */
    public abstract void passValues(ArrayList<Integer> values);
}