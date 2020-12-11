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
    private int x, y;
    Random random;

    public Car(Road road, Timer timer){
        this.timer = timer;
        this.road = road;
        counter++;
        random = new Random();

        if (road instanceof NorthSouthRoad){
            if (random.nextBoolean()){
                this.x = ((NorthSouthRoad) road).rightSidePathX;
                this.y = road.length-10;
            }else{
                this.x = ((NorthSouthRoad) road).leftSidePathX;
                this.y = 0;
            }
        }
        if (road instanceof EastWestRoad){

            if (random.nextBoolean()){
                this.x = 0;
                this.y = ((EastWestRoad) road).rightSidePathY;
            } else {
                this.x = road.length-10;
                this.y = ((EastWestRoad) road).leftSidePathY;
            }
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
                    y+=10;
                }
                if (this.road instanceof EastWestRoad){
                    x+=10;
                }
                Thread.sleep(1000);
            }

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


}
