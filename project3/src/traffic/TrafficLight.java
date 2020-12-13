package traffic;

import util.Timer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TrafficLight extends SwingWorker<Void, Void> {

    Timer timer;
    NorthSouthRoad nsRoad;
    EastWestRoad ewRoad;
    int ewLightX, ewLightY, nsLightX, nsLightY, id;
    Color ewLightColor = Color.GREEN;
    Color nsLightColor = Color.RED;
    static int counter = 0;
    Random random;

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
        while (!timer.isStop()) {
            if (!timer.isPause()) {
                Color temp = ewLightColor;
                ewLightColor = nsLightColor;
                nsLightColor = temp;
            }
            Thread.sleep(1000 * random.nextInt(10));
        }
        return null;
    }

    @Override
    protected void done() {
        System.out.println("Traffic light #"+id+" is done.");
    }

    public void draw(Graphics graphics){
        graphics.setColor(ewLightColor);
        graphics.fillOval(ewLightX, ewLightY,10, 10);
        graphics.setColor(nsLightColor);
        graphics.fillOval(nsLightX, nsLightY, 10, 10);
    }

    public void passTimer(Timer timer){
        this.timer = timer;
    }
}
