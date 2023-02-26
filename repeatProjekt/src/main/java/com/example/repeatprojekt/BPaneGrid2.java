package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BPaneGrid2 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp =  new BorderPane();

        // Top
        HBox hBox = new HBox();
        Button openButton = new Button("Open");
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        hBox.getChildren().addAll(openButton, saveButton, cancelButton);
        hBox.setSpacing(5);
        bp.setTop(hBox);
        bp.setMargin(hBox, new Insets(10));


        // Left
        VBox vBoxleft = new VBox();
        Button backButton = new Button("Back");

        vBoxleft.getChildren().add(backButton);
        vBoxleft.setAlignment(Pos.CENTER);

        bp.setLeft(vBoxleft);
        bp.setMargin(vBoxleft, new Insets(10));


        // Right
        VBox vBoxright = new VBox();
        Button forwardButton = new Button("Forward");

        vBoxright.getChildren().add(forwardButton);
        vBoxright.setAlignment(Pos.CENTER);

        bp.setRight(vBoxright);
        bp.setMargin(vBoxright, new Insets(10));

        // Bottom

        HBox hBoxBottom = new HBox();
        Button startButton = new Button("Start");

        hBoxBottom.getChildren().add(startButton);
        hBoxBottom.setAlignment(Pos.CENTER);
        bp.setBottom(hBoxBottom);
        bp.setMargin(hBoxBottom, new Insets(10));

        // Center

        GridPane gridPane =  new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label userName = new Label("Username");
        Label email = new Label("E-mail");

        TextField userNameField = new TextField();
        TextField emailField = new TextField();

        gridPane.add(userName,0,0,1,1);
        gridPane.add(email, 0, 1,1,1);
        gridPane.add(userNameField, 1,0,1,1);
        gridPane.add(emailField, 1,1,1,1);

        bp.setCenter(gridPane);
        bp.setMargin(gridPane, new Insets(10));


        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }
}
