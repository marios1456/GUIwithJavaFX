package com.example.repeatprojekt;

import javafx.concurrent.Task;

public class Expensive extends Task<Double> {

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
        return 35d;
        }
}
