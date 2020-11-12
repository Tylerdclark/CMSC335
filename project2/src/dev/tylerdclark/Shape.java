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

/**
 * This class exists mainly for other classes of project to extend. Made abstract
 * since it is designed to be subclassed. It implicitly extends {@link Object}.
 */
public abstract class Shape {

    /**
     * Used to properly display the required fields of each shape object
     * @return an array of required fields for shape creation
     */
    public abstract String[] getSpecifications();

    /**
     * Prints the name of the class
     * @return String name of the class
     */
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}