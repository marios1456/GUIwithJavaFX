package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class schachbrett extends Application {
    private boolean[][] colored = {{false,true,false,true,false,true,false,true},
                                    {true,false,true,false,true,false,true,false},
            {false,true,false,true,false,true,false,true},
            {true,false,true,false,true,false,true,false},
            {false,true,false,true,false,true,false,true},
            {true,false,true,false,true,false,true,false},
            {false,true,false,true,false,true,false,true},
            {true,false,true,false,true,false,true,false}};
    GridPane gp;
    ColorPicker colorPicker;
    ArrayList<Canvas> coloredCanvas = new ArrayList<>();
    @Override
    public void start(Stage stage){
        VBox vbox = new VBox();
        Scene scene =  new Scene(vbox);

        // create Brett and set to vbox center
        gp = new GridPane();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Canvas canvas = new Canvas(20,20);
                GraphicsContext context = canvas.getGraphicsContext2D();
                if (colored[i][j]){
                    context.setFill(Color.BLACK);
                    coloredCanvas.add(canvas);
                }else
                    context.setFill(Color.WHITE);
                context.fillRect(0,0,20,20);
                gp.add(canvas,i,j,1,1);


                //canvas.heightProperty().bind(gp.heightProperty().divide(8));
                //canvas.widthProperty().bind(gp.widthProperty().divide(8));
                scene.heightProperty().addListener((obs,old,n)->{
                    double boxHeight = (scene.getHeight()-70)/8;
                    double boxWidth = (scene.getWidth())/8;
                    canvas.setHeight(boxHeight);
                    GraphicsContext context1 = canvas.getGraphicsContext2D();
                    if (coloredCanvas.contains(canvas))
                        context1.setFill(colorPicker.getValue());
                    else
                        context1.setFill(Color.WHITE);
                    context1.fillRect(0,0,boxWidth,boxHeight);

                });

                scene.widthProperty().addListener((obs,old,n)->{
                    double boxHeight = (scene.getHeight()-70)/8;
                    double boxWidth = (scene.getWidth())/8;
                    canvas.setWidth(boxWidth);
                    GraphicsContext context1 = canvas.getGraphicsContext2D();
                    if (coloredCanvas.contains(canvas))
                        context1.setFill(colorPicker.getValue());
                    else
                        context1.setFill(Color.WHITE);
                    context1.fillRect(0,0,boxWidth,boxHeight);

                });
            }
        }



        colorPicker = new ColorPicker();
        colorPicker.setValue(Color.BLACK);

        vbox.getChildren().add(gp);
        vbox.getChildren().add(colorPicker);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMargin(colorPicker, new Insets(20,0,0,0));


        colorPicker.setOnAction(e->{

            colorPicker.getValue();
            System.out.println("for the brakepoint: "+ colorPicker.getValue());
            for (Canvas canvas: coloredCanvas) {
                GraphicsContext context = canvas.getGraphicsContext2D();
                context.setFill(colorPicker.getValue());
                double boxHeight = (scene.getHeight()-70)/8;
                double boxWidth = (scene.getWidth())/8;
                context.fillRect(0,0,boxWidth,boxHeight);
            }
        });







        stage.setScene(scene);
        stage.show();

        vbox.minHeightProperty().bind(scene.heightProperty());
        vbox.minWidthProperty().bind(scene.widthProperty());
    }
}
