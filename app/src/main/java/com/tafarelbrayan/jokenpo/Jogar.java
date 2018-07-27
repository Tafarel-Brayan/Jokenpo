package com.tafarelbrayan.jokenpo;

public class Jogar extends Thread {

    public void run(){

        try {
            Thread.sleep(3000);
            System.out.println("executou");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
