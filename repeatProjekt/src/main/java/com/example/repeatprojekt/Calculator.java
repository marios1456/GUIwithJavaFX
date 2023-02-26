package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {
    char[][] symbol = {{'7','8','9','/'},
                        {'4','5','6','*'},
                        {'1','2','3','-'},
                        {'0','c','=','+'}};

    TextField inputField;
    private Scene sc;
    BorderPane bp;

    @Override
    public void start(Stage stage){
        bp = new BorderPane();
        sc = new Scene(bp);
        sc.getStylesheets().add(Calculator.class.getResource("style.css").toExternalForm());

        // Set Top
        inputField = new TextField();
        inputField.minHeightProperty().bind(sc.heightProperty().divide(10));
        inputField.minHeightProperty().addListener((obs,oldVal, newVal)->{
            inputField.setFont(Font.font(sc.getHeight()/20));
        });

        bp.setTop(inputField);
        bp.setMargin(inputField, new Insets(10));

        //Set center
        GridPane gp = createGrid();
        gp.setAlignment(Pos.CENTER);

        bp.setCenter(gp);
        bp.setMargin(gp,new Insets(10));


        stage.setScene(sc);
        stage.show();
    }
    public GridPane createGrid(){
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);

        for (int i = 0; i< symbol.length;i++){
            for (int j = 0; j< symbol[0].length; j++){
                Button button = new Button(""+symbol[i][j]);
                button.getStyleClass().add("button");

                button.minHeightProperty().bind(sc.heightProperty().divide(100).multiply(15));
                button.minWidthProperty().bind(sc.widthProperty().divide(5));

                button.heightProperty().addListener((obs,oldVal, newVal)->{
                    button.setFont(Font.font(button.getHeight()/3));
                });

                addCalcEventListeners(symbol[i][j], button);
                gp.add(button,j,i,1,1);
            }

        }
        return gp;
    }

    private void addCalcEventListeners(char symbol, Button button){
        if (symbol == 'c'){
            button.setOnAction(e ->inputField.setText(""));
            return;
        }
        if (symbol == '='){
            Task<Double> task = new Task<Double>() {
                @Override
                protected Double call() throws Exception {
                    double n = 0;
                    int max = 1000000000;
                    for(int i = 1; i <max; i++){
                        if(!isCancelled()) {
                            n = n + Math.sqrt(Math.round((i * 1000) / 3.5));
                            updateProgress(i, max);
                        }else
                            break;
                    }
                    System.out.println("Ready");
                    return 1d;
                }
            };
            task.setOnSucceeded(e->{
                inputField.setText("");
            });
            button.setOnAction(e ->{
                inputField.setText("calculating...");
                new Thread(task).start();
            });
            return;
        }
        button.setOnAction(e ->inputField.appendText(symbol+""));
    }
}
