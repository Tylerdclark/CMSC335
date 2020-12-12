package gui;

import traffic.*;
import util.Timer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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

    public void addRandomCar(){
        Random random = new Random();
        Road road = roads.get(random.nextInt(roads.size()));
        Car car = new Car(road, timer);
        car.passTimer(timer);
        road.addCar(car);
        this.revalidate();
    }

    public void passTimer(Timer timer){
        this.timer = timer;
    }

    public void initialize() {

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
        nsRoads.forEach(nsRoad -> {
            ewRoads.forEach(ewRoad -> {
                /*todo: as of right now, timer that gets passed is null. Please figure out when the best time to pass
                   timer, maybe even use a passTimer method. */
                TrafficLight trafficLight = new TrafficLight(timer, nsRoad, ewRoad);
                trafficLights.add(trafficLight);
            });
        });

        populateCars();
    }

    public void executeCars(){ //also traffic lights
         roads.forEach(road -> {
             ArrayList<Car> cars = road.getCars();
             cars.forEach( car -> {
                 car.passTimer(timer);
                 car.execute();
             });
         });
        trafficLights.forEach(SwingWorker::execute);
    }
}
