package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WriteOnHover3 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();
        TextArea textArea = new TextArea();
        bp.setCenter(textArea);

        textArea.setOnMouseEntered(e->textArea.setEditable(true));
        textArea.setOnMouseExited(e->textArea.setEditable(false));

        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.setTitle("TextAreaEvents");
        stage.show();

    }
}
