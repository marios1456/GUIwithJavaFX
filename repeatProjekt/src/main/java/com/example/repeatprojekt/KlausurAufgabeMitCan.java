package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KlausurAufgabeMitCan extends Application {
    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();
        Canvas canvas = new Canvas(400,430);

        GraphicsContext context = canvas.getGraphicsContext2D();

        context.setFill(Color.DARKRED);
        context.fillRect(10,10,380,10);
        context.setFill(Color.DARKBLUE);
        context.fillOval(10,30,380,380);

        vBox.getChildren().add(canvas);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

        canvas.heightProperty().bind(scene.heightProperty());
        canvas.widthProperty().bind(scene.widthProperty());

        canvas.widthProperty().addListener((obs,o,n)->{
            context.setFill(Color.WHITE);
            context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());

            context.setFill(Color.DARKRED);
            context.fillRect(10,10,canvas.getWidth()-20,10);
            context.setFill(Color.DARKBLUE);
            context.fillOval(10,30,canvas.getWidth()-20,canvas.getHeight()-40);
        });

        canvas.heightProperty().addListener((obs,o,n)->{
            context.setFill(Color.WHITE);
            context.fillRect(0,0,canvas.getWidth(), canvas.getHeight());

            context.setFill(Color.DARKRED);
            context.fillRect(10,10,canvas.getWidth()-20,10);
            context.setFill(Color.DARKBLUE);
            context.fillOval(10,30,canvas.getWidth()-20,canvas.getHeight()-40);
        });


    }
}
