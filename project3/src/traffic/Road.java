package traffic;

import java.awt.*;
import java.util.ArrayList;

public abstract class Road {

    ArrayList<Car> cars = new ArrayList<>();
    int length;

    public void addCar(Car car) {
        cars.add(car);
    }
    public ArrayList<Car> getCars(){
        return this.cars;
    }

    public abstract void draw(Graphics g);
}
