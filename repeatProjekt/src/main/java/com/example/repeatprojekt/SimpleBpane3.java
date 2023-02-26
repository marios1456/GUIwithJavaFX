package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleBpane3 extends Application {
    @Override
    public void start(Stage stage){

        BorderPane bp = new BorderPane();

        // Top
        Label topLabel = new Label("Titletext");
        bp.setTop(topLabel);
        bp.setMargin(topLabel, new Insets(0,0,5,0));

        // Left
        Button left =  new Button("Left");
        bp.setLeft(left);
        bp.setMargin(left,new Insets(0, 5, 0,0));

        // Right

        Button right = new Button("Right");
        bp.setRight(right);
        bp.setMargin(right, new Insets(0, 0, 0, 5));

        // Bottom
        Button bottom = new Button("Bottom");
        bp.setBottom(bottom);
        bp.setMargin(bottom, new Insets(5,0,0,0));

        // Center
        TextArea textArea = new TextArea("Center");
        bp.setCenter(textArea);


        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.setTitle("BorderPaneTest");
        stage.show();

    }
}
