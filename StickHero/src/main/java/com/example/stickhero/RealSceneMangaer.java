package com.example.stickhero;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class RealSceneMangaer {
    //private Stage mainstage;
    private Scene scene;
    public static int c=0;
    public static boolean loadFlag=false;
    private static SoundDesign objb;
    private Thread t1=null;
    private static MediaPlayer mediaPlayer;

    public static void setMediaPlayer() {
        mediaPlayer.stop();
    }
    public static void setMediaPlayer(int i) {
        mediaPlayer.play();
    }

    public RealSceneMangaer(int i){
        Menu mn=new Menu();
//        SoundDesign objb=new SoundDesign(12);
//        new Thread(objb).start();
        Media media = new Media(new File("src\\main\\resources\\SoundDesign\\music.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
//        objb=new SoundDesign(10);
//        if(t1==null) {
//            t1 = new Thread(objb);
//            t1.start();
//        }
        HelloApplication.setMainStage(mn.getScene());
    }

    public RealSceneMangaer(){

    }


    //Design Pattern : FACADE IMPLEMENTATION
    public void changeScene(int ch) throws IOException {
        switch (ch){
            case 1:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                }
                Media media;
                if(Menu.inceptionFlag){
                    objb=new SoundDesign(12);
                    media = new Media(new File("src\\main\\resources\\SoundDesign\\Time.mp3").toURI().toString());
                }
                else {
                    objb=new SoundDesign(10);
                    media = new Media(new File("src\\main\\resources\\SoundDesign\\music.mp3").toURI().toString());
                }
//                t1 = new Thread(objb);
//                t1.start();

                mediaPlayer = new MediaPlayer(media);
                if(!Menu.muteFlag)
                mediaPlayer.play();
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                switchToGame();
                break;
            case 2:
                if(mediaPlayer!=null){
                    mediaPlayer.stop();
                }

                if(Menu.inceptionFlag){
                    objb=new SoundDesign(10);
                    media = new Media(new File("src\\main\\resources\\SoundDesign\\Time.mp3").toURI().toString());
                }
                else {
                    objb=new SoundDesign(10);
                    media = new Media(new File("src\\main\\resources\\SoundDesign\\music.mp3").toURI().toString());
                }

//                t1 = new Thread(objb);
//                t1.start();
                mediaPlayer = new MediaPlayer(media);
                if(!Menu.muteFlag)
                mediaPlayer.play();
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                switchToMainMenu();
                break;
            case 3:
//                if(mediaPlayer!=null){
//                    mediaPlayer.stop();
//                }
//                if(Menu.inceptionFlag){
//                    objb=new SoundDesign(12);
//                    media = new Media(new File("src\\main\\resources\\SoundDesign\\Time.mp3").toURI().toString());
//                }
//                else {
//                    objb=new SoundDesign(10);
//                    media = new Media(new File("src\\main\\resources\\SoundDesign\\music.mp3").toURI().toString());
//                }
//
////                t1 = new Thread(objb);
////                t1.start();
//                mediaPlayer = new MediaPlayer(media);
//                mediaPlayer.play();
                switchToGameover(SceneManager.getBackgroundrandom());
                break;
            default:;

        }
    }


    public void switchToGame() throws IOException {
        if(c!=0) {
            SceneManager.setToDefault();
            c=1;
        }

        if(Gameover.isReviveFlag()){
            SceneManager mn = new SceneManager();
            SceneManager.setTransflag(false);
            Gameover.setReviveFlag(false);
            HelloApplication.setMainStage(mn.getMainscene());
        }
        else if(loadFlag){
            loadFlag=false;
            SceneManager mn = new SceneManager();
            SceneManager.setTransflag(false);
            HelloApplication.setMainStage(mn.getMainscene());

        }
        else {
            //OurHero.setCherrycount(0);
            OurHero ob=OurHero.getInstance();
            ob.setScore(0);
            SceneManager mn = new SceneManager();
            SceneManager.setTransflag(false);
            HelloApplication.setMainStage(mn.getMainscene());
        }
    }
    public void switchToGameover(String s) throws IOException {
        Gameover mn=new Gameover(s);
        HelloApplication.setMainStage(Gameover.getScene());
    }
    public void switchToMainMenu() throws IOException {
        Menu mn=new Menu();
        scene=mn.getScene();
        HelloApplication.setMainStage(scene);
    }


//    public void switchToPauseMenu() throws IOException {
//        PauseMenu mn=new PauseMenu();
//        scene= PauseMenu.getScene();
////        mainstage=mn.getPrimaryStage();
////        mainstage.show();
//        HelloApplication.setMainStage(scene);
//    }

}