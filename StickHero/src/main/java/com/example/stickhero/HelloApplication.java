package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage mainStage;

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Scene scene) {
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