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

    public Car(Road road, Timer timer){
        this.timer = timer;
        this.road = road;
        this.id = counter++;
        this.random = new Random();
        this.speed = random.nextInt(50);

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
                Thread.sleep(1000);
            }else{
                System.out.println(id+ " is paused");
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
}
