import javax.swing.*;
import java.util.List;

public class Timer extends SwingWorker<Void, Long> {

    boolean play;
    long start;
    private final JTextField textField;

    Timer(JTextField textField){
        this.textField = textField;
        this.start = System.currentTimeMillis();
        this.play = true;
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
        this.getState();
        while (play){
            long time = (System.currentTimeMillis() - start) / 1000;
            publish(time);
            System.out.println(time);
            Thread.sleep(1000);
            //wait(1000);
        }

        return null;
    }

    @Override
    protected void process(List<Long> chunks) {
        Long second = chunks.get(chunks.size()-1);
        textField.setText(String.valueOf(second));
    }

    @Override
    protected void done() {
        System.out.println("done");
    }

    public void pause () {
        this.play = false;
    }
    public void play () {
        this.play = true;
    }
}
