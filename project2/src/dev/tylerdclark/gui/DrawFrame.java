package dev.tylerdclark.gui;

import dev.tylerdclark.Shape;

import javax.swing.*;

public class DrawFrame extends JFrame {
    public DrawFrame(Shape currentShape) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);
        this.add(new JLabel(currentShape.toString()));
    }
}
