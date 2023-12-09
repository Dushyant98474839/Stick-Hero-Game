package com.example.stickhero;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Random;

public class Cherries implements MinesAndCherries {
    private int xcoord;
    private int ycoord;
    private int updown;

    public Cherries() {
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
    private static ImageView imageView=null;
    private static Image cherryimage=new Image("cherry.png");
    public ImageView createImageView(double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect) {


        imageView = new ImageView(cherryimage);

        imageView.setLayoutX(layoutX);
        imageView.setLayoutY(layoutY);
        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);
        imageView.setRotate(rotate);
        imageView.setEffect(effect);
        return imageView;
    }
    public ImageView make() {
        //Pillars.getLastpillar().getX()-55,75
        System.out.println("Cherry function invoked");

        System.out.println("cherry");
        if ((int) Pillars.getLastpillar().getX() - 55 - 75 > 0) {
            int n = random.nextInt(((int) Pillars.getLastpillar().getX() - 55 - 75) + 1) + 75;
            System.out.println("Cherry X coordinate: " + n);
            return createImageView(n, 550.0, 50.0, 45.0, 0.0, new Glow());
        }

        System.out.println("No cherry created");
        return null;
    }

    }
