package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class Main extends Application {

    private boolean isCircle = true;
    private RadioButton redCircle;
    private RadioButton blueRectangel;
    private ArrayList<Command> commands = new ArrayList<>();
    private Stack<Command> redoStack = new Stack<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox(5.0);
        Pane paint = new Pane();
        paint.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();
            Shape shape;

            if (isCircle){
                shape = new Ellipse(x,y,10,10);
                shape.setFill(Color.RED);
            }else {
                shape = new Rectangle(x,y,10,10);
                shape.setFill(Color.BLUE);
            }
            DrawShapeCommand drawShapeCommand = new DrawShapeCommand(shape, paint);
            drawShapeCommand.execute();
            commands.add(drawShapeCommand);

            shape.setOnMouseClicked(ev->{
                ChangeColorCommand changeColorCommand = new ChangeColorCommand(shape);
                changeColorCommand.execute();
                commands.add(changeColorCommand);
                ev.consume();
            });
        });

        FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
        pane.setHgap(5.0);

        Button undoButton = new Button("Undo");
        undoButton.setOnAction(e ->{
            Command previousCommand = commands.remove(commands.size() -1 );
            previousCommand.undo();
            redoStack.push(previousCommand);
        });

        Button redoButton = new Button("Redo");
        redoButton.setOnAction(e ->{
            if (!redoStack.empty()){
                Command nextCommand = redoStack.pop();
                nextCommand.execute();
                commands.add(nextCommand);
            }
        });


        ToggleGroup group = new ToggleGroup();
        redCircle  = new RadioButton("Red Circle");
        redCircle.setSelected(true);
        redCircle.setOnAction(e->{
            isCircle = true;
        });
        blueRectangel = new RadioButton("Blue Rectangle");
        blueRectangel.setOnAction(e->{
            isCircle = false;
        });

        group.getToggles().addAll(redCircle, blueRectangel);
        pane.getChildren().addAll(redCircle,undoButton, redoButton, blueRectangel);

        pane.setAlignment(Pos.CENTER);

        VBox.setVgrow(paint, Priority.ALWAYS);
        box.getChildren().addAll(paint, pane);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(box, 750, 750));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
