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
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static java.lang.Thread.sleep;

public class Calculator2 extends Application {
    private  char[][] keyboardSymbols = {{'7','8','9','/'},{'4','5','6','*'},{'1','2','3','4'},{'0','c','=','+'}};
    GridPane keyboard =  new GridPane();
    TextField inputField;
    @Override
    public void start(Stage stage){
        BorderPane bp =  new BorderPane();
        inputField = new TextField();
        createKeyboard();

        bp.setTop(inputField);
        bp.setMargin(inputField, new Insets(5));
        //inputField.setPadding(new Insets(5));
        bp.setCenter(keyboard);
        bp.setMargin(keyboard, new Insets(5));
        //keyboard.setPadding(new Insets(5));


        Scene scene =  new Scene(bp,400,400);
        scene.getStylesheets().add(Calculator2.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


        inputField.minHeightProperty().bind(scene.heightProperty().divide(10));
        inputField.heightProperty().addListener((obs,o,n)->{
            inputField.setFont(new Font(inputField.getHeight()/3));
        });

        keyboard.setAlignment(Pos.CENTER);
        keyboard.minWidthProperty().bind(scene.widthProperty().subtract(20));
        keyboard.minHeightProperty().bind(scene.heightProperty().divide(10).multiply(9).subtract(20));
        scene.setOnKeyPressed(e->{
            if (e.getText()!="c" && e.getText()!="=")
                inputField.appendText(e.getText());
        });
    }

    private void createKeyboard(){
        for (int i= 0; i < 4; i++){
            for (int j = 0; j<4; j++){
                Button temp = createButton(i,j);

                keyboard.add(temp,j,i,1,1);
            }
        }
        keyboard.setHgap(3);
        keyboard.setVgap(3);
    }
    private Button createButton(int i, int j){
        Button temp = new Button(keyboardSymbols[i][j]+"");
        temp.minWidthProperty().bind(keyboard.widthProperty().subtract(9).divide(4));
        temp.minHeightProperty().bind(keyboard.heightProperty().subtract(9).divide(4));
        //temp.fontProperty().bind(temp.heightProperty().divide(3));
        temp.heightProperty().addListener((obs, o, n)->{
            temp.setFont(new Font(temp.getHeight()/3));
        });

        if (keyboardSymbols[i][j]!='=' && keyboardSymbols[i][j]!='c')
            temp.setOnAction(e->{
                inputField.appendText(temp.getText());
            });
        else{
            Task<String> task= new Task<String>(){
                @Override
                public String call() throws Exception{
                    double n = 0;
                    int max = 100000000;
                    for(int i = 1; i <max; i++){
                        if(!isCancelled()) {
                            n = n + Math.sqrt(Math.round((i * 1000) / 3.5));
                            updateProgress(i, max);
                        }else
                            break;
                    }
                    System.out.println("Ready");
                    return "hi";
                }
            };
            task.setOnSucceeded(e->{
                inputField.setText("Success");
            });
            temp.setOnAction(e->{
                inputField.setText("Calculating");
                try {
                    sleep(200);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                new Thread(task).run();
            });
        }




        return temp;
    }
}
