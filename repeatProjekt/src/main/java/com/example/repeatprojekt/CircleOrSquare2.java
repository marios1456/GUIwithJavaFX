package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class CircleOrSquare2 extends Application {
    private boolean redCircleSelected = true;
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();
        Pane pane = new Pane();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        RadioButton redCircle = new RadioButton("Red Circle");
        redCircle.setSelected(true);
        RadioButton blueSquare = new RadioButton("Blue Square");
        ToggleGroup toggleGroup = new ToggleGroup();
        redCircle.setToggleGroup(toggleGroup);
        blueSquare.setToggleGroup(toggleGroup);

        hBox.getChildren().addAll(redCircle,blueSquare);

        //bp.getChildren().addAll(pane,hBox);
        bp.setCenter(pane);
        bp.setBottom(hBox);

        Scene scene = new Scene(bp,450,450);
        stage.setScene(scene);
        stage.show();

        redCircle.setOnAction(e->{
            redCircleSelected = true;
        });

        blueSquare.setOnAction(e->{
            redCircleSelected = false;
        });

        pane.setOnMouseClicked(e->{
            Shape newShape;
            if (redCircleSelected) {
                newShape = new Ellipse(e.getX(), e.getY(), 15, 15);
                newShape.setFill(Color.RED);
            }else {
                newShape = new Rectangle(e.getX(), e.getY(), 15, 15);
                newShape.setFill(Color.BLUE);
            }
            pane.getChildren().add(newShape);

            newShape.setOnMouseClicked(ev->{
                if (newShape.getFill() == Color.RED)
                    newShape.setFill(Color.BLUE);
                else
                    newShape.setFill(Color.RED);
                ev.consume();
            });

        });
    }
}
