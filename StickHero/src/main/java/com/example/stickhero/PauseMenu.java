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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import static com.example.stickhero.SceneManager.height;
import static com.example.stickhero.SceneManager.width;

public class PauseMenu {

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        PauseMenu.primaryStage = primaryStage;
    }

    public void pauseMenu() {
        AnchorPane root = new AnchorPane();

        Image image = new Image("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\background.png");
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background(images...)
        Background background = new Background(backgroundImage);
        root.setBackground(background);


        Polygon arrow = new Polygon();
        arrow.setLayoutX(320.0);
        arrow.setLayoutY(432.0);
        arrow.getPoints().addAll(-84.66664123535156, 39.999969482421875, 64.59919738769531, 39.29170608520508, -8.609027862548828, -42.12510299682617);
        arrow.setRotate(90.0);
        arrow.setFill(Color.WHITE);
        arrow.setStroke(Color.BLACK);
        arrow.setStrokeWidth(0);
        //arrow.setStrokeType(Polygon.StrokeType.INSIDE);

        DropShadow arrowShadow = new DropShadow();
        //arrowShadow.setBlurType(DropShadow.blurType.GAUSSIAN);
        arrowShadow.setRadius(16.8125);
        arrowShadow.setSpread(0.32);
        arrowShadow.setWidth(48.25);
        arrow.setEffect(arrowShadow);

        root.getChildren().add(arrow);

        ImageView cherryImageView = createImageView("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\cherry.png", 10.0, 10.0, 60.0, 55.0, 0.0, new Glow());
        Text cherrycount = createText(": 9", 60.0, 50.0, 30.0, new Glow(0));
        cherrycount.setFill(Color.WHITE);
        root.getChildren().addAll(cherrycount, cherryImageView);

        Button saveButton = createButton("SAVE", 238.0, 525.0, 32.0);
        Button loadButton = createButton("LOAD", 238.0, 620.0, 31.0);

        root.getChildren().addAll(saveButton, loadButton);

        Scene scene = new Scene(root, 600, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
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

}
