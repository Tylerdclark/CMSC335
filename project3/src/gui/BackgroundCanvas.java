/*
 * *****************************************************************************
 * FILE: BackgroundCanvas.java
 * NAME: Tyler D Clark
 * PROJECT: Project 3
 * COURSE: CMSC 335
 * DATE: 13 Dec 2020
 * *****************************************************************************
 */

package gui;

import traffic.*;
import util.Timer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The heavy worker of the program. This class creates a panel which is where all of the drawing will take place. Create
 * and draws the columns, rows, and cars. Also executes the workers when needed.
 */
public class BackgroundCanvas extends JPanel{

    private final int rowCount;
    private final int columnCount;
    private final int carCount;
    private final int width, height;
    ArrayList<Road> roads = new ArrayList<>();
    ArrayList<TrafficLight> trafficLights = new ArrayList<>();
    ArrayList<NorthSouthRoad> nsRoads = new ArrayList<>();
    ArrayList<EastWestRoad> ewRoads = new ArrayList<>();
    Timer timer;
    /* I found that there is an upper limit(10) on the number of the SwingWorkers. Need to use executor service to
    circumvent limit */
    ExecutorService executorService;

    /**
     * Main constructor that creates a drawing object which will be place on the main frame of the application.
     *
     * @param rowCount number of row of roads for the simulation
     * @param columnCount number of columns of roads for the simulation
     * @param carCount number of (initial) cars for the application
     */
     BackgroundCanvas(int rowCount, int columnCount, int carCount) {
         this.rowCount = rowCount;
         this.columnCount = columnCount;
         this.carCount = carCount;
         int EXTRA_CARS = 10; //give room to add 10 more cars
         this.executorService = Executors.newFixedThreadPool((rowCount * columnCount) + carCount + EXTRA_CARS + 1);

         /*
         * These are just magic numbers for now... maybe will fix ;)
         ******************************************************************************/
         this.width = 1000;
         this.height = 800;

         this.setPreferredSize(new Dimension(this.width, this.height));
         this.setBackground(Color.BLACK);
         initialize();
     }

    /**
     * This paints to the panel by calling each of the draw methods for the roads, which will in turn call the draw
     * methods for the cars. Additionally, it calls the draw method for the TrafficLight objects that this object has.
     * @param g graphics to draw to
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        roads.forEach(road -> road.draw(g));
        trafficLights.forEach(trafficLight -> trafficLight.draw(g));
    }

    /**
     * Adds a random car per the {@link #carCount} argument to the constructor using the {@link #addRandomCar()} method
     */
    public void populateCars(){
        for (int i = 0; i < carCount ; i++) {
            addRandomCar();
        }
    }

    /**
     * Takes a random road from those create and adds a car to the road.
     * @return returns the car to be executed
     */
    public Car addRandomCar(){
        Random random = new Random();
        Road road = roads.get(random.nextInt(roads.size()));
        Car car = new Car(road);
        road.addCar(car);
        this.revalidate();
        return car;
    }

    /**
     * Passes a timer which will allow the simulation to pause, stop and play. This object also gets passed to the
     * SwingWorkers.
     * @param timer timer object to be passed to this object and the object members of the class
     */
    public void passTimer(Timer timer){
        this.timer = timer;
        trafficLights.forEach(trafficLight ->
                trafficLight.passTimer(timer)
        );
        roads.forEach(road -> {
            ArrayList<Car> cars = road.getCars();
            cars.forEach( car -> car.passTimer(timer));
        });
    }

    /**
     * creates the roads and passes their draw values (which took a lot of head scratching to figure out) also creates
     * the correct number of traffic lights and {@link #populateCars()}
     */
    public void initialize() {

        System.out.println("New background initialized");
        int firstX = width / (columnCount+1);
        int firstY = height / (rowCount+1);

        for (int i = 1; i <= this.columnCount; i++) {
            int currentRoadX = firstX * i;
            NorthSouthRoad road = new NorthSouthRoad(currentRoadX, height);
            roads.add(road);
            nsRoads.add(road);
        }
        for (int i = 1; i <= this.rowCount; i++) {
            int currentRoadY = firstY * i;
            EastWestRoad road = new EastWestRoad(currentRoadY, width);
            roads.add(road);
            ewRoads.add(road);
        }
        nsRoads.forEach(nsRoad -> ewRoads.forEach(ewRoad -> {
            TrafficLight trafficLight = new TrafficLight(nsRoad, ewRoad);
            nsRoad.addTrafficLight(trafficLight);
            ewRoad.addTrafficLight(trafficLight);
            trafficLights.add(trafficLight);
        }));

        populateCars();
    }

    /**
     * The Cars and TrafficLights extend SwingWorker and through this method they are executed. They will be immediately
     * "done" if the Cars and TrafficLights have a null Timer.
     */
    public void executeWorkers(){
        roads.forEach(road -> {
            ArrayList<Car> cars = road.getCars();
            /* cars.forEach(SwingWorker::execute); // this is for w/o executor */
            cars.forEach(car -> executorService.submit(car));
        });
        /* trafficLights.forEach(SwingWorker::execute); //this is for w/o executor */
        trafficLights.forEach(light -> executorService.submit(light));
    }
    /* The getters - self explanatory */
    public int getRowCount(){ return this.rowCount; }
    public int getColumnCount() { return columnCount; }
    public int getCarCount() { return carCount; }
}
