import javax.swing.*;
import java.util.List;

public class Timer extends SwingWorker<Void, Integer> {

    private  boolean stop;
    private  boolean pause;

    private final JTextField textField;

    Timer(JTextField textField){
        this.textField = textField;
        this.stop = false;
        this.pause = false;
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
        int seconds = 0;
        while (!stop){
            publish(seconds);
            System.out.println(seconds);
            if (!pause){
                seconds++;
            }
            Thread.sleep(1000);
        }

        return null;
    }

    @Override
    protected void process(List<Integer> chunks) {
        Integer second = chunks.get(chunks.size()-1);
        textField.setText(String.valueOf(second));
    }

    @Override
    protected void done() {
        System.out.println("done");
    }

    public void pause () {
        this.pause = true;
    }
    public void play () {
        this.pause = false;
    }
    public void stop () { this.stop = true; }

    public boolean isStop() {
        return stop;
    }
}
