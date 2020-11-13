package dev.tylerdclark.gui;

import dev.tylerdclark.Shape;

import javax.swing.*;

public class DrawPane extends JFrame {
    public DrawPane(Shape currentShape) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 400);

        this.add(new JLabel("Heeeeelllllllllloooo!"/*currentShape.toString()*/));
    }
}
