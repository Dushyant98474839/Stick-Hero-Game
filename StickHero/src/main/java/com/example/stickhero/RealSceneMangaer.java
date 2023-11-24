package com.example.stickhero;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class RealSceneMangaer {
    private Stage mainstage;
    private static int c=0;
    public Stage getMainstage() {
        return mainstage;
    }

    public void setMainstage(Stage mainstage) {
        this.mainstage = mainstage;
    }

    public RealSceneMangaer(){
        Menu mn=new Menu();
        mainstage=mn.getPrimaryStage();
        mainstage.setTitle("Stick Hero");
        Image icon=new Image("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\Logo.png");
        mainstage.getIcons().add(icon);
    }

    public void switchToGame() throws IOException {
        if(c!=0) {
            SceneManager.setToDefault();
            c=1;
        }

        Pillars.setLastpillar(null);
        if(Gameover.isReviveFlag()){
            SceneManager mn = new SceneManager();
            SceneManager.setTransflag(false);
            mainstage = mn.getStage();
            mainstage.show();
            Gameover.setReviveFlag(false);
        }
        else {
            //OurHero.setCherrycount(0);
            OurHero.setScore(0);
            SceneManager mn = new SceneManager();
            SceneManager.setTransflag(false);
            mainstage = mn.getStage();
            mainstage.show();
        }
    }
    public void switchToGameover() throws IOException {
        Gameover mn=new Gameover();
        mainstage=mn.getPrimaryStage();
        mainstage.show();
    }
    public void switchToMainMenu() throws IOException {
        Menu mn=new Menu();
        mainstage=mn.getPrimaryStage();
        mainstage.show();
    }
}
