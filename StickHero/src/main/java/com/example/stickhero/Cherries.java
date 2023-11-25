package com.example.stickhero;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Cherries {
    private int xcoord;
    private int ycoord;
    private int updown;

    public Cherries() {
        makecherries();
    }

    public int getXcoord() {
        return xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public int getUpdown() {
        return updown;
    }


    public ImageView createImageView(String imageUrl, double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect) {
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setLayoutX(layoutX);
        imageView.setLayoutY(layoutY);
        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);
        imageView.setRotate(rotate);
        imageView.setEffect(effect);
        return imageView;
    }
    public ImageView makecherries() {
        //Pillars.getLastpillar().getX()-55,75
        while (true) {
            int n=(int)(Math.random()*1000);
            if (n> 75 && n < Pillars.getLastpillar().getX() - 55) {
                return createImageView("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\cherry.png", n, 750.0, 50.0, 45.0, 0.0, new Glow());
            }
        }
    }

    public static void checkCollision(AnchorPane ap, Rectangle p){
        if(ap.getBoundsInParent().intersects(p.getBoundsInParent())&& OurHero.isFlipped()){
            SceneManager.setContinueflag(false);
            SceneManager.setTransflag(false);
            OurHero.setFlipped(false);
        }
    }
}
