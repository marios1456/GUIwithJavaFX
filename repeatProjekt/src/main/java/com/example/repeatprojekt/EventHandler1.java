package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EventHandler1 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        // set Center
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        bp.setCenter(textArea);

        // set Bottom
        TextField textField = new TextField();
        Button addText = new Button("Add Text");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(textField,addText);

        bp.setBottom(hBox);

        // Add Event Handlers
        addText.setOnAction(e ->{
            newLineHandler(textField, textArea);
        });

        textField.setOnAction(e ->{
           newLineHandler(textField, textArea);
        });

        Scene scene = new Scene(bp,400,400);
        stage.setScene(scene);
        stage.show();

    }
    private void newLineHandler(TextField textField, TextArea textArea){
        String newLine = textField.getText();
        textField.setText("");
        textArea.appendText(newLine +"\n");
    }
}
