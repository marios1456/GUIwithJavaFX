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

public class BPaneGrid extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        // Set Center
        Label user = new Label("Nutzername");
        Label email = new Label("E-mail");

        TextField username = new TextField();
        TextField emailInput = new TextField();

        GridPane gp = new GridPane();
        gp.setVgap(5);
        gp.setHgap(5);

        gp.add(user,0,0,1,1);
        gp.add(username,1,0,1,1);
        gp.add(email,0,1,1,1);
        gp.add(emailInput,1,1,1,1);

        bp.setCenter(gp);

        // Set Top
        Button open = new Button("Öffnen");
        Button save = new Button("Speichern");
        Button cancel = new Button("Abbrechen");

        HBox top = new HBox();
        HBox.setMargin(open,new Insets(4,4,4,4));
        HBox.setMargin(save,new Insets(4,4,4,4));
        HBox.setMargin(cancel,new Insets(4,4,4,4));
        top.getChildren().addAll(open,save,cancel);

        bp.setTop(top);

        // Set Bottom
        Button start = new Button("Start");

        HBox bottom = new HBox(start);
        bottom.setAlignment(Pos.CENTER);

        bp.setBottom(bottom);

        // Set Left
        Button back = new Button("Zurück");

        VBox left =  new VBox(back);
        left.setAlignment(Pos.CENTER);
        bp.setMargin(left,new Insets(4,4,4,4));
        bp.setLeft(left);

        // Set Right
        Button forword = new Button("Zurück");

        VBox right =  new VBox(forword);
        right.setAlignment(Pos.CENTER);
        bp.setMargin(right,new Insets(4,4,4,4));
        bp.setRight(right);

        Scene sc = new Scene(bp);
        stage.setScene(sc);
        stage.show();
    }
}
