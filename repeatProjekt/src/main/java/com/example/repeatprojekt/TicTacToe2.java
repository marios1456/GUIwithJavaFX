package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToe2 extends Application {
    boolean isXturn = true;
    char[][] symbol = new char[3][3];
    Canvas[][] cells = new Canvas[3][3];
    Label message;
    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();

        message = new Label("its Xs turn");

        GridPane gp = new GridPane();
        Scene scene = new Scene(vBox,300,310);
        for (int i = 0; i<3; i++){
            for (int j = 0; j<3; j++){
                Canvas canvas = new Canvas(100,100);
                canvas.setId(j + i*3 +"");
                cells[i][j] = canvas;
                scene.widthProperty().addListener(e->{
                    canvas.setWidth(scene.getWidth()/3);
                    redrawCell();
                });
                scene.heightProperty().addListener(e->{
                    canvas.setHeight(scene.getHeight()/3-10);
                    redrawCell();
                });
                GraphicsContext context = canvas.getGraphicsContext2D();
                canvas.setOnMouseClicked(e->{
                    int id = Integer.parseInt(canvas.getId());
                    if (symbol[id/3][id % 3] != 0){
                        return;
                    }
                    if (isXturn){
                        context.setLineWidth(5);
                        context.strokeLine(0,0,canvas.getWidth(),canvas.getHeight());
                        context.strokeLine(0,canvas.getHeight(),canvas.getWidth(),0);
                        message.setText("its Os turn");
                        symbol[id/3][id % 3] = 'X';
                    }else {
                        context.setFill(Color.BLACK);
                        context.fillOval(0,0,canvas.getWidth(),canvas.getHeight());
                        message.setText("its Xs turn");
                        symbol[id/3][id % 3] = 'O';
                    }
                    checkForWinner();
                    isXturn = !isXturn;

                });
                gp.add(canvas,i,j,1,1);
            }
        }
        gp.setGridLinesVisible(true);
        vBox.getChildren().addAll(gp,message);
        stage.setScene(scene);
        stage.show();
    }

    private void redrawCell(){
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                Canvas canvas = cells[i][j];
                GraphicsContext context = canvas.getGraphicsContext2D();
                context.setFill(Color.WHITE);
                context.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
                if (symbol[i][j] == 'X'){
                    context.setLineWidth(5);
                    context.strokeLine(0,0,canvas.getWidth(),canvas.getHeight());
                    context.strokeLine(0,canvas.getHeight(),canvas.getWidth(),0);

                }else if (symbol[i][j] == 'O'){
                    context.setFill(Color.BLACK);
                    context.fillOval(0,0,canvas.getWidth(),canvas.getHeight());
                }
            }
        }
    }
    public void checkForWinner(){
        int rows[] = {0,0,0};
        for (int i = 0; i<3; i++) {
            int column = 0;
            for (int j = 0; j < 3; j++) {
                if (isXturn && (symbol[i][j] == 'X')){
                    rows[j] +=1;
                    column +=1;
                }else {
                    rows[j] +=1;
                    column +=1;
                }
            }
            if (column == 3){
                message.setText(isXturn? "X":'0' +" has Won");
                return;
            }
        }
        for (int i = 0; i<3; i++){
            if (rows[i] == 3){
                message.setText(isXturn? "X":"0" +" has Won");
                break;
            }
        }
    }
}
