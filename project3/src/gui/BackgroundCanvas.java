package gui;

import traffic.Car;
import traffic.EastWestRoad;
import traffic.NorthSouthRoad;
import traffic.Road;
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
    Timer timer;

     BackgroundCanvas(int rowCount, int columnCount, int carCount) {
         this.rowCount = rowCount;
         this.columnCount = columnCount;
         this.carCount = carCount;
         this.width = columnCount * 100;
         this.height = rowCount * 100;

         this.setBackground(Color.BLACK);
         this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
         this.setSize(new Dimension(width, height));
         this.setPreferredSize(new Dimension(width, height));
         initialize();
     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        roads.forEach(road -> road.draw(g));

        System.out.println(this.getHeight());
        System.out.println(this.getWidth());
    }

    public void populateCars(){
        Random random = new Random();
        for (int i = 0; i < carCount ; i++) {
            Road road = roads.get(random.nextInt(roads.size()));
            road.addCar(new Car(road, timer));
        }
    }

    public void passTimer(Timer timer){
        this.timer = timer;
    }


    private void initialize() {

        int firstX = width / (columnCount+1);
        int firstY = height / (rowCount+1);

        for (int i = 1; i <= this.columnCount; i++) {
            int currentRoadX = firstX * i;
            NorthSouthRoad road = new NorthSouthRoad(currentRoadX, height);
            roads.add(road);

        }

        for (int i = 1; i <= this.rowCount; i++) {
            int currentRoadY = firstY * i;
            EastWestRoad road = new EastWestRoad(currentRoadY, width);
            roads.add(road);

        }
        populateCars();
    }
}
