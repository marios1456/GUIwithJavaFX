package com.example.repeatprojekt;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class ChangeColorCommand implements Command {

    private final Shape shape;
    private Color color;

    public ChangeColorCommand(Shape shape){
        this.shape = shape;
        color = (Color)shape.getFill();
    }

    @Override
    public void execute() {
        if (color == Color.RED){
            shape.setFill(Color.BLUE);
        }
        if (color == Color.BLUE){
            shape.setFill(Color.RED);
        }

    }

    @Override
    public void undo() {
        shape.setFill(color);
    }
}
