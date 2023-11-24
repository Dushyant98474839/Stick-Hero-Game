package com.example.stickhero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        RealSceneMangaer sn=new RealSceneMangaer();
        stage=sn.getMainstage();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}