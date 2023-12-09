package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage mainStage;

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Scene scene) {
        Image customCursorImage = new Image("customCursor.png");
        Cursor customCursor = new ImageCursor(customCursorImage);
//        Button b1 = (Button) NewGame.scene.lookup("#button");
//        ImageView i1 = (ImageView) NewGame.scene.lookup("#pauseImage");

//        b1.setCursor(customCursor);
        scene.setCursor(customCursor);

        HelloApplication.mainStage.setScene(scene);
    }

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        mainStage=stage;
        mainStage.setTitle("Stick Hero");
        Image icon=new Image("Logo.png");
        mainStage.getIcons().add(icon);
        mainStage.setResizable(false);

        RealSceneMangaer sn=new RealSceneMangaer(1);

        //mainStage=sn.getMainstage();

        mainStage.show();


    }
    public static void close(){
        mainStage.close();
    }

    public static void main(String[] args) {
        launch();
    }
}