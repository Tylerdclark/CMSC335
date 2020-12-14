/*
 * *****************************************************************************
 * FILE: Road.java
 * NAME: Tyler D Clark
 * PROJECT: Project 3
 * COURSE: CMSC 335
 * DATE: 13 Dec 2020
 * *****************************************************************************
 */
package traffic;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class that the other roads will extend. Has some common functionalities from them both.
 */
public abstract class Road {
    ArrayList<TrafficLight> trafficLights;
    ArrayList<Car> cars;
    int length;

    /* Implement theeze pleeze */
    public void addCar(Car car) { cars.add(car); }
    public ArrayList<Car> getCars(){ return this.cars; }
    public void addTrafficLight(TrafficLight light){ trafficLights.add(light); }
    public ArrayList<TrafficLight> getTrafficLights() { return trafficLights; }
    public abstract void draw(Graphics g);
}
