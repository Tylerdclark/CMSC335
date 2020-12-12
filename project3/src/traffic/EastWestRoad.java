package traffic;

import java.awt.*;

public class EastWestRoad extends Road{

    final int roadMedianY, canvasWidth;
    final int leftSideY, rightSideY;
    static int counter = 1;
    private int id;

    public EastWestRoad(int roadMedianY, int canvasWidth){
        this.roadMedianY = roadMedianY;
        this.canvasWidth = canvasWidth;
        this.leftSideY = roadMedianY-5;
        this.rightSideY = roadMedianY+5;
        this.length = canvasWidth;
        this.id = counter++;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(0, leftSideY, canvasWidth, leftSideY);
        graphics.drawLine(0, rightSideY, canvasWidth, rightSideY);

        for (Car car : cars) {
            car.draw(graphics);
        }
    }

    @Override
    public String toString() {
        return "EastWestRoad{" + "id=" + id + '}';
    }
}
