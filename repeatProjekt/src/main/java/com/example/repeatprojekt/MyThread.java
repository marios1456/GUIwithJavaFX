package com.example.repeatprojekt;

public class MyThread extends Thread{

    @Override
    public void run() {


        double n = 0;
        for(int i = 1; i <1000000000; i++){


            n = n+ Math.sqrt(Math.round((i * 1000) /3.5 ));
            n = n+ Math.sqrt(Math.round((i * 1000) /3.5 ));
            n = n+ Math.sqrt(Math.round((i * 1000) /3.5 ));
        }
        System.out.println("Fertig!");


    }
}
