/*
 * *****************************************************************************
 * FILE: MainFrame.java
 * NAME: Tyler D Clark
 * PROJECT: Project 3
 * COURSE: CMSC 335
 * DATE: 13 Dec 2020
 * *****************************************************************************
 */

package dev.tylerdclark.gui;

import javax.swing.*;

/**
 * Main Frame (I'm good at naming) which begins with an initial pane
 */
public class MainFrame extends JFrame {

    /**
     * Constructor that starts the simulation by introducing option selection
     */
    public MainFrame(){
        /* All of the usual Jframe stuff */
        super("Traffic Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,400);
        setResizable(false);
        /* Note the initial panel gets passed this JFrame*/
        InitialPanel initialPanel = new InitialPanel(this);
        add(initialPanel);
        pack();
        setVisible(true);
    }
}
