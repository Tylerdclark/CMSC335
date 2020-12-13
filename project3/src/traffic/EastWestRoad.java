package traffic;

import java.awt.*;
import java.util.ArrayList;

public class EastWestRoad extends Road{

    final int roadMedianY, canvasWidth;
    final int leftSideY, rightSideY;
    static int counter = 1;

    public EastWestRoad(int roadMedianY, int canvasWidth){
        this.roadMedianY = roadMedianY;
        this.canvasWidth = canvasWidth;
        this.leftSideY = roadMedianY-5;
        this.rightSideY = roadMedianY+5;
        this.length = canvasWidth;
        int id = counter++;
        this.cars = new ArrayList<>();
        this.trafficLights = new ArrayList<>();
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(0, leftSideY, canvasWidth, leftSideY);
        graphics.drawLine(0, rightSideY, canvasWidth, rightSideY);

        for (Car car : cars) {
            car.draw(graphics);
        }
    }
}
