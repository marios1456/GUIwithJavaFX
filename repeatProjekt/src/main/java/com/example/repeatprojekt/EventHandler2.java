package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EventHandler2 extends Application {
    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        //Center
        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        bp.setCenter(textArea);

        //Bottom
        HBox hBox = new HBox();
        TextField inputField = new TextField();
        Button addTextButton = new Button("Add Text");

        hBox.getChildren().addAll(inputField,addTextButton);
        bp.setBottom(hBox);
        bp.setMargin(hBox,new Insets(3,0,0,0));


        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.setTitle("Add Text Text Area");
        stage.show();
        inputField.setOnAction(e->{
            textArea.appendText(inputField.getText() + "\n");
            inputField.setText("");
        });
        addTextButton.setOnAction(e->{
            textArea.appendText(inputField.getText() + "\n");
            inputField.setText("");
        });


    }
}
