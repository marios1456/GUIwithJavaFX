package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator3 extends Application {
    private char symbols[][] = {{'7','8','9','/'},
                        {'4','5','6','*'},
                        {'1','2','3','-'},
                        {'0','c','=','+'}};
    private boolean inside = false;
    private Scene scene;
    private TextField textField;
    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();
        scene = new Scene(vBox,300,300);
        textField = new TextField();
        textField.setAlignment(Pos.TOP_RIGHT);
        textField.minHeightProperty().bind(scene.heightProperty().divide(10));
        textField.minHeightProperty().addListener(e->{
            Font font = new Font(textField.getHeight()/2);
            textField.setFont(font);
        });

        GridPane buttons = createGrid();
        vBox.getChildren().addAll(textField,buttons);
        vBox.setVgrow(buttons, Priority.ALWAYS);
        vBox.setMargin(textField,new Insets(5));
        vBox.setMargin(buttons,new Insets(5));



        stage.setScene(scene);
        stage.setTitle("Calc");
        stage.show();
        vBox.setOnMouseEntered(e->inside = true);
        vBox.setOnMouseExited(e->inside = false);
        vBox.setOnKeyPressed(e->{
            if (inside){
                if (e.getText().equals("1")){
                    textField.appendText(e.getText());
                }
            }
        });


    }

    public GridPane createGrid(){
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        for (int i=0; i<4; i++){
            for (int j = 0; j<4; j++){
                Button temp = new Button(symbols[j][i]+"");
                temp.minWidthProperty().bind(scene.widthProperty().subtract(25).divide(4));
                temp.minHeightProperty().bind(scene.heightProperty().divide(10).multiply(9).subtract(35).divide(4));
                temp.setFont(new Font(temp.getHeight()/3));
                temp.heightProperty().addListener(e->{
                    Font font = new Font(temp.getHeight()/3);
                    temp.setFont(font);
                });
                gridPane.add(temp, i,j,1,1);


                if (symbols[j][i] == '='){
                    temp.setOnAction(e->{
                        String input = textField.getText();
                        textField.setText("calculating...");

                        Task<String> task = new Task<String>() {
                            @Override
                            protected String call() throws Exception {
                                int sum = 0;
                                for (int k = 0; k <329999999; k++){
                                    Thread.sleep(  5 );
                                    sum = sum +k/2*4 +67;
                                }
                                return "result"+sum;
                            }
                        };

                        new Thread(task).start();
                        task.setOnSucceeded(ev->{
                            textField.setText(task.getValue());
                        });
                    });
                }
            }

        }
        return gridPane;
    }
}
