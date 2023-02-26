package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KinderSpiel extends Application {
    TextField a,b,c,rightWrongField;
    RadioButton plus,minus;

    @Override
    public void start(Stage stage){
        BorderPane bp = new BorderPane();

        // center
        GridPane gp = new GridPane();
        gp.setVgap(10);
        gp.setHgap(20);
        // first row
        a = new TextField();
        a.setMaxWidth(40);
        gp.add(a,0,0,1,1);

        plus = new RadioButton("+");
        plus.setSelected(true);
        gp.add(plus,1,0,1,1);
        minus = new RadioButton("-");
        gp.add(minus,2,0,1,1);

        ToggleGroup toggleGroup = new ToggleGroup();

        plus.setToggleGroup(toggleGroup);
        minus.setToggleGroup(toggleGroup);

        b = new TextField();
        b.setMaxWidth(40);
        gp.add(b,3,0,1,1);

        Label gleich = new Label("=");
        gp.add(gleich,4,0,1,1);

        c = new TextField();
        c.setMaxWidth(40);
        gp.add(c,5,0,1,1);

        //second Row

        rightWrongField = new TextField();
        gp.add(rightWrongField,0,1,4,1);
        Button testButton = new Button("Überprüfen");
        gp.add(testButton,4,1,3,1);

        bp.setCenter(gp);
        bp.setMargin(gp,new Insets(50));


        testButton.setOnAction(e->{
            int number1 = Integer.parseInt(a.getText());
            int number2 = Integer.parseInt(b.getText());
            int result = Integer.parseInt(c.getText());

            if (plus.isSelected() && (number1 + number2 == result)){
                rightWrongField.setText("Korrekt");
                return;
            }
            if (minus.isSelected() && (number1 - number2 == result)){
                rightWrongField.setText("Korrekt");
                return;
            }
            rightWrongField.setText("Versuch nochmal");

        });





        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }
}
