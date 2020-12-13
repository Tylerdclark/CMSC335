package traffic;

import java.awt.*;
import java.util.ArrayList;

public class NorthSouthRoad extends Road{

    final int roadMedianX, canvasHeight;
    final int leftSideX, rightSideX;
    static int counter = 1;

    public NorthSouthRoad(int roadMedianX, int canvasHeight) {
        this.roadMedianX = roadMedianX;
        this.canvasHeight = canvasHeight;
        this.leftSideX = roadMedianX-5;
        this.rightSideX = roadMedianX+5;
        this.length = canvasHeight;
        int id = counter++;
        this.cars = new ArrayList<>();
        this.trafficLights = new ArrayList<>();
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(leftSideX, 0, leftSideX, canvasHeight);
        graphics.drawLine(rightSideX, 0, rightSideX, canvasHeight);

        for (Car car : this.cars) {
            car.draw(graphics);
        }
    }

}
