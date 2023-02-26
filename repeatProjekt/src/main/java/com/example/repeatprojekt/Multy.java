package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Multy extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox vBox = new VBox(15);
        Button b1 = new Button("Button 1");

        //Task möglichst nicht im Listener registrieren.
        Task<Double> doubleTask = new Expensive();
        doubleTask.setOnSucceeded(ef -> {
            System.out.println("Succeeded");
            b1.setDisable(false);
            System.out.println(doubleTask.getValue());


        });
        Thread thread = new
                MyThread();

        b1.setOnAction(e -> {
            //thread.start();
            //thread.interrupt();
            //Do Something very long
        /*    double n = 0;
            for(int i = 1; i <1000000000; i++){
                n = n+ Math.sqrt(Math.round((i * 1000) /3.5 ));
                n = n+ Math.sqrt(Math.round((i * 1000) /3.5 ));
                n = n+ Math.sqrt(Math.round((i * 1000) /3.5 ));
            }*/

            b1.setDisable(true);

            new Thread(doubleTask).start();
            //doubleTask.cancel();
            System.out.println("Ready");


        });

        ProgressBar bar = new ProgressBar();
        bar.progressProperty().bind(doubleTask.progressProperty());


        Button b2 = new Button("Button 2");
        b2.setOnAction(e -> {
            System.out.println("Hallo");
            // Nach einer Sekunde wird button.setText("ko") aufgerufen,
            // aber aus einem falschen Ausfuehrungsthread
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            b2.setText("ko");
                        }
                    });
                    //b2.setText("ko");

                }
            }, 1000);

        });
        Button b3 = new Button("Button 1");
        Task<Double> doubleTask2 = new Task<Double>() {
            @Override
            protected Double call() throws Exception {
                System.out.println("entered");
                double n = 0;
                for (int i = 1; i < 1000000000; i++) {
                    if (!isCancelled()) {
                        n = n + (i * 1000) / 3.5;
                    } else break;
                }

                return n;
            }
        };
        doubleTask2.setOnSucceeded(e->{
            b3.setText("Ergebnis: " + doubleTask2.getValue());
        });

        b3.setOnAction(e -> {
//            Task<Double> doubleTask2 = new Task<Double>() {
//                @Override
//                protected Double call() throws Exception {
//                    System.out.println("entered");
//                    double n = 0;
//                    for (int i = 1; i < 1000000000; i++) {
//                        if (!isCancelled()) {
//                            n = n + (i * 1000) / 3.5;
//                        } else break;
//                    }
//                    b3.setText("Ergebnis: " + n);
//                    return n;
//                }
//            };

//            Thread t = new Thread(doubleTask2);
//            t.start();
            new Thread(doubleTask2).start();
            System.out.println("started");
        });

        vBox.getChildren().addAll(b1, bar, b2, b3);

        stage.setTitle("Hello World");
        stage.setScene(new Scene(vBox, 300, 275));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}