package com.example.stickhero;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Mines implements MinesAndCherries{
    private int xcoord;
    private int ycoord;
    private int updown;

    public Mines() {
        make();
    }
    Random random=new Random();
    public int getXcoord() {
        return xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public int getUpdown() {
        return updown;
    }

    private static Image bombimage=new Image("bomb.png");
    public ImageView createImageView(double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect) {
        ImageView imageView = new ImageView(bombimage);
        imageView.setLayoutX(layoutX);
        imageView.setLayoutY(layoutY);
        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);
        imageView.setRotate(rotate);
        imageView.setEffect(effect);
        return imageView;
    }
    public ImageView make(){
        System.out.println("Mine functioninvoked");


        System.out.println("Looping  mines");
            int y=560;
            int n;
            if(((int) Pillars.getLastpillar().getX() - 120>125)) {
                n = random.nextInt(((int) Pillars.getLastpillar().getX() - 120) - 125 + 1) + 125;
                if(n%2==0){
                    y=510;
                }
                return createImageView(n, y, 35.0, 30.0, 0.0, new Glow());
            }
            return null;
//            if (n> 75 && n < Pillars.getLastpillar().getX() - 55) {



    }

}
