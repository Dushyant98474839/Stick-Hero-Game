package com.example.stickhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Sticks {
    public Sticks() {
    }
    public static Rectangle rect;
    private static double angle = 0;

    private static double distance;

    public double getDistance() {
        return distance;
    }

    public double getAngle() {
        return angle;
    }
    private static Timeline t;
    private static boolean flag=false;
    public void growStick(Rectangle rect){
        System.out.println("Stickcalss");
        rect.setHeight(rect.getHeight()+5);
        rect.setY(rect.getY()-5);
    }
    public void fallStick(Rectangle rect){
        double heropY=Pillars.getHeropillar().getY();
        double heropX=Pillars.getHeropillar().getX();
        double lastpY=Pillars.getLastpillar().getY();
        double lastpX=Pillars.getLastpillar().getX();
        distance = Math.sqrt(Math.pow((heropX - lastpX), 2) + Math.pow((heropY - lastpY), 2));
        angle=90;

        t= new Timeline(new KeyFrame(Duration.millis(10.5), event -> {
            Rotate rotate = new Rotate();
            rotate.setPivotX(rect.getX() + 5);
            rotate.setPivotY(rect.getY() + rect.getHeight());
            rotate.setAngle(1);
            rect.getTransforms().add(rotate);
        }));
        t.setCycleCount(90);
        t.play();

    }
    public static void stopStickAnimation(){
        flag=false;
        if(t!=null){
            t.pause();
            flag=true;
        }
    }
    public static void resumeStickAnimation(){
        if(t!=null){
        if (Animation.Status.PAUSED==t.getStatus()){
            t.play();
        }
        }
    }

}
