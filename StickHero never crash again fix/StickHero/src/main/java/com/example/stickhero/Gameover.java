package com.example.stickhero;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static com.example.stickhero.SceneManager.height;
import static com.example.stickhero.SceneManager.width;

public class Gameover {
    public Gameover(String s) {
        gameover(s);
    }

    //private static Stage primaryStage;
    private static Scene scene;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Gameover.scene = scene;
    }

    private static boolean reviveFlag=false;

    public static boolean isReviveFlag() {
        return reviveFlag;
    }

    public static void setReviveFlag(boolean reviveFlag) {
        Gameover.reviveFlag = reviveFlag;
    }

//    public static Stage getPrimaryStage() {
//        return primaryStage;
//    }
//
//    public static void setPrimaryStage(Stage primaryStage) {
//        Gameover.primaryStage = primaryStage;
//    }

    public void gameover(String s) {
//        primaryStage=new Stage();
//        primaryStage.setResizable(false);
        AnchorPane root = new AnchorPane();


        // Background Image
        Image image = new Image(s);
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);
        root.setBackground(background);

        // Other Images with Glow or DropShadow effects
        ImageView deadImageView = createImageView("dead.png", 245.0, 492.0, 100.0, 106.0, 45.0, new Glow());

        ImageView restartImageView = createImageView("restart.png", 73.0, 331.0, 90.0, 90.0, 0.0, new DropShadow());

        ImageView reviveImageView = createImageView("revive.png", 240.0, 312.0, 121.0, 124.0, -10.0, new DropShadow());

        ImageView homeImageView = createImageView("home.png", 438.0, 330.0, 80.0, 80.0, 0.0, new DropShadow());

        ImageView cherryImageView = createImageView("cherry.png", 10.0, 10.0, 60.0, 55.0, 0.0, new Glow());
        Rectangle restartrect=new Rectangle(73,331,90,90);
        restartrect.setFill(Color.BLACK);
        restartrect.setOpacity(0);
        Rectangle mainrect=new Rectangle(428,330,80,80);
        mainrect.setOpacity(0);
        Rectangle reviverect=new Rectangle(220,292,151,154);
        reviverect.setOpacity(0);

        Text cherrycount = createText(": "+OurHero.getCherrycount(), 60.0, 50.0, 30.0, new Glow(0));
        cherrycount.setFill(Color.WHITE);

        RotateTransition rt = new RotateTransition(Duration.seconds(2.5), reviveImageView);
        rt.setByAngle(20);
        rt.setAutoReverse(true);
        rt.setCycleCount(rt.INDEFINITE);
        rt.play();
