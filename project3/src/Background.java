import javax.swing.*;
import java.awt.*;

public class Background extends JPanel{

     Background() {
         this.setBackground(Color.BLACK);
         /* In the future, will set size based on how many streets the program will need. */
         this.setPreferredSize(new Dimension(350,350));
         this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawRect(this.getWidth()/2,0, 10,this.getHeight());
        g.drawRect(0,this.getHeight()/2,this.getWidth(), 10);

    }
}
