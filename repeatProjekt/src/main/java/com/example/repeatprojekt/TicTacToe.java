package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TicTacToe extends Application {
    private boolean xTurn = true;
    private boolean[] isX = {false,false,false,false,false,false,false,false,false};
    private boolean[] isO = {false,false,false,false,false,false,false,false,false};
    BorderPane bp;
    private GridPane gp;
    @Override
    public void start(Stage stage){
        bp = new BorderPane();
        gp = createGrid(bp);
        bp.setCenter(gp);



        Scene scene = new Scene(bp);
        stage.setScene(scene);
        stage.show();
    }

    public GridPane createGrid(BorderPane borderPane){
        GridPane gp = new GridPane();
        for (int i=0; i < 3; i++){
            for (int j=0; j<3; j++){
                Canvas canvas = new Canvas(50,50);
                canvas.setId(Integer.toString(i + 3*j));
                canvas.widthProperty().bind(borderPane.widthProperty().divide(3));
                canvas.heightProperty().bind(borderPane.heightProperty().divide(3));
                addClickListenerToCanvas(canvas);
                addResizeListenerToCanvas(canvas);
                gp.add(canvas,i,j,1,1);
            }
        }
        gp.setGridLinesVisible(true);
        return gp;
    }
    public void addClickListenerToCanvas(Canvas canvas){
        canvas.setOnMouseClicked(e->{
            GraphicsContext gc = canvas.getGraphicsContext2D();
            // draw on click
            if (xTurn){
                gc.setLineWidth(10);
                gc.strokeLine(5,5, canvas.getWidth()-5,canvas.getHeight()-5);
                gc.strokeLine(canvas.getWidth()-5,5, 5,canvas.getHeight()-5);
                isX[Integer.parseInt(canvas.getId())]= true;
            }
            else {
                gc.setFill(Color.BLACK);
                gc.fillOval(5,5, canvas.getWidth()-5,canvas.getHeight()-5);
                isO[Integer.parseInt(canvas.getId())]= true;
            }

            // check for winner
            if (haveWinner()) {
                System.out.println("We have a Winner" + (xTurn ? "its the X" : "its the O"));
                // restart the game
                xTurn = true;
                Arrays.fill(isX, Boolean.FALSE);
                Arrays.fill(isO, Boolean.FALSE);
                bp.setCenter(createGrid(bp));
            }
            xTurn = !xTurn;

        });

    }

    public boolean haveWinner(){
        // check rows and columns
        int col[] = {0,0,0};
        for (int i=0; i < 3; i++) {
            int row = 0;
            for (int j = 0; j < 3; j++) {
                if (xTurn){
                    row += isX[i +3*j] ? 1: 0;              //Note row points
                    col[(3*j + 1)/3] += isX[i +3*j] ? 1: 0; //Note column points
                }else {
                    row += isO[i +3*j] ? 1: 0;              //Note row points
                    col[(3*j + 1)/3] += isO[i +3*j] ? 1: 0; //Note column points
                }
            }
            if (row == 3)
                return true;
        }
        if (col[0] == 3 || col[1] == 3 || col[2] == 3)
            return true;

        //check main diagonal
        if (xTurn){
            if (isX[0] && isX[4] && isX[8])
                return true;
        }else {
            if (isO[0] && isO[4] && isO[8])
                return true;
        }

        // other diagonal
        if (xTurn){
            return isX[2] && isX[4] && isX[6];
        }else {
            return  (isO[2] && isO[4] && isO[6]);
        }
    }
    public void addResizeListenerToCanvas(Canvas canvas){
        canvas.widthProperty().addListener((obs, oldVal, newVal)->{
            System.out.println("hello");
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.WHITE);
            gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
            if (isX[Integer.parseInt(canvas.getId())]){
                gc.setLineWidth(10);
                gc.strokeLine(5,5, canvas.getWidth()-5,canvas.getHeight()-5);
                gc.strokeLine(canvas.getWidth()-5,5, 5,canvas.getHeight()-5);
            }
            else if (isO[Integer.parseInt(canvas.getId())]){
                gc.setFill(Color.BLACK);
                gc.fillOval(5,5, canvas.getWidth()-5,canvas.getHeight()-5);
            }
        });




        canvas.heightProperty().addListener((obs, oldVal, newVal)->{
            System.out.println("hello");
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(Color.WHITE);
            gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
            if (isX[Integer.parseInt(canvas.getId())]){
                gc.setLineWidth(10);
                gc.strokeLine(5,5, canvas.getWidth()-5,canvas.getHeight()-5);
                gc.strokeLine(canvas.getWidth()-5,5, 5,canvas.getHeight()-5);
            }
            else if (isO[Integer.parseInt(canvas.getId())]){
                gc.setFill(Color.BLACK);
                gc.fillOval(5,5, canvas.getWidth()-5,canvas.getHeight()-5);
            }
        });
    }
}
