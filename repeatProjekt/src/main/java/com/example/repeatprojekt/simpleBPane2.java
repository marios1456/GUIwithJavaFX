package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class simpleBPane2 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        //Top
        Label label = new Label("TitelText");
        bp.setTop(label);

        //Left
        Button leftButton = new Button("Left");
        bp.setLeft(leftButton);
        bp.setMargin(leftButton, new Insets(0,5,0,0));

        //Right
        Button rightButton = new Button("Right");
        bp.setRight(rightButton);
        bp.setMargin(rightButton, new Insets(0,0,0,5));

        //Bottom
        Button bottomButton = new Button("Bottom");
        bp.setBottom(bottomButton);
        bp.setMargin(bottomButton, new Insets(5,0,0,0));

        //Center
        TextArea textArea = new TextArea("Center");
        bp.setCenter(textArea);


        Scene scene = new Scene(bp,400,400);
        stage.setTitle("BorderPaneTest");
        stage.setScene(scene);
        stage.show();
    }
}
