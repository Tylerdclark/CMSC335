/*
 * *****************************************************************************
 * FILE: EastWestRoad.java
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
 * cars this object holds. I should have named it HorizontalRoad...
 */
public class EastWestRoad extends Road{

    final int roadMedianY, canvasWidth;
    final int leftSideY, rightSideY;

    /**
     * Constructor of the horizontal road which will hold and draw cars. Pass the middle of the road because it was
     * better to abstract some of the drawing math away.
     *
     * @param roadMedianY middle of the road
     * @param canvasWidth how wide the canvas is and how long the road will be
     */
    public EastWestRoad(int roadMedianY, int canvasWidth){
        this.roadMedianY = roadMedianY;
        this.canvasWidth = canvasWidth;
        this.leftSideY = roadMedianY-5;
        this.rightSideY = roadMedianY+5;
        this.length = canvasWidth;
        this.cars = new ArrayList<>();
        this.trafficLights = new ArrayList<>();
    }

    /**
     * Draws this road and the cars on it
     * @param graphics to draw with
     */
    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(0, leftSideY, canvasWidth, leftSideY);
        graphics.drawLine(0, rightSideY, canvasWidth, rightSideY);

        for (Car car : cars) {
            car.draw(graphics);
        }
    }
}
