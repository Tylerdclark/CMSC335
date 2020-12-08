/* I'm going to split the roads into two types, which will help when creating junctions and also
with the creation of roads */

import java.awt.*;
import java.util.ArrayList;

public class NorthSouthRoad {

    private final ArrayList<Car> cars = new ArrayList<>();
    private final int roadMedianX, canvasHeight;

    public NorthSouthRoad(int roadMedianX, int canvasHeight) {
        this.roadMedianX = roadMedianX;
        this.canvasHeight = canvasHeight;
    }

    void draw(Graphics graphics) {

        


        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
