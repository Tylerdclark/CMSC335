package traffic;/* I'm going to split the roads into two types, which will help when creating junctions and also
with the creation of roads */

import java.awt.*;

public class NorthSouthRoad extends Road{
    final int roadMedianX, canvasHeight;
    final int leftSidePathX, rightSidePathX;

    public NorthSouthRoad(int roadMedianX, int canvasHeight) {
        this.roadMedianX = roadMedianX;
        this.canvasHeight = canvasHeight;
        this.leftSidePathX = roadMedianX - 5;
        this.rightSidePathX = roadMedianX + 5;
        this.length = canvasHeight;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(roadMedianX-10, 0, roadMedianX-10, canvasHeight);
        graphics.setColor(Color.yellow);
        graphics.drawLine(roadMedianX, 0, roadMedianX, canvasHeight);
        graphics.setColor(Color.white);
        graphics.drawLine(roadMedianX+10, 0, roadMedianX+10, canvasHeight);

        for (Car car : this.cars) {
            car.draw(graphics);
        }
    }


}
