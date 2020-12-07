import javax.swing.*;
import java.awt.*;

public class BackgroundCanvas extends JPanel{

    private int rowCount, columnCount, carCount;

     BackgroundCanvas() {
         this.setBackground(Color.BLACK);
         /* In the future, will set size based on how many streets the program will need. */
         this.setPreferredSize(new Dimension(350,350));
         this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


     }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintRoads(g);

    }

    private void paintRoads(Graphics g) {
        int canvasWidth = this.getWidth();
        int canvasHeight = this.getHeight();

        int firstX = canvasWidth / (columnCount+1);
        int firstY = canvasHeight / (rowCount+1);


        for (int i = 1; i <= this.columnCount; i++) {
            int currentRoadX = firstX * i;

            g.setColor(Color.white);
            g.drawLine(currentRoadX, 0, currentRoadX, canvasHeight);
        }

        for (int i = 1; i <= this.rowCount; i++) {
            int currentRoadY = firstY * i;

            g.setColor(Color.white);
            g.drawLine(0, currentRoadY , canvasWidth, currentRoadY );
        }


    }

    public void setRowCount(int rowCount){
         this.rowCount = rowCount;
    }
    public void setColumnCount(int columnCount){
         this.columnCount = columnCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }
}
