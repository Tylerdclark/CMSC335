/*
 * *****************************************************************************
 * FILE: Car.java
 * NAME: Tyler D Clark
 * PROJECT: Project 3
 * COURSE: CMSC 335
 * DATE: 13 Dec 2020
 * *****************************************************************************
 */

package traffic;

import util.LightStatus;
import util.Timer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Car class which will move through out the roads in the simulation. Works in a background thread.
 */
public class Car extends SwingWorker<Void, Void> {

    private static int counter = 1;
    private Road road;
    private util.Timer timer;
    private final Color color = new Color((int)(Math.random() * 0x1000000)); // Fun way to make random colors,
    private int x;                                                           // some can be hard to see tho..
    private int y;
    private final int id;
    private final Random random;
    private int speed;

    /**
     * Car Constructor which should only get called to make random cars.
     * @param road where the car will be placed
     */
    public Car(Road road){
        this.road = road;
        this.id = counter++;
        this.random = new Random();
        this.speed = random.nextInt(30) + 10; //give at least a bare minimum... they can be really slow
        System.out.println("Car #"+this.id+" created");

        if (road instanceof NorthSouthRoad){

                this.x = ((NorthSouthRoad) road).leftSideX;
                this.y = road.length-10;

        }
        if (road instanceof EastWestRoad){
                this.x = 0;
                this.y = ((EastWestRoad) road).leftSideY;
        }
    }

    /**
     * If the car is on a vertical road, will {@link #tryMoveNorth()} or {@link #tryMoveEast()} if on a horizontal road
     *
     * @return null
     * @throws Exception if unable to compute a result
     */
    @Override
    protected Void doInBackground() throws Exception {
        while (!timer.isStop()) {
            if (!timer.isPause()) {
                if (this.road instanceof NorthSouthRoad){
                    tryMoveNorth();
                }else {
                    tryMoveEast();
                }
            }
            Thread.sleep(1000);
        }
        return null;
    }

    public void tryMoveNorth() {
        ArrayList<Car> cars = road.getCars();
        ArrayList<TrafficLight> lights = road.getTrafficLights();
        ArrayList<Car> inTheWayCars = new ArrayList<>();
        ArrayList<TrafficLight> inTheWayLights = new ArrayList<>();
        int whereToGo = this.y - speed;

            // If any cars on road are in the distance to travel
            cars.forEach(car -> {
                if (car.y >= whereToGo && car.y < this.y){
                 inTheWayCars.add(car);
                }
            });
            if (inTheWayCars.size() > 0){
                /* Maybe instead, we can make the move method always 5 marks behind them */
                slowForSlowCars(inTheWayCars);
            }
            // Check for intersection
            lights.forEach(trafficLight -> {
                if (trafficLight.nsLightY >= whereToGo && trafficLight.nsLightY < this.y){
                    inTheWayLights.add(trafficLight);
                }
            });
            // Stop if it is red, Go forward or turn if it is green
            if (inTheWayLights.size() > 0){
                TrafficLight light = inTheWayLights.get(0);
                if (light.nsStatus == LightStatus.STOP) {
                    // move to directly before the light
                    moveNorth(this.y - light.nsLightY - 5);
                } else if(light.nsStatus == LightStatus.GO){
                    if(random.nextBoolean()){
                        moveNorth(this.speed);
                    }else{
                        turnEast(light);
                    }
                }
            }else{
                moveNorth(this.speed);
            }
    }

    private void tryMoveEast(){
        ArrayList<Car> cars = road.getCars();
        ArrayList<TrafficLight> lights = road.getTrafficLights();
        ArrayList<Car> inTheWayCars = new ArrayList<>();
        ArrayList<TrafficLight> inTheWayLights = new ArrayList<>();
        int whereToGo = this.x + speed;
            // If any cars on road are in the distance to travel
            cars.forEach(car -> {
                if (car.x <= whereToGo && car.x > this.x){
                    inTheWayCars.add(car);
                }
            });
            if (inTheWayCars.size() > 0){
                slowForSlowCars(inTheWayCars);
            }
            //check for intersection
            lights.forEach(trafficLight -> {
                if (trafficLight.ewLightX <= whereToGo && trafficLight.ewLightX > this.x){
                    inTheWayLights.add(trafficLight);
                }
            });
            // Stop if it is red, Go forward or turn if it is green
            if (inTheWayLights.size() > 0){
                TrafficLight light = inTheWayLights.get(0);
                if (light.ewStatus == LightStatus.STOP) {
                    // move to directly before the light
                    moveEast(light.ewLightX - this.x - 5); //
                } else if(light.ewStatus == LightStatus.GO){
                    if(random.nextBoolean()){
                        moveEast(this.speed);
                    }else{
                        turnNorth(light);
                    }
                }
            }else{
                moveEast(this.speed);
            }
    }

    private void slowForSlowCars(ArrayList<Car> inTheWayCars) {

            final int[] slowestSpeed = {this.speed};
            inTheWayCars.forEach(car -> {
                if (car.speed < slowestSpeed[0]) {
                    slowestSpeed[0] = car.speed;
                }
            });
            this.speed = slowestSpeed[0];
    }

    private void moveEast(int distance){
        this.x+=distance;
        if (this.x >= this.road.length){
            this.x = 0;
        }
    }
    private void moveNorth(int distance){
        this.y-=distance;
        if(this.y <= 0){
            this.y = this.road.length-10;
        }
    }
    private void turnEast(TrafficLight light){
        int distanceToLight = this.y - light.nsLightY;
        int leftOver = this.speed - distanceToLight;
        moveNorth(distanceToLight);
        light.ewRoad.addCar(this);
        this.road = light.ewRoad;
        this.y = light.ewRoad.leftSideY;
        moveEast(leftOver);

    }
    private void turnNorth(TrafficLight light){
        int distanceToLight = light.ewLightX - this.x;
        int leftOver = this.speed - distanceToLight;
        moveEast(distanceToLight);
        light.nsRoad.addCar(this);
        this.road = light.nsRoad;
        this.x = light.nsRoad.leftSideX;
        moveNorth(leftOver);
    }

    public void draw(Graphics graphics){
        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y,10,10 );
    }

    public void passTimer(Timer timer){
        this.timer = timer;
    }
    @Override
    protected void done() {
        System.out.println("Car "+ this.id + " is done");
    }
}


