package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawHouse2 extends Application {
    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();

        Canvas canvas = new Canvas(400,400);

        vBox.fillWidthProperty().set(true);
        VBox.setVgrow(canvas, Priority.ALWAYS);
        vBox.getChildren().add(canvas);

        GraphicsContext context = canvas.getGraphicsContext2D();
        context.setFill(Color.RED);
        context.setLineWidth(3);
        context.setStroke(Color.RED);
        context.strokeRect(100,100,200,200);
        context.strokeLine(100,100, 200,50);
        context.strokeLine(200,50, 300,100);


        Scene scene = new Scene(vBox, 400,400);
        stage.setScene(scene);
        stage.show();
    }
}
