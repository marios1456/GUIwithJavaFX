package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WriteOnHover2 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        TextArea textArea= new TextArea();
        textArea.setEditable(false);
        bp.setCenter(textArea);



        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();

        scene.setOnMouseEntered(e->{
            textArea.setEditable(true);
        });
        scene.setOnMouseExited(e->{
            textArea.setEditable(false);
        });
    }
}
