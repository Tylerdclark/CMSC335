/*
 * *****************************************************************************
 * FILE: MenuPanel.java
 * NAME: Tyler D Clark
 * PROJECT: Project 3
 * COURSE: CMSC 335
 * DATE: 13 Dec 2020
 * *****************************************************************************
 */
package gui;

import javax.swing.*;
import java.awt.*;

import traffic.Car;
import util.Timer;

/**
 * This JPanel class allows the simulation to be started, paused, stopped and allow random cars to be added
 */
public class MenuPanel extends JPanel{

    private JTextField timerLbl;
    private Timer timer;
    private BackgroundCanvas backgroundCanvas;
    private final int rows, columns, cars;

    /**
     * Constructor that should only get called once.
     * @param backgroundCanvas - canvas that the controls of this panel will be controlling
     */
    public MenuPanel(BackgroundCanvas backgroundCanvas) {
        this.backgroundCanvas = backgroundCanvas;
        /* Setting these number, so if we need to stop and start*/
        this.rows = backgroundCanvas.getRowCount();
        this.columns = backgroundCanvas.getColumnCount();
        this.cars = backgroundCanvas.getCarCount();
        /*Layout stuff*/
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
                this.backgroundCanvas.passTimer(timer);
                this.backgroundCanvas.executeWorkers();
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
            this.getParent().remove(backgroundCanvas);
            this.backgroundCanvas = new BackgroundCanvas(rows, columns, cars);
            this.getParent().add(this.backgroundCanvas, BorderLayout.CENTER);
            revalidate();
            repaint();
        });
        /* todo: As it stands, adding a random car while the sim is stopped does not work */
        JButton addBtn = new JButton("Add a car");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(addBtn, gbc);
        addBtn.addActionListener(event -> {
            Car car = this.backgroundCanvas.addRandomCar();
            car.passTimer(timer);
//            if (!timer.isPause() || !timer.isStop()){
//                car.execute();
//            }
            car.execute(); //this causes the swingworker to finish right away (if stopped)
        });

        timerLbl = new JTextField(4);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(timerLbl, gbc);

    }
}
