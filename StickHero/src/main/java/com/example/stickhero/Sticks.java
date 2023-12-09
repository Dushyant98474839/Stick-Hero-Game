package com.example.stickhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

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
        rect.setHeight(rect.getHeight()+4);
        rect.setY(rect.getY()-4);
    }

    public void fallStick(Rectangle rect){
        double heropY=Pillars.getHeropillar().getY();
        double heropX=Pillars.getHeropillar().getX();
        double lastpY=Pillars.getLastpillar().getY();
        double lastpX=Pillars.getLastpillar().getX();
        distance = Math.sqrt(Math.pow((heropX - lastpX), 2) + Math.pow((heropY - lastpY), 2));
        angle=90;

        t= new Timeline(new KeyFrame(Duration.millis(7.5), event -> {
            Rotate rotate = new Rotate();
            rotate.setPivotX(rect.getX() + 5);
            rotate.setPivotY(rect.getY() + rect.getHeight());
            rotate.setAngle(1);
            rect.getTransforms().add(rotate);
        }));
        t.setCycleCount(90);
        System.out.println("Stick rotate start");
        t.play();
        SoundDesign objb=new SoundDesign(9);
        new Thread(objb).start();
        t.setOnFinished(actionEvent -> {
            SoundDesign soundObjj=new SoundDesign(1);
            new Thread(soundObjj).start();
            System.out.println("Stick Rotate finsihed");
                if(SceneManager.isContinueflag()) {
                    Buttons.setCanFlip(true);
                    System.out.println("Hero can now flip");
                    System.out.println("Hero moving");
                    OurHero.moveHero();
                }
                else {
                    System.out.println("Stick animation stopped");
                    t.stop();
                    OurHero.setFlipped(false);
                }
            });


//        else {
//            t.setOnFinished(actionEvent -> {
//                SceneManager.setContinueflag(false);
//            });
//        }
    }
    public static void stopStickAnimation(){
        flag=false;
        check_flag_false(flag);

        if(t!=null){
            t.pause();
            flag=true;
            check_flag_true(flag);

        }
    }
    @Test
    public static void check_flag_false(boolean flag)
    {
        assertFalse(flag);
    }

    @Test
    public static void check_flag_true(boolean flag)
    {
        assertTrue(flag);
    }
    public static void resumeStickAnimation(){
        if(t!=null)
        {
            check_not_null(t);
            if (Animation.Status.PAUSED==t.getStatus()){
                t.play();
            }
        }
        else {
            check_null(t);
        }

    }
    @Test
    public static void check_not_null(Timeline t)
    {
        assertNotNull(t);
    }

    @Test
    public static void check_null(Timeline t)
    {
        assertNull(t);
    }


}
