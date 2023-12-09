package com.example.stickhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Multithreading extends Thread{

    private static Timeline tanim;
    public static void runningAnimation(){
        Rectangle rightleg=(Rectangle)SceneManager.ap.lookup("#rightleg");
        Rectangle leftleg=(Rectangle)SceneManager.ap.lookup("#leftleg");
        Rectangle animleg=(Rectangle)SceneManager.ap.lookup("#animleg");
        //Rectangle hand=(Rectangle)SceneManager.ap.lookup("#hand");
        Polygon b1=(Polygon)SceneManager.ap.lookup("#b1");
        Polygon b2=(Polygon)SceneManager.ap.lookup("#b2");
        Polygon b3=(Polygon)SceneManager.ap.lookup("#b3");
        Polygon b4=(Polygon)SceneManager.ap.lookup("#b4");


        tanim=new Timeline(new KeyFrame(Duration.millis(200), actionEvent -> {

            if(!OurHero.isHeromovingflag()){
                tanim.stop();
            }
           // System.out.println("Altering");
            Timeline temp0=new Timeline(new KeyFrame(Duration.millis(100),actionEventnull->
            {;}));
            temp0.setCycleCount(1);
            temp0.play();

            temp0.setOnFinished(actionEvent0 -> {
            rightleg.setVisible(false);
            leftleg.setVisible(false);
            animleg.setVisible(true);
//            b1.setVisible(false);
//            b2.setVisible(false);
//            b3.setVisible(true);
//            b4.setVisible(true);
            //hand.setVisible(true);


            Timeline temp=new Timeline(new KeyFrame(Duration.millis(100),actionEventnull->
            {;}));
           // System.out.println("Restoring");
            temp.setOnFinished(actionEvent1 -> {
            rightleg.setVisible(true);
            leftleg.setVisible(true);
            animleg.setVisible(false);
//                b3.setVisible(false);
//                b4.setVisible(false);
//                b2.setVisible(true);
//                b1.setVisible(true);
            //hand.setVisible(false);
            });
            temp.setCycleCount(1);
            temp.play();
            } );
        }));
        tanim.setCycleCount(Animation.INDEFINITE);
        tanim.play();
    }

    @Override
    public void run(){
        runningAnimation();
    }
}
