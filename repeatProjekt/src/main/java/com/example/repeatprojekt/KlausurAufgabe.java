package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class KlausurAufgabe extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();
        vBox.fillWidthProperty().set(true);
        Pane p1 = new Pane();
        p1.setOpacity(1);
        Rectangle rectangle = new Rectangle(0,5,15,15);
        rectangle.setFill(Color.DARKRED);
        Ellipse ellipse = new Ellipse(100,100,50,50);
        ellipse.setFill(Color.DARKBLUE);
        p1.getChildren().add(rectangle);
        p1.getChildren().add(ellipse);
        vBox.getChildren().add(p1);
        VBox.setVgrow(vBox, Priority.ALWAYS);



        Scene sc = new Scene(vBox, 200, 200);
        stage.setScene(sc);
        stage.show();

        rectangle.widthProperty().bind(sc.widthProperty());
        ellipse.radiusXProperty().bind(sc.widthProperty().divide(2).subtract(20));
        ellipse.radiusYProperty().bind(sc.heightProperty().divide(2).subtract(20));
        ellipse.centerXProperty().bind(sc.widthProperty().divide(2));
        ellipse.centerYProperty().bind(sc.heightProperty().divide(2).add(10));

    }
}
