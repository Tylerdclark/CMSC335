/*
 * *****************************************************************************
 * FILE: TrafficLight.java
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
import java.util.Random;

/**
 * The traffic light class, which like cars and the timer runs in a background thread.
 * todo: make setters and getters and give access modifiers
 */
public class TrafficLight extends SwingWorker<Void, Void> {

    private Timer timer;
    NorthSouthRoad nsRoad;
    EastWestRoad ewRoad;
    int ewLightX, ewLightY, nsLightX, nsLightY, id;
    Color ewLightColor = Color.GREEN;
    Color nsLightColor = Color.RED;
    static int counter = 1;
    LightStatus ewStatus = LightStatus.GO;
    LightStatus nsStatus = LightStatus.STOP;
    Random random;

    /**
     * constructor for traffic light objects.
      * @param nsRoad the vertical road for this light
     * @param ewRoad the horizontal road for this light
     */
   public TrafficLight(NorthSouthRoad nsRoad, EastWestRoad ewRoad){
       this.nsRoad = nsRoad;
       this.ewRoad = ewRoad;
       this.ewLightX = nsRoad.leftSideX-10;
       this.ewLightY = ewRoad.rightSideY-20;
       this.nsLightX = nsRoad.rightSideX;
       this.nsLightY = ewRoad.rightSideY;
       this.id = counter++;
       random = new Random();
       System.out.println("Traffic light #"+id+" created");
   }

    /**
     * As long as the sim is not paused or stopped, will flip the signs between green and red and then wait a random
     * time. I simply decided to leave out yellow since the instructions say not to stop/slow for yellow and it would
     * not affect much.
     *
     * @return null
     * @throws Exception if unable to compute a result
     */
    @Override
    protected Void doInBackground() throws Exception {
        while (!timer.isStop()) {
            if (!timer.isPause()) {
                Color tempColor = ewLightColor;
                LightStatus tempStatus = ewStatus;

                ewStatus = nsStatus;
                ewLightColor = nsLightColor;

                nsStatus = tempStatus;
                nsLightColor = tempColor;
            }
            Thread.sleep(1000 * random.nextInt(10));
        }
        return null;
    }

    /**
     * done
     */
    @Override
    protected void done() {
        System.out.println("Traffic light #"+id+" is done.");
    }

    /**
     * Draws two colored dots
     * @param graphics to draw with
     */
    public void draw(Graphics graphics){
        graphics.setColor(ewLightColor);
        graphics.fillOval(ewLightX, ewLightY,10, 10);
        graphics.setColor(nsLightColor);
        graphics.fillOval(nsLightX, nsLightY, 10, 10);
    }

    /* Setters and getters here plz */
    public void passTimer(Timer timer){ this.timer = timer; }
}
