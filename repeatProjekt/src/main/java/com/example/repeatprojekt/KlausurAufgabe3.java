package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KlausurAufgabe3 extends Application {
    private Canvas canvas;
    @Override
    public void start(Stage stage){
        canvas = new Canvas(300,320);
        VBox vBox = new VBox(canvas);

        GraphicsContext context = canvas.getGraphicsContext2D();

        drawThings(context);



        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("PaintCanvas");
        canvas.heightProperty().bind(scene.heightProperty());
        canvas.widthProperty().bind(scene.widthProperty());

        canvas.heightProperty().addListener((ob,old,n)->{
            drawThings(context);
        });

        canvas.widthProperty().addListener((ob,old,n)->{
            drawThings(context);
        });

        canvas.setOnMouseClicked(e->{
            Task<String> task = new Task<String>() {
                @Override
                protected String call() throws Exception {
                    return null;
                }
            };
        });
    }

    private void drawThings(GraphicsContext context){
        context.setFill(Color.WHITE);
        context.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        context.setFill(Color.DARKRED);
        context.fillRect(5,5,canvas.getWidth()-10,10);

        context.setFill(Color.DARKBLUE);
        context.fillOval(20,20,canvas.getWidth()-40,canvas.getHeight()-40);
    }
}
