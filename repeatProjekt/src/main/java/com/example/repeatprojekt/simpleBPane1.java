package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class simpleBPane1 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        // Set top
        Label l = new Label("Titletext");
        bp.setTop(l);

        // Set Left
        Button buttonLeft = new Button("Left");
        bp.setMargin(buttonLeft,new Insets(0,4,0,0));
        bp.setLeft(buttonLeft);

        // Set Bottom
        Button buttonBottom = new Button("Bottom");
        bp.setMargin(buttonBottom,new Insets(4,0,0,0));
        bp.setBottom(buttonBottom);

        // Set Right
        Button buttonRight =  new Button("Right");
        bp.setMargin(buttonRight,new Insets(0,0,0,4));
        bp.setRight(buttonRight);

        // Set Center
        TextArea textArea = new TextArea("Center");
        bp.setCenter(textArea);


        Scene sc = new Scene(bp);
        stage.setScene(sc);
        stage.show();
    }
}
