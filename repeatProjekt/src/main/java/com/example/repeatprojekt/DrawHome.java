package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawHome extends Application {
    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();
        Canvas canvas = new Canvas(300,400);


        GraphicsContext context = canvas.getGraphicsContext2D();

        context.setLineWidth(5);
        context.setStroke(Color.DARKRED);
        context.strokeLine(125, 125, 150, 100);
        context.strokeLine(150, 100, 175, 125);
        context.strokeRect(125,125,50,50);


        vBox.fillWidthProperty().set(true);
        VBox.setVgrow(canvas, Priority.ALWAYS);

        vBox.getChildren().addAll(canvas);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
