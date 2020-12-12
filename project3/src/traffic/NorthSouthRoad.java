package traffic;

import java.awt.*;

public class NorthSouthRoad extends Road{

    final int roadMedianX, canvasHeight;
    final int leftSideX, rightSideX;
    private int id;
    static int counter = 1;

    public NorthSouthRoad(int roadMedianX, int canvasHeight) {
        this.roadMedianX = roadMedianX;
        this.canvasHeight = canvasHeight;
        this.leftSideX = roadMedianX-5;
        this.rightSideX = roadMedianX+5;
        this.length = canvasHeight;
        this.id = counter++;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(leftSideX, 0, leftSideX, canvasHeight);
        graphics.drawLine(rightSideX, 0, rightSideX, canvasHeight);

        for (Car car : this.cars) {
            car.draw(graphics);
        }
    }

    @Override
    public String toString() {
        return "NorthSouthRoad{" + "id=" + id + '}';
    }
}
