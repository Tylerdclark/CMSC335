/*
 * *****************************************************************************
 * FILE: App.java
 * NAME: Tyler D Clark
 * PROJECT: Project 3
 * COURSE: CMSC 335
 * DATE: 13 Dec 2020
 * *****************************************************************************
 */

package gui;

import javax.swing.*;

/**
 * Main entry point for the application.
 */
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
