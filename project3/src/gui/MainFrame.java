package gui;

import gui.BackgroundCanvas;
import gui.MenuPanel;
import util.Timer;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        /* All of the usual Jframe stuff */
        super("Traffic Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setResizable(false);

        InitialPanel initialPanel = new InitialPanel(this);

        add(initialPanel);
        pack();
        setVisible(true);
    }
}
