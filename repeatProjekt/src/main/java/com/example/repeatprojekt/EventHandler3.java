package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventHandler3 extends Application {
    @Override
    public void start(Stage stage){
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        TextField textField = new TextField();
        Button add = new Button("Add Text");
        HBox hBox = new HBox(textField, add);

        VBox vBox = new VBox(textArea,hBox);
        vBox.setVgrow(textArea, Priority.ALWAYS);
        vBox.setMargin(hBox, new Insets(5,0,0,0));

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Add Text Text Area");
        stage.show();

        textField.setOnAction(e->{
            textArea.appendText(textField.getText()+ "\n");
            textField.clear();
        });
        add.setOnAction(e->{
            textArea.appendText(textField.getText()+ "\n");
            textField.clear();
        });
    }
}
