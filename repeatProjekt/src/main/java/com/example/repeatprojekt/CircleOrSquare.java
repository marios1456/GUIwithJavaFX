package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class CircleOrSquare extends Application {
    private Boolean isSquare = true;
    Shape shape;
    private int size = 20;

    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();

        Pane pane =  new Pane();
        pane.setOnMouseClicked(e->{
            Shape temp;
            if(isSquare){
                temp = new Rectangle(e.getX(), e.getY(), size, size);
                temp.setFill(Color.RED);
                pane.getChildren().add(temp);
            }else {
                temp = new Ellipse(e.getX(), e.getY(),size,size);
                temp.setFill(Color.BLUE);
                pane.getChildren().add(temp);
            }
            temp.setOnMouseClicked(ev->{
                shape = (Shape) ev.getTarget();
                if (shape.getFill() == Color.RED){
                    shape.setFill(Color.BLUE);
                }else {
                    shape.setFill(Color.RED);
                }
                ev.consume();
            });

        });
        pane.setPrefSize(400,400);
        vBox.getChildren().add(pane);

        RadioButton square =  new RadioButton("Square");
        RadioButton circle = new RadioButton("Circle");

        ToggleGroup group =  new ToggleGroup();

        square.setToggleGroup(group);
        square.setSelected(isSquare);
        square.setOnAction(e->{
            isSquare = true;
        });
        circle.setToggleGroup(group);
        circle.setOnAction(e->{
            isSquare = false;
        });
        HBox radioButtons = new HBox();
        radioButtons.getChildren().addAll(square, circle);
        radioButtons.setAlignment(Pos.CENTER);
        vBox.getChildren().add(radioButtons);



        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
