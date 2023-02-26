package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MultipleScenes extends Application {
    @Override
    public void start(Stage stage){


        // Scene A
        Menu change = new Menu("Change");
        MenuItem a = new MenuItem("Scene A");
        MenuItem b = new MenuItem("Scene B");

        change.getItems().addAll(a,b);
        MenuBar menuBar = new MenuBar(change);


        BorderPane borderPaneA = new BorderPane();
        borderPaneA.setTop(menuBar);
        TextArea textAreaA = new TextArea();
        textAreaA.setEditable(false);
        borderPaneA.setCenter(textAreaA);
        Scene sceneA = new Scene(borderPaneA);
        sceneA.setOnMouseEntered(e->{
            textAreaA.setEditable(true);
        });
        sceneA.setOnMouseExited(e->{
            textAreaA.setEditable(false);
        });

        // Scene B

        Menu change2 = new Menu("Change");
        MenuItem a2 = new MenuItem("Scene A");

        MenuItem b2 = new MenuItem("Scene B");
        change2.getItems().addAll(a2,b2);
        MenuBar menuBar2 = new MenuBar(change2);

        BorderPane borderPaneB = new BorderPane();
        borderPaneB.setTop(menuBar2);
        TextArea textAreaB = new TextArea();
        textAreaB.setEditable(false);
        borderPaneB.setCenter(textAreaB);
        Scene sceneB = new Scene(borderPaneB);

        sceneB.setOnMouseEntered(e->{
            textAreaB.setEditable(true);
        });
        sceneB.setOnMouseExited(e->{
            textAreaB.setEditable(false);
        });


        a2.setOnAction(e->{
            stage.setScene(sceneA);
            stage.show();
        });

        b.setOnAction(e->{
            stage.setScene(sceneB);
            stage.show();
        });
        stage.setScene(sceneA);
        stage.show();
        stage.setTitle("TextAreaEvents");
    }
}
