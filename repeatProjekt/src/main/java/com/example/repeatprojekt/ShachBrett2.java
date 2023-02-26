package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShachBrett2 extends Application {
    private boolean[][] brett = {{false,true,false,true,false,true,false,true},
                                {true,false,true,false,true,false,true,false},
                                {false,true,false,true,false,true,false,true},
                                {true,false,true,false,true,false,true,false},
                                {false,true,false,true,false,true,false,true},
                                {true,false,true,false,true,false,true,false},
                                {false,true,false,true,false,true,false,true},
                                {true,false,true,false,true,false,true,false}};
    private Canvas canvas;
    private Scene scene;
    private ColorPicker colorPicker;
    @Override
    public void start(Stage stage){
        VBox vBox = new VBox();
        canvas = new Canvas(300,300);
        GraphicsContext context = canvas.getGraphicsContext2D();
        colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(e->{
            drawSchachBrett(context);
        });
        vBox.getChildren().addAll(canvas,colorPicker);
        scene = new Scene(vBox,300,330);

        stage.setScene(scene);
        stage.show();

        drawSchachBrett(context);
        scene.heightProperty().addListener(e->{
            canvas.setHeight(scene.getHeight()-30);
            drawSchachBrett(context);

        });
        scene.widthProperty().addListener(e->{
            canvas.setWidth(scene.getWidth());
            drawSchachBrett(context);
        });


    }
    private void drawSchachBrett(GraphicsContext context){
        context.setFill(Color.WHITE);
        context.fillRect(0,0,scene.getWidth(),scene.getHeight());
        Color color = colorPicker.getValue();
        for (int i = 0;i<8;i++){
            for (int j = 0;j<8;j++){
                if (brett[i][j]){
                    context.setFill(color);
                    context.fillRect(i*canvas.getWidth()/8,j*canvas.getHeight()/8,canvas.getWidth()/8, canvas.getHeight()/8);
                }
            }
        }
    }
}
