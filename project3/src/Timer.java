import javax.swing.*;

public class Timer extends SwingWorker<Void, Void> {

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
            textField.setText(String.valueOf(time));
            System.out.println(time);
            wait(1000);
        }

        return null;
    }

    public void pause () {
        this.play = false;
    }
    public void play () {
        this.play = true;
    }
}
