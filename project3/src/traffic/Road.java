package traffic;

import java.awt.*;
import java.util.ArrayList;

public abstract class Road {
    ArrayList<TrafficLight> trafficLights;
    ArrayList<Car> cars;
    int length;

    public void addCar(Car car) {
        cars.add(car);
    }
    public ArrayList<Car> getCars(){
        return this.cars;
    }
    public void addTrafficLight(TrafficLight light){ trafficLights.add(light); }
    public abstract void draw(Graphics g);
}
