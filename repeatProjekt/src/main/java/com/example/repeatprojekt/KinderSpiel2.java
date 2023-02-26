package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KinderSpiel2 extends Application {
    private int size = 20;
    @Override
    public void start(Stage stage){

        // First Line
        TextField a = new TextField();
        a.setPrefWidth(size);

        RadioButton plus = new RadioButton("+");
        plus.setSelected(true);
        RadioButton minus = new RadioButton("-");
        ToggleGroup toggleGroup = new ToggleGroup();
        plus.setToggleGroup(toggleGroup);
        minus.setToggleGroup(toggleGroup);

        TextField b = new TextField();
        b.setPrefWidth(size);

        Label equal = new Label("=");


        TextField c = new TextField();
        c.setPrefWidth(size*2);

        // Second Line
        TextField uberprufen = new TextField();

        Button uberprufenButton = new Button("Überprufen");

        GridPane gp = new GridPane();
        gp.add(a,0,0,1,1);
        gp.add(plus,1,0,1,1);
        gp.add(minus,2,0,1,1);
        gp.add(b,3,0,1,1);
        gp.add(equal,4,0,1,1);
        gp.add(c,5,0,1,1);

        gp.add(uberprufen,0,1,4,1);
        gp.add(uberprufenButton,4,1,2,1);

        gp.setHgap(5);
        gp.setVgap(10);

        gp.setPadding(new Insets(10));

        Scene scene = new Scene(gp);

        stage.setScene(scene);
        stage.show();
    }
}
