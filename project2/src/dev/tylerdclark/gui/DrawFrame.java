package dev.tylerdclark.gui;

import dev.tylerdclark.Shape;

import javax.swing.*;
import java.io.IOException;

public class DrawFrame extends JFrame {

    private final Shape currentShape;

    public DrawFrame(Shape currentShape) {
        this.currentShape = currentShape;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 375);

    }

    public void drawShape() throws IOException {
        JPanel shapePanel = currentShape.getShape();
        this.setContentPane(shapePanel);
    }

}
