package dev.tylerdclark;

import javax.swing.*;

public class MenuGUI extends JFrame {

    private JPanel mainPanel;

    public MenuGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }
}
