package com.example.stickhero;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.IOException;

import static com.example.stickhero.SceneManager.offsetY;

public class OurHero {
    static Pillars pillars=new Pillars();
    private static int score=0;

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        OurHero.score = score;
    }

    public static boolean isFlipped() {
        return flipped;
    }

    public static void setFlipped(boolean flipped) {
        OurHero.flipped = flipped;
    }

    private static boolean flipped=false;
    private static int cherrycount=0;
    private static int stickalign=1;

    public static int getCherrycount() {
        return cherrycount;
    }

    public static void setCherrycount(int cherrycount) {
        OurHero.cherrycount = cherrycount;
    }

    //    private static boolean heromovedflag=false;
//
//    public static boolean isHeromovedflag() {
//        return heromovedflag;
//    }
//
//    public static void setHeromovedflag(boolean heromovedflag) {
//        OurHero.heromovedflag = heromovedflag;
//    }

    public AnchorPane createHero() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        AnchorPane ap=new AnchorPane();
        ap=fxmlLoader.load();
        return ap;
    }
    public static void moveHero(){
        Sticks ob=new Sticks();
        //SceneManager.ap.getTransforms().add(new Rotate(-ob.getAngleactual()));
        //System.out.println(SceneManager.rec.getX());
        //System.out.println(SceneManager.ap.getLayoutX());
        TranslateTransition trn0=new TranslateTransition(Duration.millis(300),SceneManager.ap);
        trn0.setByY(-5);
        trn0.play();
        trn0.setOnFinished(eve -> {
        TranslateTransition trn2=new TranslateTransition(Duration.millis(2000),SceneManager.ap);
        trn2.setToX(SceneManager.rec.getHeight()+SceneManager.rec.getX()-50);

        trn2.play();
        trn2.setOnFinished(evet -> {
        if(SceneManager.rec.getHeight()+SceneManager.rec.getX()+5<Pillars.getLastpillar().getX()){
            TranslateTransition trn=new TranslateTransition(Duration.millis(1000),SceneManager.ap);
            ob.fallStick(SceneManager.rec);
            Rotate rotate=new Rotate();
            rotate.setAngle(30);                        //special feature, rotates before falling
            SceneManager.ap.getTransforms().add(rotate);
            trn.setToY(255);
            trn.play();
            trn.setOnFinished(event -> {
                SceneManager.setContinueflag(false);
                Buttons.setCanFlip(false);
            });
        } else if (SceneManager.rec.getHeight()+SceneManager.rec.getX()+5>Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()) {
            TranslateTransition trn=new TranslateTransition(Duration.millis(500),SceneManager.ap);
            trn.setToX(SceneManager.rec.getHeight()+SceneManager.rec.getX()+5);
            trn.play();
            trn.setOnFinished(event -> {
                TranslateTransition trn3=new TranslateTransition(Duration.millis(1000),SceneManager.ap);
                Rotate rotate=new Rotate();
                rotate.setAngle(30);                        //special feature, rotates before falling
                SceneManager.ap.getTransforms().add(rotate);
                trn3.setToY(255);
                trn3.play();
                trn3.setOnFinished(event1 -> {
                    SceneManager.setContinueflag(false);
                    Buttons.setCanFlip(false);
                });
            });

        }
        else{
            TranslateTransition trn=new TranslateTransition(Duration.millis(50),SceneManager.ap);
            trn.setByX(25);
            trn.play();
            trn.setOnFinished(event -> {
                TranslateTransition trn3=new TranslateTransition(Duration.millis(50),SceneManager.ap);
                trn3.setByY(5);
                trn3.play();
                trn3.setOnFinished(event1 -> {
                   TranslateTransition trn4=new TranslateTransition(Duration.millis(500),SceneManager.ap);
                   trn4.setToX(Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()-70);
                   trn4.play();
                   trn4.setOnFinished(event2 -> {
                       SceneManager.translateAfterLanding();
                       SceneManager.setTransflag(true);
                       Buttons.setCanFlip(false);
                       score+=1;
                       //SceneManager.returnSticktoDefault();
                       //heromovedflag = true;

                   });
                });
            });
        }});});

    }

    public static void flipHero(){
        if(flipped==false) {
            SceneManager.ap.setScaleY(-1);
            SceneManager.ap.setLayoutY(Pillars.getLastpillar().getY() + offsetY + 55);
            flipped=true;
        }
        else {
            SceneManager.ap.setScaleY(1);
            SceneManager.ap.setLayoutY(Pillars.getLastpillar().getY() + offsetY );
            flipped=false;
        }

    }

    public void collectcherries(){
        cherrycount++;
    }
    public void stepsOnMines(){
        //gameover;
    }
}
