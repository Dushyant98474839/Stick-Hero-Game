package com.example.stickhero;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static com.example.stickhero.SceneManager.height;
import static com.example.stickhero.SceneManager.width;
import static javafx.application.Application.launch;

public class Menu {
//    private static Stage primaryStage;
    private static AnchorPane root;
    private static Scene scene;

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        Menu.scene = scene;
    }

    public static AnchorPane getRoot() {
        return root;
    }

    public static void setRoot(AnchorPane root) {
        Menu.root = root;
    }

//    public static void setPrimaryStage(Stage primaryStage) {
//        Menu.primaryStage = primaryStage;
//    }
//
//    public static Stage getPrimaryStage() {
//        return primaryStage;
//    }

    public Menu() {
        menuScreen();
    }


    public void menuScreen() {
//        primaryStage=new Stage();
        root = new AnchorPane();

        Image image = new Image("/background.png");
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        Rectangle rectangle = new Rectangle(130.0, 388.0);
        rectangle.setLayoutX(243.0);
        rectangle.setLayoutY(612.0);
        rectangle.setArcWidth(5.0);
        rectangle.setArcHeight(5.0);
        rectangle.setStroke(Color.BLACK);
        //rectangle.setStrokeType(Rectangle.StrokeType.INSIDE);
        rectangle.setStrokeWidth(0.0);
        root.getChildren().add(rectangle);

        AnchorPane outerAnchorPane = new AnchorPane();
        outerAnchorPane.setLayoutX(250.0);
        outerAnchorPane.setLayoutY(557.0);
        outerAnchorPane.setPrefWidth(55.0);
        outerAnchorPane.setPrefHeight(56.0);

        Group group = new Group();
        group.setLayoutX(-25.0);
        group.setLayoutY(-26.0);
        group.setScaleX(0.5);
        group.setScaleY(0.5);
        group.setScaleZ(0.5);

        Rectangle rectanglee = new Rectangle(36.000020027160645, 26.333328247070312, 69.0, 97.0);
        rectanglee.setArcWidth(17.0);
        rectanglee.setArcHeight(17.0);
        rectanglee.setStroke(Color.BLACK);
        rectanglee.setLayoutY(-25);
        //rectanglee.setStrokeType(Rectangle.StrokeType.INSIDE);

        Circle circle = new Circle(86.00002002716064, 31.0, 12.0, Color.WHITE);
        circle.setStroke(Color.BLACK);
        //circle.setStrokeType(Circle.StrokeType.INSIDE);

        Rectangle redRectangle = new Rectangle(32.000020027160645, 10.0, 76.0, 18.0);
        redRectangle.setArcWidth(5.0);
        redRectangle.setArcHeight(5.0);
        redRectangle.setFill(Color.rgb(255, 31, 31));
        redRectangle.setStroke(Color.RED);
        //redRectangle.setStrokeType(Rectangle.StrokeType.INSIDE);

        Polygon polygon1 = new Polygon(
                13.999979972839355, 39.99998474121094,
                50.0, 40.0,
                39.333335876464844, 26.333328247070312
        );
        polygon1.setFill(Color.rgb(255, 31, 31));
        polygon1.setStroke(Color.BLACK);
        polygon1.setLayoutX(-15);
        polygon1.setLayoutY(-20);
        polygon1.setStrokeWidth(0);
        //polygon1.setStrokeType(Polygon.StrokeType.INSIDE);

        Polygon polygon2 = new Polygon(
                28.666648864746094, 52.00001525878906,
                50.0, 40.0,
                42.666648864746094, 52.00001525878906
        );
        polygon2.setFill(Color.rgb(255, 31, 31));
        polygon2.setStroke(Color.BLACK);
        polygon2.setLayoutX(-15);
        polygon2.setLayoutY(-20);
        polygon2.setStrokeWidth(0);
        //polygon2.setStrokeType(Polygon.StrokeType.INSIDE);

        Rectangle rectangle1 = new Rectangle(40.000020027160645, 91.0, 12.0, 18.0);
        rectangle1.setArcWidth(15.0);
        rectangle1.setArcHeight(15.0);
        rectangle1.setStroke(Color.BLACK);
        //rectangle1.setStrokeType(Rectangle.StrokeType.INSIDE);

        Rectangle rectangle2 = new Rectangle(88.00002002716064, 91.0, 12.0, 18.0);
        rectangle2.setArcWidth(15.0);
        rectangle2.setArcHeight(15.0);
        rectangle2.setStroke(Color.BLACK);
        //rectangle2.setStrokeType(Rectangle.StrokeType.INSIDE);

        group.getChildren().addAll(rectanglee, circle, redRectangle, polygon1, polygon2, rectangle1, rectangle2);
        outerAnchorPane.getChildren().add(group);
        root.getChildren().add(outerAnchorPane);


        Group textGroup = new Group();
        textGroup.setLayoutX(153.0);
        textGroup.setLayoutY(142.0);
        Text stickText = new Text("STICK");
        Font f1=Font.loadFont("vaca.ttf",72);

        //stickText.setFont(Font.font("GrinchedRegular"));
        stickText.setFont(new Font(String.valueOf(f1),102));
        //stickText.setStyle("-fx-font-family:; -fx-font-size: 76pt");
        stickText.setWrappingWidth(310.39111328125);
        stickText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);


        Text heroText = new Text("HERO");
        //Font.loadFont(getClass().getResourceAsStream("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\vaca.ttf"), 72);
        //heroText.setFont(new Font("Serif",  36));

        //heroText.setStyle("-fx-font-family:Grinched; -font-size: 70pt");
        heroText.setFont(new Font(106.0));
        heroText.setLayoutY(125.58203125);
        heroText.setWrappingWidth(310.39111328125);
        heroText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        textGroup.getChildren().addAll(stickText, heroText);
        root.getChildren().add(textGroup);

        Group playButtonGroup = new Group();
        playButtonGroup.setLayoutX(236.0);
        playButtonGroup.setLayoutY(402.0);


        Circle playButtonCircle = new Circle(72.0, Color.rgb(255, 82, 125));
        playButtonCircle.setStroke(Color.rgb(181, 81, 107));
        playButtonCircle.setStrokeWidth(0.0);
        playButtonCircle.setLayoutX(70);
        Text playButtonText = new Text("PLAY");
        playButtonText.setFill(Color.WHITE);
        playButtonText.setFont(new Font(45.0));
        playButtonText.setLayoutX(3.0);
        playButtonText.setLayoutY(16.0);
        playButtonText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playButtonText.setWrappingWidth(137.72441864013672);
        playButtonGroup.getChildren().addAll(playButtonCircle, playButtonText);
        root.getChildren().add(playButtonGroup);
        playButtonCircle.setOnMouseClicked(mouseEvent -> {
            RealSceneMangaer rg=new RealSceneMangaer();
            try {
                //SceneManager.setToDefault();
                RealSceneMangaer.c=0;
                rg.switchToGame();
//                primaryStage.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        playButtonText.setOnMouseClicked(mouseEvent -> {
            RealSceneMangaer rg=new RealSceneMangaer();
            try {
                //SceneManager.setToDefault();
                RealSceneMangaer.c=0;
                rg.switchToGame();
//                primaryStage.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        Group helpGroup = new Group();
        helpGroup.setLayoutX(-6.0);
        helpGroup.setLayoutY(706.0);

        Circle helpCircle = new Circle(34.0, Color.rgb(60, 48, 50, 0.93));
        helpCircle.setStroke(Color.rgb(181, 81, 107));
        helpCircle.setStrokeWidth(0.0);
        helpCircle.setLayoutX(119.0);
        helpCircle.setLayoutY(-98.0);

        Text helpText = new Text("?");
        helpText.setFill(Color.WHITE);
        helpText.setFont(new Font(45.0));
        helpText.setLayoutX(83.0);
        helpText.setLayoutY(-84.0);
        helpText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        helpText.setWrappingWidth(75.72442245483398);

        helpGroup.getChildren().addAll(helpCircle, helpText);
        root.getChildren().add(helpGroup);

        Group statsGroup = new Group();
        statsGroup.setLayoutX(463.0);
        statsGroup.setLayoutY(678.0);

        Circle statsCircle = new Circle(34.0, Color.rgb(45, 38, 39, 0.93));
        statsCircle.setLayoutX(34.0);
        statsCircle.setLayoutY(-66.0);
        statsCircle.setStroke(Color.rgb(181, 81, 107));
        statsCircle.setStrokeWidth(0.0);

        Rectangle statsRectangle1 = new Rectangle(28.0, -91.0, 12.0, 49.0);
        statsRectangle1.setFill(Color.WHITE);
        statsRectangle1.setStroke(Color.BLACK);
        //statsRectangle1.setStrokeType(Rectangle.StrokeType.INSIDE);

        Rectangle statsRectangle2 = new Rectangle(41.0, -64.0, 12.0, 22.0);
        statsRectangle2.setFill(Color.WHITE);
        statsRectangle2.setStroke(Color.BLACK);
        //statsRectangle2.setStrokeType(Rectangle.StrokeType.INSIDE);

        Rectangle statsRectangle3 = new Rectangle(15.0, -76.0, 12.0, 34.0);
        statsRectangle3.setFill(Color.WHITE);
        statsRectangle3.setStroke(Color.BLACK);
        //statsRectangle3.setStrokeType(Rectangle.StrokeType.INSIDE);

        Circle saveCircle = new Circle(34.0, Color.rgb(60, 48, 50, 0.93));
        saveCircle.setStroke(Color.rgb(181, 81, 107));
        saveCircle.setStrokeWidth(0.0);
        saveCircle.setLayoutX(-352.5);
        saveCircle.setLayoutY(50.0);
        Text load = new Text("LOAD");
        load.setFill(Color.WHITE);
        load.setFont(new Font(15.0));
        load.setLayoutX(-390);
        load.setLayoutY(55.0);
        load.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        load.setWrappingWidth(75.72442245483398);

        Circle exitCircle = new Circle(34.0, Color.rgb(60, 48, 50, 0.93));
        exitCircle.setStroke(Color.rgb(181, 81, 107));
        exitCircle.setStrokeWidth(0.0);
        exitCircle.setLayoutX(32.5);
        exitCircle.setLayoutY(50.0);
        exitCircle.setOnMouseClicked(mouseEvent -> {
            HelloApplication.close();
        });

        Text exitload = new Text("EXIT");
        exitload.setFill(Color.WHITE);
        exitload.setFont(new Font(17.0));
        exitload.setLayoutX(-7);
        exitload.setLayoutY(55.0);
        exitload.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        exitload.setWrappingWidth(75.72442245483398);
        exitload.setOnMouseClicked(mouseEvent -> {
            HelloApplication.close();
        });

        statsGroup.getChildren().addAll(statsCircle, statsRectangle1, statsRectangle2, statsRectangle3,saveCircle,load,exitCircle,exitload);
        root.getChildren().add(statsGroup);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), playButtonGroup);
        translateTransition.setByY(30);
        translateTransition.setAutoReverse(true);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.play();

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), outerAnchorPane);
        translateTransition2.setByX(40);
        translateTransition2.setAutoReverse(true);
        translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition2.play();
        scene=new Scene(root,600,800);
    }
}