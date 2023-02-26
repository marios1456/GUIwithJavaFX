package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawHouse3 extends Application {
    @Override
    public void start(Stage stage){
        Canvas canvas = new Canvas(300,300);
        GraphicsContext context = canvas.getGraphicsContext2D();

        context.setStroke(Color.RED);
        context.strokeRect(100,100,100,100);
        context.strokeLine(100,100,150,50);
        context.strokeLine(150,50,200,100);



        VBox vBox = new VBox(canvas);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
