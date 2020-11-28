import javax.swing.*;
import java.awt.*;

public class Background {
     JPanel pnlMain;

     Background() {
         pnlMain = new JPanel();
         pnlMain.setBackground(Color.BLACK);
         /* In the future, will set size based on how many streets the program will need. */
         pnlMain.setPreferredSize(new Dimension(350,350));
     }

    public JPanel getPnlMain() {
        return pnlMain;
    }
}
