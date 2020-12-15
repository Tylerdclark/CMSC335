/*
 * *****************************************************************************
 * FILE: NorthSouthRoad.java
 * NAME: Tyler D Clark
 * PROJECT: Project 3
 * COURSE: CMSC 335
 * DATE: 13 Dec 2020
 * *****************************************************************************
 */

package traffic;

import java.awt.*;
import java.util.ArrayList;

/**
 * One of the two classes that extend the abstract Road class. Draws the lines and then calls the draw methods of the
 * cars this object holds. I should have named it VerticalRoad...
 */
public class NorthSouthRoad extends Road{

    final int roadMedianX, canvasHeight;
    final int leftSideX, rightSideX;

    /**
     * Constructor of the vertical road which will hold and draw cars. Pass the middle of the road because it was
     * better to abstract some of the drawing math away.
     *
     * @param roadMedianX middle of the road
     * @param canvasHeight how tall the canvas is and how long the road will be
     */
    public NorthSouthRoad(int roadMedianX, int canvasHeight) {
        this.roadMedianX = roadMedianX;
        this.canvasHeight = canvasHeight;
        this.leftSideX = roadMedianX-5;
        this.rightSideX = roadMedianX+5;
        this.length = canvasHeight;
        this.cars = new ArrayList<>();
        this.trafficLights = new ArrayList<>();
    }

    /**
     * Draws this road and the cars on it
     * @param graphics to draw with
     */
    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(leftSideX, 0, leftSideX, canvasHeight);
        graphics.drawLine(rightSideX, 0, rightSideX, canvasHeight);

        for (Car car : this.cars) {
            car.draw(graphics);
        }
    }
}
