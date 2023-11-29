package com.example.stickhero;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

import static com.example.stickhero.SceneManager.*;

public class PauseMenu {

    //private static Stage primaryStage;

//    public static Stage getPrimaryStage() {
//        return primaryStage;
//    }
//
//    public static void setPrimaryStage(Stage primaryStage) {
//        PauseMenu.primaryStage = primaryStage;
//    }
    private static Scene scene;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        PauseMenu.scene = scene;
    }

    public PauseMenu() {
        pauseMenu();
    }
    public PauseMenu(String s){
        Image image = new Image(s);
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);

        root.setBackground(background);
    }
    public static AnchorPane root=null;

    static Text cherrycount;
    String backgroundImage;

    public void pauseMenu() {
         root = new AnchorPane();
        root.setOpacity(10);
        Image image = new Image("background.png");
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);

        root.setBackground(background);

        Rectangle rsc=new Rectangle(200,145.5,200,65);
        rsc.setOpacity(0.35);
        rsc.setArcWidth(20);
        rsc.setArcHeight(20);
        root.getChildren().add(rsc);

        Rectangle rec=new Rectangle();
        rec.setHeight(800);
        rec.setWidth(600);
        rec.setFill(Color.WHITE);
        rec.setOpacity(0);
        root.getChildren().add(rec);
        Rectangle rc=new Rectangle(10,17.5,100,45);
        rc.setOpacity(0.35);
        rc.setArcWidth(20);
        rc.setArcHeight(20);
        root.getChildren().add(rc);

        Polygon arrow = new Polygon();
        arrow.setLayoutX(300.0);
        arrow.setLayoutY(342.0);
        arrow.getPoints().addAll(-49.66664123535156, 0.999969482421875, 54.9919738769531, 0.29170608520508, -0.009027862548828, -42.12510299682617);

        arrow.setRotate(90.0);
        arrow.setFill(Color.valueOf("#ff5275"));
        arrow.setStroke(Color.BLACK);
        arrow.setStrokeWidth(0);
        arrow.setStroke(Color.WHITE);
        arrow.setStrokeWidth(1);
        arrow.setOnMouseClicked(mouseEvent -> {


            SceneManager.removePauseMenu();
        });
        //arrow.setStrokeType(Polygon.StrokeType.INSIDE);

        DropShadow arrowShadow = new DropShadow(20,Color.valueOf("#ffffff"));
        //arrowShadow.setBlurType(DropShadow.blurType.GAUSSIAN);
        arrowShadow.setRadius(16.8125);
        arrowShadow.setSpread(0.32);
        arrowShadow.setWidth(48.25);
        arrow.setEffect(arrowShadow);

        root.getChildren().add(arrow);

        ImageView cherryImageView = createImageView("cherry.png", 10.0, 10.0, 60.0, 55.0, 0.0, new Glow());
        updateCherryCount();
        root.getChildren().addAll(cherryImageView);

        Button saveButton = createButton("SAVE", 238.0, 425.0, 32.0);
        Button loadButton = createButton("LOAD", 238.0, 520.0, 31.0);
        Button MainButton = createButton("MENU", 238.0, 615.0, 28.0);
        MainButton.setId("mainmenu");
        MainButton.setOnMousePressed(mouseEvent -> {
            RealSceneMangaer rg=new RealSceneMangaer();
            try {
                SceneManager ob=new SceneManager(1);
                //ob.remInstruction();
                ob.remCherrydisplay();
                rg.switchToMainMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        saveButton.setStyle(
                "-fx-background-color: #ff5275; " +  // Green background color
                        "-fx-text-fill: white; " +          // White text color
                        "-fx-font-size: 26px; " +           // Font size
                        "-fx-padding: 10px 20px; " +         // Padding
                        "-fx-background-radius: 5px; " +    // Rounded corners
                        "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
        );
        loadButton.setStyle(
                "-fx-background-color: #ff5275; " +  // Green background color
                        "-fx-text-fill: white; " +          // White text color
                        "-fx-font-size: 26px; " +           // Font size
                        "-fx-padding: 10px 20px; " +         // Padding
                        "-fx-background-radius: 5px; " +    // Rounded corners
                        "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );" // Drop shadow
        );
        MainButton.setStyle(
                "-fx-background-color: #ff5275; " +  // Green background color
                        "-fx-text-fill: white; " +          // White text color
                        "-fx-font-size: 26px; " +           // Font size
                        "-fx-padding: 10px 20px; " +         // Padding
                        "-fx-background-radius: 5px; " +    // Rounded corners
                        "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.3) , 5, 0.0 , 0 , 1 );"
        );

        root.getChildren().addAll(saveButton, loadButton, MainButton);

        //scene = new Scene(root, 600, 1000);

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

    private Button createButton(String text, double layoutX, double layoutY, double fontSize) {
        Button button = new Button(text);
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setPrefSize(123.0, 53.0);
        button.setTextFill(Color.web("#6e2e65"));

        Font buttonFont = new Font(fontSize);
        button.setFont(buttonFont);

        DropShadow buttonShadow = new DropShadow();
        button.setEffect(buttonShadow);

        return button;
    }
    public void updateCherryCount(){
        if(cherrycount!=null) {
            root.getChildren().remove(cherrycount);
        }
        cherrycount = createText(": "+OurHero.getCherrycount(), 60.0, 50.0, 30.0, new Glow(0));
        cherrycount.setFill(Color.WHITE);
        root.getChildren().add(cherrycount);
    }

}
