package com.example.stickhero;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;
import java.security.PublicKey;

import static com.example.stickhero.SceneManager.offsetY;
import static com.example.stickhero.SceneManager.t;

public class OurHero implements Serializable {
    private int score=0;

    private OurHero(){}


    //SINGLETON DESIGN PATTERN: used massively
    private static OurHero obj=null;

    public static OurHero getInstance(){
        if(obj==null){
            obj=new OurHero();
        }
        return obj;
    }
    public static void setHero(OurHero objLoad){
        obj=objLoad;
    }
    public int getScore() {
        return this.score;
    }

    public static boolean isHeromovingflag() {
        return heromovingflag;
    }

    public static void setHeromovingflag(boolean heromovingflag) {
        OurHero.heromovingflag = heromovingflag;
    }

    public void setScore(int sc) {
        this.score = sc;
    }

    public static boolean isFlipped() {
        return flipped;
    }

    public static void setFlipped(boolean flipped) {
        OurHero.flipped = flipped;
    }

    private static transient boolean flipped=false;
    private int cherrycount=0;
    public int getCherrycount() {
        return cherrycount;
    }

    public void setCherrycount(int cherrycount) {
        this.cherrycount = cherrycount;
    }

        private static transient boolean heromovingflag=false;
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
    private static transient TranslateTransition trn0;
    private static transient TranslateTransition trn2;
    private static transient TranslateTransition trn;
    private static transient TranslateTransition trn3;
    private static transient TranslateTransition trn4;

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
    private static transient Multithreading leganimthread;
    public static void moveHero(){

        heromovingflag=false;
        Sticks ob=new Sticks();
        SceneManager obj=new SceneManager(1);
        //SceneManager.ap.getTransforms().add(new Rotate(-ob.getAngleactual()));
        //System.out.println(SceneManager.rec.getX());
        //System.out.println(SceneManager.ap.getLayoutX());
        Button b1 = (Button) PauseMenu.root.lookup("#mainmenu");
        System.out.println(b1);
        //b1.setDisable(true);
        System.out.println("Disabled");

        Rectangle r=(Rectangle) SceneManager.ap.lookup("#hand");
        r.setVisible(true);
        System.out.println("Lifting on y axis");
        trn0=new TranslateTransition(Duration.millis(50),SceneManager.ap);
        trn0.setByY(-5);
        trn0.play();
        trn0.setOnFinished(eve -> {
            System.out.println("Lifting on Y axis finished");
            heromovingflag=true;
            leganimthread=new Multithreading();
            leganimthread.start();
            new Thread(() -> {
                Platform.runLater(() -> {
                    obj.perfectLand();
                });
            }).start();

         trn2=new TranslateTransition(Duration.millis(1500),SceneManager.ap);
        trn2.setToX(SceneManager.rec.getHeight()+SceneManager.rec.getX()-50);
            System.out.println("Moving on pillar");
        trn2.play();
        trn2.setOnFinished(evet -> {
            System.out.println("Moving on pillar finished");

        if(SceneManager.rec.getHeight()+SceneManager.rec.getX()+5<Pillars.getLastpillar().getX()){
            System.out.println("Stick small");
            r.setVisible(false);
            heromovingflag=false;
            b1.setDisable(false);
            //stopRunningAnimation();
            trn=new TranslateTransition(Duration.millis(500),SceneManager.ap);
            System.out.println("Rotating stick");
            ob.fallStick(SceneManager.rec);
            Rotate rotate=new Rotate();
            rotate.setAngle(30);                        //special feature, rotates before falling
            SceneManager.ap.getTransforms().add(rotate);
            System.out.println("Hero rotated before fall");
            trn.setToY(255);
            System.out.println("Falling short");
            trn.play();
            SoundDesign soundobj=new SoundDesign(5);
            new Thread(soundobj).start();
            trn.setOnFinished(event -> {
                System.out.println("Fall short finished");
                SceneManager.setContinueflag(false);
                Buttons.setCanFlip(false);

            });
        } else if (SceneManager.rec.getHeight()+SceneManager.rec.getX()+5>Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()) {
            System.out.println("Stick Big");
            r.setVisible(false);
            heromovingflag=false;
            b1.setDisable(false);
            //stopRunningAnimation();
            trn=new TranslateTransition(Duration.millis(500),SceneManager.ap);
            trn.setToX(SceneManager.rec.getHeight()+SceneManager.rec.getX()+5);
            trn.play();
            trn.setOnFinished(event -> {
                System.out.println("Hero moved before big fall");
                trn3=new TranslateTransition(Duration.millis(1000),SceneManager.ap);
                Rotate rotate=new Rotate();
                rotate.setAngle(30);                        //special feature, rotates before falling
                SceneManager.ap.getTransforms().add(rotate);
                System.out.println("Hero rotated before fall");
                trn3.setToY(255);
                trn3.play();
                SoundDesign soundobj=new SoundDesign(5);
                new Thread(soundobj).start();
                trn3.setOnFinished(event1 -> {
                    System.out.println("Hero fall big");
                    SceneManager.setContinueflag(false);
                    Buttons.setCanFlip(false);

                });
            });

        }
        else{

            System.out.println("Landed on Pillar");
            heromovingflag=true;
            Buttons.setCanFlip(false);
            trn=new TranslateTransition(Duration.millis(50),SceneManager.ap);
            trn.setByX(25);
            trn.play();
            System.out.println("initialising off from stick ");
            trn.setOnFinished(event -> {
                System.out.println("off from stick");
                trn3=new TranslateTransition(Duration.millis(50),SceneManager.ap);
                trn3.setByY(5);
                trn3.play();

                trn3.setOnFinished(event1 -> {
                    System.out.println("Y axis increased");
                   trn4=new TranslateTransition(Duration.millis(500),SceneManager.ap);
                   trn4.setToX(Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()-70);
                   trn4.play();
                    SoundDesign soundObjj=new SoundDesign(3);
                    new Thread(soundObjj).start();
                   trn4.setOnFinished(event2 -> {


                       System.out.println("Got to edge of pillar");
                       b1.setDisable(false);
                       SceneManager.translateAfterLanding();
                       //SceneManager.setTransflag(true);

                       //stopRunningAnimation();
                       OurHero obh=getInstance();
                       obh.setScore(obh.getScore()+1);
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

    public static void increaseScore(OurHero obj){
        obj.setScore(obj.getScore()+1);
    }
    public static void stopThread(){
        leganimthread.interrupt();
    }

    public static void flipHero(){
        if(!flipped) {
            SoundDesign soundObjj=new SoundDesign(7);
            new Thread(soundObjj).start();
            SceneManager.ap.setScaleY(-1);
            SceneManager.ap.setLayoutY(550 + offsetY + 55);
            flipped=true;
        }
        else {
            SoundDesign soundObjj=new SoundDesign(7);
            new Thread(soundObjj).start();
            SceneManager.ap.setScaleY(1);
            SceneManager.ap.setLayoutY(550 + offsetY );
            flipped=false;
        }

    }

    public void stepsOnMines(){
        //gameover;
    }
}
