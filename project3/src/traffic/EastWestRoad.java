package traffic;

import java.awt.*;

public class EastWestRoad extends Road{

    final int roadMedianY, canvasWidth;
    final int leftSidePathY, rightSidePathY;

    public EastWestRoad(int roadMedianY, int canvasWidth){
        this.roadMedianY = roadMedianY;
        this.canvasWidth = canvasWidth;
        this.leftSidePathY = roadMedianY-10;
        this.rightSidePathY = roadMedianY;
        this.length = canvasWidth;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(0, roadMedianY-10, canvasWidth, roadMedianY-10);
        graphics.setColor(Color.yellow);
        graphics.drawLine(0, roadMedianY, canvasWidth, roadMedianY);
        graphics.setColor(Color.white);
        graphics.drawLine(0, roadMedianY+10, canvasWidth, roadMedianY+10);

        for (Car car : cars) {
            car.draw(graphics);
        }
    }
}
