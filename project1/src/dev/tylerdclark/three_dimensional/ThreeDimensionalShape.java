/*
 * *****************************************************************************
 * NAME: Tyler D Clark
 * PROJECT: Project 1
 * COURSE: CMSC 335
 * DATE: 25 OCT 2020
 * *****************************************************************************
 */

package dev.tylerdclark.three_dimensional;

import dev.tylerdclark.Shape;

/**
 * Class to be extended by Sphere, Cube, Cone, Cylinder, and Torus. Made abstract as no
 * instantiations of this class will be needed and implementation of {@link #volume()} will
 * depend on child class.
 */

public abstract class ThreeDimensionalShape extends Shape {
   /**
    * To be implemented with the volume formula specific to each shape.
    * @return the result from the calculation of volume
    */
   public abstract double volume();
}
