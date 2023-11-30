package com.example.stickhero;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;

public class Pillars {
    public Pillars() {
    }
    private static Rectangle lastpillar;
    private static Rectangle heropillar;
    public static Rectangle getLastpillar() {
        return lastpillar;
    }

    public static Rectangle getHeropillar() {
        return heropillar;
    }

    public static void setLastpillar(Rectangle lastpillar) {
        Pillars.lastpillar = lastpillar;
    }

    public static void setHeropillar(Rectangle heropillar) {
        Pillars.heropillar = heropillar;
    }

    public Rectangle makeFirstPillar(){
        Rectangle rect=new Rectangle();
        rect.setHeight(250);
        rect.setWidth(75);
        rect.setFill(Color.BLACK);
        rect.setY(SceneManager.height-rect.getHeight());
        rect.setX(0);
        lastpillar=rect;
        heropillar=rect;
        return rect;
    }
    public Rectangle makePillars(){
        System.out.println("pillarloop");
        double xlast=lastpillar.getX();
        Rectangle rect=new Rectangle();
        rect.setHeight(250);
        rect.setWidth(randomWidth());
        //rect.setY(SceneManager.height-rect.getHeight());
        int x= (int) (randomX(rect.getWidth()));
        rect.setX(x);
        rect.setY(1000);
        rect.setFill(Color.BLACK);
        lastpillar=rect;
        System.out.println("Pillar Generated");
        return rect;
    }
    /*when translate:
    heropillar=lastpillar
    addpillar, so now lastpillar=newly added pillar
     */
//    public int randomHeight(){
//        int height=(int)(Math.random()*1000);
//        while(!(height>=70&&height<=500)){
//            height=(int) (Math.random()*1000);
//        }
//        return height;
//    }
    public int randomWidth(){
        System.out.println("Pillarwidthlopp");
        int width=(int)(Math.random()*1000);
        while(!(width>=25 && width<=350)){
            width=(int)(Math.random()*1000);
        }
        return width;
    }
    public int randomX(double width){

        int X = (int) (Math.random() * 1000);
        while(!(X >= 75+50 && X <= 600-width-5)) {
            System.out.println("RandomX "+lastpillar.getWidth()+25+" "+width);
            System.out.println("75,"+X);
            X = (int) (Math.random() * 1000);
        }
        System.out.println("PillarXLoop");
        return X;
    }
}

