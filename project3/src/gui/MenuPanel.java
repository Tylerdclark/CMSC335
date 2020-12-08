package gui;

import javax.swing.*;
import java.awt.*;
import util.Timer;

public class MenuPanel extends JPanel{

    private JTextField timerLbl;
    Timer timer;

    public MenuPanel() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton startBtn = new JButton("Start");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(startBtn, gbc);
        startBtn.addActionListener(event -> {
            if (timer == null || timer.isStop()){
                timer = new Timer(this.timerLbl);
                timer.execute();
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
            timerLbl.setText("0");
            timer.stop();
        });

        JButton addBtn = new JButton("Add a car");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(addBtn, gbc);

        timerLbl = new JTextField(4);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(timerLbl, gbc);


    }
}
