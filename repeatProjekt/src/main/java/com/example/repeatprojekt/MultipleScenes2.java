package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MultipleScenes2 extends Application {
    Scene sceneB;
    Scene sceneA;
    @Override
    public void start(Stage stage){
        // for Scene A
        BorderPane bpA = new BorderPane();

        MenuItem changeAA = new MenuItem("SceneA");
        MenuItem changeAB = new MenuItem("SceneB");

        Menu menuA = new Menu("Change");
        menuA.getItems().addAll(changeAA, changeAB);
        MenuBar menuBarA = new MenuBar(menuA);

        bpA.setTop(menuBarA);

        TextArea textA = new TextArea();
        textA.setEditable(false);
        bpA.setCenter(textA);

        sceneA = new Scene(bpA);


        // for Scene B

        BorderPane bpB = new BorderPane();

        MenuItem changeBA = new MenuItem("SceneA");
        MenuItem changeBB = new MenuItem("SceneB");
        Menu menuB = new Menu("Change");
        menuB.getItems().addAll(changeBA, changeBB);
        MenuBar menuBarB = new MenuBar(menuB);

        bpB.setTop(menuBarB);

        TextArea textB = new TextArea();
        textB.setEditable(false);
        bpB.setCenter(textB);

        sceneB = new Scene(bpB);

        // Listeners
        changeAB.setOnAction(e->{
            stage.setScene(sceneB);
            stage.show();
        });

        changeBA.setOnAction(e->{
            stage.setScene(sceneA);
            stage.show();
        });
        textA.setOnMouseEntered(e->textA.setEditable(true));
        textA.setOnMouseExited(e->textA.setEditable(false));

        textB.setOnMouseEntered(e->textB.setEditable(true));
        textB.setOnMouseExited(e->textB.setEditable(false));


        stage.setScene(sceneA);
        stage.show();
    }
}
