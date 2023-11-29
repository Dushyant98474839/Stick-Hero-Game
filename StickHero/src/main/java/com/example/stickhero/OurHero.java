package com.example.stickhero;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.IOException;
import java.security.PublicKey;

import static com.example.stickhero.SceneManager.offsetY;
import static com.example.stickhero.SceneManager.t;

public class OurHero {
    static Pillars pillars=new Pillars();
    private static int score=0;

    public static int getScore() {
        return score;
    }

    public static boolean isHeromovingflag() {
        return heromovingflag;
    }

    public static void setHeromovingflag(boolean heromovingflag) {
        OurHero.heromovingflag = heromovingflag;
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
    private static Timeline tanim;
    public static int getCherrycount() {
        return cherrycount;
    }

    public static void setCherrycount(int cherrycount) {
        OurHero.cherrycount = cherrycount;
    }

        private static boolean heromovingflag=false;
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
    private static TranslateTransition trn0;
    private static TranslateTransition trn2;
    private static TranslateTransition trn;
    private static TranslateTransition trn3;
    private static TranslateTransition trn4;

    public static TranslateTransition getTrn0() {
        return trn0;
    }

    public static void setTrn0(TranslateTransition trn0) {
        OurHero.trn0 = trn0;
    }

    public static TranslateTransition getTrn2() {
        return trn2;
    }

    public static void setTrn2(TranslateTransition trn2) {
        OurHero.trn2 = trn2;
    }

    public static TranslateTransition getTrn() {
        return trn;
    }

    public static void setTrn(TranslateTransition trn) {
        OurHero.trn = trn;
    }

    public static TranslateTransition getTrn3() {
        return trn3;
    }

    public static void setTrn3(TranslateTransition trn3) {
        OurHero.trn3 = trn3;
    }

    public static TranslateTransition getTrn4() {
        return trn4;
    }

    public static void setTrn4(TranslateTransition trn4) {
        OurHero.trn4 = trn4;
    }

    public static void moveHero(){
        heromovingflag=false;
        Sticks ob=new Sticks();
        //SceneManager.ap.getTransforms().add(new Rotate(-ob.getAngleactual()));
        //System.out.println(SceneManager.rec.getX());
        //System.out.println(SceneManager.ap.getLayoutX());
        Button b1 = (Button) PauseMenu.root.lookup("#mainmenu");
        System.out.println(b1);
        //b1.setDisable(true);
        System.out.println("Disabled");

        Rectangle r=(Rectangle) SceneManager.ap.lookup("#hand");
        r.setVisible(true);

        trn0=new TranslateTransition(Duration.millis(300),SceneManager.ap);
        trn0.setByY(-7);
        trn0.play();
        trn0.setOnFinished(eve -> {
            heromovingflag=true;
            Multithreading leganimthread=new Multithreading();
            leganimthread.start();

         trn2=new TranslateTransition(Duration.millis(1500),SceneManager.ap);
        trn2.setToX(SceneManager.rec.getHeight()+SceneManager.rec.getX()-50);

        trn2.play();
        trn2.setOnFinished(evet -> {

        if(SceneManager.rec.getHeight()+SceneManager.rec.getX()+5<Pillars.getLastpillar().getX()){
            r.setVisible(false);
            heromovingflag=false;
            b1.setDisable(false);
            //stopRunningAnimation();
            trn=new TranslateTransition(Duration.millis(1000),SceneManager.ap);
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
            r.setVisible(false);
            heromovingflag=false;
            b1.setDisable(false);
            //stopRunningAnimation();
            trn=new TranslateTransition(Duration.millis(500),SceneManager.ap);
            trn.setToX(SceneManager.rec.getHeight()+SceneManager.rec.getX()+5);
            trn.play();
            trn.setOnFinished(event -> {
                trn3=new TranslateTransition(Duration.millis(1000),SceneManager.ap);
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
            heromovingflag=true;
            Buttons.setCanFlip(false);
            trn=new TranslateTransition(Duration.millis(50),SceneManager.ap);
            trn.setByX(25);
            trn.play();
            trn.setOnFinished(event -> {

                trn3=new TranslateTransition(Duration.millis(50),SceneManager.ap);
                trn3.setByY(7);
                trn3.play();
                trn3.setOnFinished(event1 -> {
                   trn4=new TranslateTransition(Duration.millis(500),SceneManager.ap);
                   trn4.setToX(Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()-70);
                   trn4.play();
                   trn4.setOnFinished(event2 -> {
                       b1.setDisable(false);
                       SceneManager.translateAfterLanding();
                       //SceneManager.setTransflag(true);

                       //stopRunningAnimation();
                       score+=1;
                       heromovingflag=false;
                       r.setVisible(false);

                       //SceneManager.returnSticktoDefault();
                       //heromovedflag = true;

                   });
                });
            });
        }});
        leganimthread.interrupt();});

    }
//    static boolean f1,f2,f3,f4,f5;
//
//    private static void ini(){
//        f1=false;
//        f2=false;
//        f3=false;
//        f4=false;
//        f5=false;
//
//    }
//    public static void stopAnimation(){
//        ini();
//        if(trn0!=null){
//        trn0.statusProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == TranslateTransition.Status.RUNNING) {
//                f1=true;
//                trn0.pause();
//                System.out.println("trn0");
//            }
//        });}
//        else{
//            System.out.println("trn0 is null");
//        }
//        if(trn!=null){
//        trn.statusProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == TranslateTransition.Status.RUNNING) {
//                f2=true;
//                trn.pause();System.out.println("trn");
//            }
//        });}
//        else{
//            System.out.println("trn is null");
//        }
//        if(trn2!=null){
//        trn2.statusProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == TranslateTransition.Status.RUNNING) {
//                f3=true;
//                trn2.pause();System.out.println("trn2");
//            }
//        });}
//        else{
//            System.out.println("trn2 is null");
//        }
//        if(trn3!=null){
//        trn3.statusProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == TranslateTransition.Status.RUNNING) {
//                f4=true;
//                trn3.pause();System.out.println("trn3");
//            }
//        });}
//        else{
//            System.out.println("trn3 is null");
//        }
//        if(trn4!=null){
//        trn4.statusProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == TranslateTransition.Status.RUNNING) {
//                f5=true;
//                trn4.pause();System.out.println("trn4");
//            }
//        });}
//        else{
//            System.out.println("trn4 is null");
//        }
//    }
//
//    public static void resumeAnimation(){
//        if(f1){
//            trn0.play();
//        }
//        if (f2){
//            trn.play();
//        }
//        if (f3){
//            trn2.play();
//        }
//        if (f4){
//            trn3.play();
//        }
//        if (f5){
//            trn4.play();
//        }


    public static void flipHero(){
        if(flipped==false) {
            SceneManager.ap.setScaleY(-1);
            SceneManager.ap.setLayoutY(Pillars.getLastpillar().getY() + offsetY + 57);
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
