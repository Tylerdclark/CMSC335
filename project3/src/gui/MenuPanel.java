package gui;

import javax.swing.*;
import java.awt.*;
import util.Timer;

public class MenuPanel extends JPanel{

    private JTextField timerLbl;
    Timer timer;
    BackgroundCanvas backgroundCanvas;

    public MenuPanel(BackgroundCanvas backgroundCanvas) {
        this.backgroundCanvas = backgroundCanvas;

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton startBtn = new JButton("Start");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(startBtn, gbc);
        startBtn.addActionListener(event -> {
            if (timer == null || timer.isStop()){
                timer = new Timer(this.timerLbl, this.backgroundCanvas);
                timer.execute();
                backgroundCanvas.passTimer(timer);
                backgroundCanvas.executeCars();

                //backgroundCanvas.roads.forEach(road -> road.);
            } else {
                timer.play();
            }
        });

        JButton pauseBtn = new JButton("Pause");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(pauseBtn, gbc);
        pauseBtn.addActionListener( event -> timer.pause());

        JButton stopBtn = new JButton("Stop");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(stopBtn, gbc);
        stopBtn.addActionListener(event -> {
            timerLbl.setText("00:00");
            timer.stop();
            backgroundCanvas.repaint();
        });

        JButton addBtn = new JButton("Add a car");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(addBtn, gbc);
        addBtn.addActionListener(event -> {
            backgroundCanvas.addRandomCar();
            backgroundCanvas.executeCars();
            backgroundCanvas.repaint();
        });

        timerLbl = new JTextField(4);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(timerLbl, gbc);

    }

    public Timer getTimer(){
        return this.timer;
    }
}
