package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class CircleOrSquare3 extends Application {
    private boolean isCircle = true;
    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();

        Pane pane = new Pane();

        HBox bottom = new HBox();
        RadioButton redCircle = new RadioButton("Red Circle");
        redCircle.setSelected(true);
        RadioButton blueSquare = new RadioButton("Blue Square");
        ToggleGroup toggleGroup = new ToggleGroup();
        redCircle.setToggleGroup(toggleGroup);
        blueSquare.setToggleGroup(toggleGroup);
        bottom.getChildren().addAll(redCircle,blueSquare);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(10);
        vBox.getChildren().addAll(pane,bottom);
        vBox.setVgrow(pane, Priority.ALWAYS);

        pane.setOnMouseClicked(e->{
            Shape shape;
            if(isCircle){
                shape = new Ellipse(e.getX(),e.getY(),20,20);
                shape.setFill(Color.RED);
            }else {
                shape = new Rectangle(e.getX(),e.getY(),40,40);
                shape.setFill(Color.BLUE);
            }
            pane.getChildren().add(shape);
            shape.setOnMouseClicked(ev->{
                if (shape.getFill() == Color.RED){
                    shape.setFill(Color.BLUE);
                } else {
                    shape.setFill(Color.RED);
                }
                ev.consume();
            });

        });


        Scene scene = new Scene(vBox, 400,400);
        stage.setScene(scene);
        stage.show();

        redCircle.setOnAction(e-> isCircle = true);
        blueSquare.setOnAction(e->isCircle = false);
    }
}
