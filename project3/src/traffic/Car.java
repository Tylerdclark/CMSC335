package traffic;

import util.Timer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Car extends SwingWorker<Void, Void> {

    private static int counter = 0;

    private final Road road;
    private util.Timer timer;
    private final Color color = new Color((int)(Math.random() * 0x1000000));
    private int x;
    private int y;
    private final int id;
    Random random;
    private final int speed;

    public Car(Road road){
        this.road = road;
        this.id = counter++;
        this.random = new Random();
        this.speed = random.nextInt(50);
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
     * Computes a result, or throws an exception if unable to do so.
     *
     * <p>
     * Note that this method is executed only once.
     *
     * <p>
     * Note: this method is executed in a background thread.
     *
     * @return the computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    protected Void doInBackground() throws Exception {

        // going to have to do stuff with the road here
        while (!timer.isStop()) {
            if (!timer.isPause()) {
                /*Do car stuff here*/
                if (this.road instanceof NorthSouthRoad){
                    if(this.y <= 0){
                        this.y = road.length-10;
                    }else{
                        y-=speed;
                    }

                }
                if (this.road instanceof EastWestRoad){

                    if (this.x >= road.length){
                        this.x = 0;
                    }else{
                        x+=speed;
                    }
                }
            }
            Thread.sleep(1000);
        }
        return null;
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

    public boolean tryMove() {
        boolean isNS = this.road instanceof NorthSouthRoad;
        boolean isEW = this.road instanceof EastWestRoad;

        /* Check if another car is where we are going to be or anywhere between */
        /* If the car is slower, match speed and wait 100 ms*/
        /* If the car is faster, wait 100 ms */
        /* If there is an intersection where we will be going, check the current light*/
        /* If it is red, wait 1000ms and check again */
        /* If it is green, make a decision to either turn or go straight */

        return true;
    }
    private void moveEast(int speed){
        this.y-=speed;
    }
    private void moveNorth(int speed){
        this.x+=speed;
    }
    private void turnEast(int speed){

    }
    private void turnNorth(int speed){

    }

}
