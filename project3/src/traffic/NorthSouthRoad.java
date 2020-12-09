package traffic;/* I'm going to split the roads into two types, which will help when creating junctions and also
with the creation of roads */

import java.awt.*;
import java.util.ArrayList;

public class NorthSouthRoad {

    private final ArrayList<Car> cars = new ArrayList<>();
    private final int roadMedianX, canvasHeight;
    private final int leftSidePathX, rightSidePathX;

    public NorthSouthRoad(int roadMedianX, int canvasHeight) {
        this.roadMedianX = roadMedianX;
        this.canvasHeight = canvasHeight;
        this.leftSidePathX = roadMedianX - 5;
        this.rightSidePathX = roadMedianX + 5;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.drawLine(roadMedianX-10, 0, roadMedianX-10, canvasHeight);
        graphics.setColor(Color.yellow);
        graphics.drawLine(roadMedianX, 0, roadMedianX, canvasHeight);
        graphics.setColor(Color.white);
        graphics.drawLine(roadMedianX+10, 0, roadMedianX+10, canvasHeight);

        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
