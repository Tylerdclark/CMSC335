package dev.tylerdclark.gui;

import dev.tylerdclark.Shape;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class DrawFrame extends JFrame {

    private final Shape currentShape;

    public DrawFrame(Shape currentShape) {
        getContentPane().setLayout(
                //new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
                new GridBagLayout()
        );
        //contentPanel.setBackground(Color.CYAN);
        this.currentShape = currentShape;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(325, 350);


    }
    public void drawShape() throws IOException {
        this.add(currentShape.getShape());
    }
}
