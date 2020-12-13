package gui;

import traffic.*;
import util.Timer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BackgroundCanvas extends JPanel{
    /* todo: I found that there is an upper limit(10) on the number of the SwingWorkers. Need to use executor service to circumvent limit */

    private final int rowCount;
    private final int columnCount;
    private final int carCount;
    private final int width, height;
    ArrayList<Road> roads = new ArrayList<>();
    ArrayList<TrafficLight> trafficLights = new ArrayList<>();
    ArrayList<NorthSouthRoad> nsRoads = new ArrayList<>();
    ArrayList<EastWestRoad> ewRoads = new ArrayList<>();
    Timer timer;

     BackgroundCanvas(int rowCount, int columnCount, int carCount) {
         this.rowCount = rowCount;
         this.columnCount = columnCount;
         this.carCount = carCount;

         /*
         * These are just magic numbers for now... maybe will fix ;)
         ******************************************************************************/
         this.width = 1000;
         this.height = 800;

         this.setPreferredSize(new Dimension(this.width, this.height));
         this.setBackground(Color.BLACK);
         initialize();
     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        roads.forEach(road -> road.draw(g));
        trafficLights.forEach(trafficLight -> trafficLight.draw(g));
    }

    public void populateCars(){
        for (int i = 0; i < carCount ; i++) {
            addRandomCar();
        }
    }

    public Car addRandomCar(){
        Random random = new Random();
        Road road = roads.get(random.nextInt(roads.size()));
        Car car = new Car(road);
        //car.passTimer(timer);
        road.addCar(car);
        this.revalidate();
        int roadCount = roads.stream().map(Road::getCars).mapToInt(ArrayList::size).sum();
        System.out.println("# of cars: "+roadCount);
        return car;
    }

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

    public void executeWorkers(){
        roads.forEach(road -> {
            ArrayList<Car> cars = road.getCars();
            cars.forEach(SwingWorker::execute);
        });
        trafficLights.forEach(SwingWorker::execute);
    }

    public int getRowCount(){ return this.rowCount; }
    public int getColumnCount() { return columnCount; }
    public int getCarCount() { return carCount; }
}
