package com.example.stickhero;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RealSceneMangaer {
    //private Stage mainstage;
    private Scene scene;
    public static int c=0;
//    public Stage getMainstage() {
//        return mainstage;
//    }
//
//    public void setMainstage(Stage mainstage) {
//        this.mainstage = mainstage;
//    }
    public RealSceneMangaer(int i){
        Menu mn=new Menu();
        HelloApplication.setMainStage(mn.getScene());
    }
    public RealSceneMangaer(){
        //        mainstage.setTitle("Stick Hero");
//        Image icon=new Image("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\Logo.png");
//        mainstage.getIcons().add(icon);
//        mainstage.setResizable(false);

    }

    public void switchToGame() throws IOException {
        if(c!=0) {
            SceneManager.setToDefault();
            c=1;
        }

        if(Gameover.isReviveFlag()){
            SceneManager mn = new SceneManager();
            SceneManager.setTransflag(false);
            //mainstage = mn.getStage();
            //mainstage.show();
            Gameover.setReviveFlag(false);
            HelloApplication.setMainStage(mn.getMainscene());
        }
        else {
            //OurHero.setCherrycount(0);
            OurHero.setScore(0);
            SceneManager mn = new SceneManager();
            SceneManager.setTransflag(false);
//            mainstage = mn.getStage();
//            mainstage.show();
            HelloApplication.setMainStage(mn.getMainscene());
        }
    }
    public void switchToGameover(String s) throws IOException {
        Gameover mn=new Gameover(s);
//        mainstage=mn.getPrimaryStage();
//        mainstage.show();
        HelloApplication.setMainStage(Gameover.getScene());
    }
    public void switchToMainMenu() throws IOException {
        Menu mn=new Menu();
        scene=mn.getScene();
//        mainstage=mn.getPrimaryStage();
//        mainstage.show();
        HelloApplication.setMainStage(scene);
    }

    public void switchToPauseMenu() throws IOException {
        PauseMenu mn=new PauseMenu();
        scene= PauseMenu.getScene();
//        mainstage=mn.getPrimaryStage();
//        mainstage.show();
        HelloApplication.setMainStage(scene);
    }
}