//        restartrect.setOnMouseEntered(event->{
//            scene.setCursor(Cursor.HAND);
//        });
//        restartrect.setOnMouseExited(event->{
//            scene.setCursor(Cursor.NONE);
//        });
        restartrect.setOnMouseClicked(mouseEvent -> {
            RealSceneMangaer rg=new RealSceneMangaer();
            try {
                SceneManager.setToDefault();
                //SceneManager.setTransflag(false);
                rg.switchToGame();
                //primaryStage.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        mainrect.setOnMouseClicked(mouseEvent -> {
            RealSceneMangaer rg=new RealSceneMangaer();
            try {
                SceneManager.setToDefault();
                //SceneManager.setTransflag(false);
                rg.switchToMainMenu();
                //primaryStage.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        reviverect.setOnMouseClicked(mouseEvent -> {
            Rectangle r=new Rectangle();
            r.setArcWidth(20);
            r.setArcHeight(20);
            r.setHeight(200);
            r.setWidth(400);
            r.setY(300);
            r.setX(100);
            r.setStroke(Color.BLACK);
            r.setFill(Color.WHITE);
            Text t=new Text("Revive with 3 cherries\nTotal Cherries: "+OurHero.getCherrycount());
            t.setFill(Color.BLACK);
            t.setY(350);
            t.setX(150);
            t.setTextAlignment(TextAlignment.CENTER);
            t.setFont(new Font(30));

            Button revive=new Button();
            revive.setText("Revive");
            Button cancel=new Button();
            cancel.setText("Cancel");

            revive.setLayoutX(180);
            revive.setLayoutY(435);
            revive.setPrefHeight(40);
            revive.setPrefWidth(90);
            cancel.setLayoutX(320);
            cancel.setLayoutY(435);
            cancel.setPrefHeight(40);
            cancel.setPrefWidth(90);
            revive.setStyle(
                    "-fx-background-color: #ff5275; " +  // Green background color
                            "-fx-text-fill: white; " +          // White text color
                            "-fx-font-size: 16px; " +           // Font size
                            "-fx-padding: 10px 20px; " +         // Padding
                            "-fx-background-radius: 5px; " +    // Rounded corners
                            "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
            );
            cancel.setStyle(
                    "-fx-background-color: #ff5275; " +  // Green background color
                            "-fx-text-fill: white; " +          // White text color
                            "-fx-font-size: 16px; " +           // Font size
                            "-fx-padding: 10px 20px; " +         // Padding
                            "-fx-background-radius: 5px; " +    // Rounded corners
                            "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
            );

            revive.setFont(new Font(20));
            cancel.setFont(new Font(20));

            root.getChildren().addAll(r,t,revive,cancel);
            cancel.setOnMouseClicked(mouseEvent1 -> {
                root.getChildren().removeAll(r,t,revive,cancel);
            });
            revive.setOnMouseClicked(mouseEvent1 -> {
                if(OurHero.getCherrycount()>=3){
                    try {
                        SceneManager.setToDefault();
                        OurHero.setCherrycount(OurHero.getCherrycount()-3);
                        RealSceneMangaer rg=new RealSceneMangaer();
                        //SceneManager.setTransflag(false);
                        //SceneManager sn=new SceneManager();
                        reviveFlag=true;
                        rg.switchToGame();
                        //primaryStage.close();


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
                else{
                    System.out.println("Cherryless");
                    Rectangle r2=new Rectangle();
                    r2.setArcWidth(20);
                    r2.setArcHeight(20);
                    r2.setHeight(200);
                    r2.setWidth(400);
                    r2.setY(300);
                    r2.setX(100);
                    r2.setStroke(Color.BLACK);
                    r2.setFill(Color.WHITE);
                    r2.toFront();
                    Text t2=new Text("Insufficient Cherries!");
                    t2.setFill(Color.BLACK);
                    t2.setY(350);
                    t2.setX(160);
                    t2.toFront();
                    t2.setTextAlignment(TextAlignment.CENTER);
                    t2.setFont(new Font(30));
                    Button buy=new Button();
                    buy.setStyle(
                            "-fx-background-color: #ff5275; " +  // Green background color
                                    "-fx-text-fill: white; " +          // White text color
                                    "-fx-font-size: 16px; " +           // Font size
                                    "-fx-padding: 10px 20px; " +         // Padding
                                    "-fx-background-radius: 5px; " +    // Rounded corners
                                    "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
                    );

                    buy.setText("Buy");
                    buy.setLayoutX(180);
                    buy.setLayoutY(435);
                    buy.setPrefHeight(40);
                    buy.setPrefWidth(90);
                    buy.setFont(new Font(20));

                    Button goback=new Button();
                    goback.setText("Back");
                    goback.setLayoutX(320);
                    goback.setLayoutY(435);
                    goback.setPrefHeight(40);
                    goback.setPrefWidth(90);
                    goback.setFont(new Font(20));
                    goback.setStyle(
                            "-fx-background-color: #ff5275; " +  // Green background color
                                    "-fx-text-fill: white; " +          // White text color
                                    "-fx-font-size: 16px; " +           // Font size
                                    "-fx-padding: 10px 20px; " +         // Padding
                                    "-fx-background-radius: 5px; " +    // Rounded corners
                                    "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
                    );
                    goback.setOnMouseClicked(mouseEvent2 -> {
                        root.getChildren().removeAll(r2,t2,buy,goback);
                    });
                    root.getChildren().addAll(r2,t2,buy,goback);
                    buy.setOnMouseClicked(mouseEvent3 ->{
                        Rectangle r3=new Rectangle();
                        r3.setArcWidth(20);
                        r3.setArcHeight(20);
                        r3.setHeight(475);
                        r3.setWidth(400);
                        r3.setY(300);
                        r3.setX(100);
                        r3.setStroke(Color.BLACK);
                        r3.setFill(Color.WHITE);
                        r3.toFront();
                        Text t3=new Text("Scan And Pay!");
                        t3.setFill(Color.BLACK);
                        t3.setY(350);
                        t3.setX(200);
                        t3.toFront();
                        t3.setTextAlignment(TextAlignment.CENTER);
                        t3.setFont(new Font(30));
                        Button cancel2=new Button();
                        cancel2.setText("Back");
                        cancel2.setLayoutX(250);
                        cancel2.setLayoutY(715);
                        cancel2.setPrefHeight(40);
                        cancel2.setPrefWidth(90);
                        cancel2.setFont(new Font(20));
                        cancel2.setStyle(
                                "-fx-background-color: #ff5275; " +  // Green background color
                                        "-fx-text-fill: white; " +          // White text color
                                        "-fx-font-size: 16px; " +           // Font size
                                        "-fx-padding: 10px 20px; " +         // Padding
                                        "-fx-background-radius: 5px; " +    // Rounded corners
                                        "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
                        );
                        ImageView qr = createImageView("qr.jpg", 135.0, 375.0, 330.0, 325.0, 0.0, new Glow());
                        root.getChildren().addAll(r3,t3,qr,cancel2);
                        cancel2.setOnMouseClicked(mo2->{
                            root.getChildren().removeAll(qr,t3,r3,cancel2);
                        });
                    } );

//                    try {
//                        // Sleep for 2 seconds (2000 milliseconds)
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        // Handle the exception if the sleep is interrupted
//                        e.printStackTrace();
////                    }
//                    root.getChildren().removeAll(r2,t2);
                }
            });

        });
        TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(1.75), deadImageView);
        translateTransition2.setByY(100);
        translateTransition2.setAutoReverse(false);
        translateTransition2.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition2.play();
        Text bestScoreText = createText("Best Score", 220.0, 56.0, 35.0, new Glow());

        Text yourScoreText = createText("Your Score", 220.0, 191.0, 35.0, new Glow());
        bestScoreText.setFill(Color.WHITE);
        yourScoreText.setFill(Color.WHITE);

        // Rectangles with DropShadow effects
        Rectangle r=new Rectangle();
        r.setArcHeight(20);
        r.setArcWidth(20);
        r.setOpacity(0.35);
        r.setFill(Color.BLACK);
        r.setHeight(106);
        r.setWidth(191);
        r.setLayoutX(205);
        r.setLayoutY(18);
        Rectangle yr=new Rectangle();
        yr.setArcHeight(20);
        yr.setArcWidth(20);
        yr.setOpacity(0.35);
        yr.setFill(Color.BLACK);
        yr.setHeight(108);
        yr.setWidth(191);
        yr.setLayoutX(205);
        yr.setLayoutY(153);
        Text yourScore=createText(Integer.toString(OurHero.getScore()),290,247.5,40,new Glow());
        yourScore.setFill(Color.WHITE);

        root.getChildren().addAll(r,yr,
                deadImageView, restartImageView, reviveImageView, homeImageView,
                bestScoreText, yourScoreText,  yourScore,restartrect,reviverect,mainrect
        );
        Rectangle rec=new Rectangle(10,17.5,100,45);
        rec.setOpacity(0.35);
        rec.setArcWidth(20);
        rec.setArcHeight(20);
        scene = new Scene(root, 600, 800);

        root.getChildren().addAll(rec,cherryImageView, cherrycount);

//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    private ImageView createImageView(String imageUrl, double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect) {
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setLayoutX(layoutX);
        imageView.setLayoutY(layoutY);
        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);
        imageView.setRotate(rotate);
        imageView.setEffect(effect);
        return imageView;
    }

    private Text createText(String text, double layoutX, double layoutY, double fontSize, javafx.scene.effect.Effect effect) {
        Text textNode = new Text(text);
        textNode.setLayoutX(layoutX);
        textNode.setLayoutY(layoutY);
        textNode.setFont(new Font(fontSize));
        textNode.setEffect(effect);
        return textNode;
    }

    private Rectangle createRectangle(double layoutX, double layoutY, double width, double height, javafx.scene.effect.Effect effect, double opacity) {
        Rectangle rectangle = new Rectangle(layoutX, layoutY, width, height);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        //rectangle.setStrokeType(Rectangle.StrokeType.INSIDE);
        rectangle.setEffect(effect);
        rectangle.setOpacity(opacity);
        return rectangle;
    }

}