package com.example.stickhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

public class BandanaAnimation implements Runnable{
    private Timeline tanim;

    //SingleTon Design Pattern Implemented
    private static BandanaAnimation obj=null;
    public static BandanaAnimation getInstance(){
        if(obj==null){
            obj=new BandanaAnimation();
        }
        return obj;
    }

    private BandanaAnimation() {}

    public void bandanaAnimation(){
        Polygon b1=(Polygon)SceneManager.ap.lookup("#b1");
        Polygon b2=(Polygon)SceneManager.ap.lookup("#b2");
        Polygon b3=(Polygon)SceneManager.ap.lookup("#b3");
        Polygon b4=(Polygon)SceneManager.ap.lookup("#b4");

        tanim=new Timeline(new KeyFrame(Duration.millis(400), actionEvent -> {


            //System.out.println("Altering");
            Timeline temp0=new Timeline(new KeyFrame(Duration.millis(350),actionEventnull->
            {;}));
            temp0.setCycleCount(1);
            temp0.play();

            temp0.setOnFinished(actionEvent0 -> {

                b1.setVisible(false);
                b2.setVisible(false);
                b3.setVisible(true);
                b4.setVisible(true);
                //hand.setVisible(true);


                Timeline temp=new Timeline(new KeyFrame(Duration.millis(250),actionEventnull->
                {;}));
                //System.out.println("Restoring");
                temp.setOnFinished(actionEvent1 -> {

                    b3.setVisible(false);
                    b4.setVisible(false);
                    b2.setVisible(true);
                    b1.setVisible(true);
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
        bandanaAnimation();
    }

}
