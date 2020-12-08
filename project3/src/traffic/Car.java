import util.Timer;

import javax.swing.*;
import java.awt.*;

public class Car extends SwingWorker<Void, Void> {

    private final Road road;
    private final util.Timer timer;

    Color color = new Color((int)(Math.random() * 0x1000000));

    public Car(Road road, Timer timer){
        this.road = road;
        this.timer = timer;
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
                /*Do car stuff here*/
                System.out.println("i'm riding downtown in " + color + " color.");
            }

        }
        return null;
    }
}
