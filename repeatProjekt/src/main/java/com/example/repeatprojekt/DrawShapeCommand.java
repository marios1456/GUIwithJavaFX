package com.example.repeatprojekt;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class DrawShapeCommand implements Command {

    private final Shape shape;
    private Pane pane;

    public DrawShapeCommand(Shape shape, Pane pane){
        this.shape = shape;
        this.pane = pane;
    }

    @Override
    public void execute() {
        pane.getChildren().add(shape);

    }

    @Override
    public void undo() {
        pane.getChildren().remove(shape);

    }
}
