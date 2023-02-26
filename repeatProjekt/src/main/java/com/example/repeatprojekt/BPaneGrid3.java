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

public class BPaneGrid3 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        // Right
        Button zuruck = new Button("Zurück");
        HBox rightHbox = new HBox(zuruck);
        rightHbox.setAlignment(Pos.CENTER);
        bp.setRight(rightHbox);
        bp.setMargin(rightHbox, new Insets(15));


        // Left
        Button vor = new Button("Vor");
        HBox leftHbox = new HBox(vor);
        leftHbox.setAlignment(Pos.CENTER);
        bp.setLeft(leftHbox);
        bp.setMargin(leftHbox, new Insets(15));


        // Bottom
        Button start = new Button("Start");
        VBox bottomVbox = new VBox(start);
        bottomVbox.setAlignment(Pos.CENTER);
        bp.setBottom(bottomVbox);
        bp.setMargin(bottomVbox, new Insets(15));

        // Top
        Button offnen = new Button("Öffnen");
        Button speichern = new Button("Speichern");
        Button abbrechen = new Button("Abbrechen");

        HBox topVbox = new HBox();
        topVbox.getChildren().addAll(offnen, speichern, abbrechen);
        topVbox.setSpacing(15);

        bp.setTop(topVbox);
        bp.setMargin(topVbox, new Insets(15));

        // Center
        GridPane gp = new GridPane();

        gp.add(new Label("Nutzername"),0,0,1,1);
        gp.add(new Label("E-mail"),0,1,1,1);
        gp.add(new TextField(),1,0,1,1);
        gp.add(new TextField(),1,1,1,1);
        gp.setHgap(10);
        gp.setVgap(10);

        bp.setCenter(gp);


        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.setTitle("Multi Layout Exercise Demo");
        stage.show();
    }
}
