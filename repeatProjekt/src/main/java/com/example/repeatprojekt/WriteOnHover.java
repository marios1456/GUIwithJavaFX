package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WriteOnHover extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        bp.setCenter(textArea);

        textArea.setOnMouseEntered(e->{
            textArea.setEditable(true);
        });
        textArea.setOnMouseExited(e ->{
            textArea.setEditable(false);
        });


        Scene scene = new Scene(bp, 200, 200);
        stage.setScene(scene);
        stage.show();
    }
}
