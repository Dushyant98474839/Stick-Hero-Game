package com.example.stickhero;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.css.Style;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import static com.example.stickhero.SceneManager.height;
import static com.example.stickhero.SceneManager.width;
import static javafx.application.Application.launch;

public class Menu {
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


    public Menu() {
        menuScreen();
    }

    private String backgroundrandom;
    public static boolean inceptionFlag=false;
    public static boolean muteFlag=false;
    public void menuScreen() {
        inceptionFlag=false;
//        primaryStage=new Stage();
        root = new AnchorPane();



        backgroundrandom="background"+String.valueOf(((int)(Math.random()*10))+1)+".jpeg";
        System.out.println(backgroundrandom);
        Image image = new Image(backgroundrandom);
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background...)
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

//        Image heroImage=new Image("hero.png");
//        Image stickimage=new Image("stick.png");
//        ImageView  heroText = new ImageView(heroImage);
//        heroText.setFitHeight(125);
//        heroText.setFitWidth(400);
//        heroText.setX(-50);
//        heroText.setY(20);
//
//        ImageView  stickimagetext = new ImageView(stickimage);
//        stickimagetext.setFitWidth(400);
//        stickimagetext.setFitHeight(125);
//        stickimagetext.setX(100);
//        stickimagetext.setY(50);
//
//        root.getChildren().addAll(heroText,stickimagetext);
        //Font.loadFont(getClass().getResourceAsStream("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\vaca.ttf"), 72);
        Text heroText=new Text("HERO");
        heroText.setFont(new Font("Serif",  36));

        heroText.setStyle("-fx-font-family:Grinched; -font-size: 70pt");
        heroText.setFont(new Font(106.0));
        heroText.setLayoutY(125.58203125);
        heroText.setWrappingWidth(310.39111328125);
        heroText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);


        textGroup.getChildren().addAll(stickText,heroText);
        root.getChildren().add(textGroup);

        Group playButtonGroup = new Group();
        playButtonGroup.setLayoutX(236.0);
        playButtonGroup.setLayoutY(402.0);


        Circle playButtonCircle = new Circle(72.0, Color.rgb(255, 82, 125));
        playButtonCircle.setStroke(Color.rgb(181, 81, 107));
        playButtonCircle.setStrokeWidth(0.0);
        playButtonCircle.setLayoutX(70);
//        playButtonCircle.setOpacity(0.75);
        Text playButtonText = new Text("PLAY");
        playButtonText.setFill(Color.WHITE);
        playButtonText.setFont(new Font(45.0));
        playButtonText.setLayoutX(3.0);
        playButtonText.setLayoutY(16.0);
        playButtonText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playButtonText.setWrappingWidth(137.72441864013672);
        playButtonGroup.getChildren().addAll(playButtonCircle, playButtonText);
        root.getChildren().add(playButtonGroup);
        RealSceneMangaer rg=new RealSceneMangaer();
        Rectangle r = new Rectangle();
        r.setArcWidth(20);
        r.setArcHeight(20);
        r.setHeight(200);
        r.setWidth(400);
        r.setY(300);
        r.setX(100);
        r.setStroke(Color.BLACK);
        r.setFill(Color.WHITE);
        Button btn = new Button("Normal");
        btn.setLayoutX(238);
        btn.setLayoutY(325);
        btn.setFont(new Font(32));
        Button btn2 = new Button("Inception");
        btn2.setLayoutX(228);
        btn2.setLayoutY(410);
        btn2.setFont(new Font(32));
        btn2.setStyle(
                "-fx-background-color: black; " +  // Green background color
                        "-fx-text-fill: white; " +          // White text color
                        "-fx-font-size: 26px; " +           // Font size
                        "-fx-padding: 10px 20px; " +         // Padding
                        "-fx-background-radius: 5px; " +    // Rounded corners
                        "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
        );
        btn.setStyle(
                "-fx-background-color: #ff5275; " +  // Green background color
                        "-fx-text-fill: white; " +          // White text color
                        "-fx-font-size: 26px; " +           // Font size
                        "-fx-padding: 10px 20px; " +         // Padding
                        "-fx-background-radius: 5px; " +    // Rounded corners
                        "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
        );

        btn.setOnAction(actionEvent1 -> {
            root.getChildren().removeAll(r, btn,btn2);


            SoundDesign obButton = new SoundDesign(8);
            new Thread(obButton).start();
            RealSceneMangaer rg1 = new RealSceneMangaer();
            rg1 = new RealSceneMangaer();
            try {
                //SceneManager.setToDefault();
                RealSceneMangaer.c = 0;
                rg1.changeScene(1);//IMPLEMENTED USING FACADE Design Pattern
//                primaryStage.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        btn2.setOnAction(actionEvent -> {
            inceptionFlag = true;
            root.getChildren().removeAll(r,btn,btn2);


            SoundDesign obButton = new SoundDesign(8);
            new Thread(obButton).start();
            RealSceneMangaer rg1 = new RealSceneMangaer();
            rg1 = new RealSceneMangaer();
            try {
                //SceneManager.setToDefault();
                RealSceneMangaer.c = 0;

                rg1.changeScene(1);//IMPLEMENTED USING FACADE Design Pattern
//                primaryStage.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        playButtonCircle.setOnMouseClicked(mouseEvent -> {

            root.getChildren().addAll(r, btn,btn2);
        });
        playButtonText.setOnMouseClicked(mouseEvent1 -> {


                    root.getChildren().addAll(r, btn,btn2);


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

        Image imageMute=new Image("speaker.png");
        Image unmute=new Image("mute.png");
        ImageView mute;
        if(muteFlag==false) {
             mute= new ImageView(imageMute);
        }
        else{
            mute = new ImageView(unmute);
        }
        mute.setY(582.5);
        mute.setLayoutX(470);
        mute.setFitHeight(60);
        mute.setFitWidth(60);
        Circle muteCircle = new Circle(34.0, Color.rgb(45, 38, 39, 0.93));
        muteCircle.setLayoutX(497.0);
        muteCircle.setLayoutY(610.0);
        muteCircle.setOpacity(0);

        muteCircle.setOnMouseClicked(mouseEvent -> {
            if(muteFlag==false) {
                muteFlag = true;
                RealSceneMangaer.setMediaPlayer();
                mute.setImage(unmute);
            }
            else {
                muteFlag=false;
                RealSceneMangaer.setMediaPlayer(1);
                mute.setImage(imageMute);
            }
        });







//        Rectangle statsRectangle1 = new Rectangle(28.0, -91.0, 12.0, 49.0);
//        statsRectangle1.setFill(Color.WHITE);
//        statsRectangle1.setStroke(Color.BLACK);
//        //statsRectangle1.setStrokeType(Rectangle.StrokeType.INSIDE);
//
//        Rectangle statsRectangle2 = new Rectangle(41.0, -64.0, 12.0, 22.0);
//        statsRectangle2.setFill(Color.WHITE);
//        statsRectangle2.setStroke(Color.BLACK);
//        //statsRectangle2.setStrokeType(Rectangle.StrokeType.INSIDE);
//
//        Rectangle statsRectangle3 = new Rectangle(15.0, -76.0, 12.0, 34.0);
//        statsRectangle3.setFill(Color.WHITE);
//        statsRectangle3.setStroke(Color.BLACK);
//        //statsRectangle3.setStrokeType(Rectangle.StrokeType.INSIDE);

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
        load.setOnMouseClicked(mouseEvent -> {
            SoundDesign obButton=new SoundDesign(8);
            Thread th1=new Thread(obButton);
            th1.start();
            ObjectInputStream in = null;
            OurHero s1;
            try {
                in = new ObjectInputStream (
                        new FileInputStream("out.txt"));
                s1 = (OurHero) in.readObject();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            OurHero.setHero(s1);

            RealSceneMangaer.loadFlag=true;
            try {
                SceneManager.setGameLoop();

                rg.changeScene(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        saveCircle.setOnMouseClicked(mouseEvent -> {
            SoundDesign obButton=new SoundDesign(8);
            new Thread(obButton).start();
            ObjectInputStream in = null;
            OurHero s1;
            try {
                in = new ObjectInputStream (
                        new FileInputStream("out.txt"));
                s1 = (OurHero) in.readObject();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            OurHero.setHero(s1);

            RealSceneMangaer.loadFlag=true;
            try {
                SceneManager.setGameLoop();

                rg.changeScene(1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        Circle exitCircle = new Circle(34.0, Color.rgb(60, 48, 50, 0.93));
        exitCircle.setStroke(Color.rgb(181, 81, 107));
        exitCircle.setStrokeWidth(0.0);
        exitCircle.setLayoutX(32.5);
        exitCircle.setLayoutY(50.0);
        exitCircle.setOnMouseClicked(mouseEvent -> {
            SoundDesign obButton=new SoundDesign(8);
            new Thread(obButton).start();
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
            SoundDesign obButton=new SoundDesign(8);
            new Thread(obButton).start();
            HelloApplication.close();
        });

        statsGroup.getChildren().addAll(statsCircle, saveCircle,load,exitCircle,exitload);
        root.getChildren().addAll(statsGroup,mute);
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

        root.getChildren().add(muteCircle);

        scene=new Scene(root,600,800);
    }
}