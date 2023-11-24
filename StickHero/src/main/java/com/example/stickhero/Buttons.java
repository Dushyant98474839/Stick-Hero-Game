package com.example.stickhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;


public class Buttons extends Button {
    private static boolean flag=false;

    private static boolean flagtrns=true;
    public static void setFlagtrns(boolean flagtrns) {
        Buttons.flagtrns = flagtrns;
    }
    private static boolean canFlip=false;

    public static boolean isCanFlip() {
        return canFlip;
    }

    public static void setCanFlip(boolean canFlip) {
        Buttons.canFlip = canFlip;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Buttons.flag = flag;
    }

    public static boolean isFlag2() {
        return flag2;
    }

    public static void setFlag2(boolean flag2) {
        Buttons.flag2 = flag2;
    }

    private static boolean flag2=true;

    private Timeline timeline;
    Sticks st=new Sticks();

    public Buttons() {
        setOpacity(0);
        setMinHeight(1000);
        setMaxHeight(1000);
        setMinWidth(600);
        setMaxWidth(600);
        setupTimeline();
        initialiseButtonListeners();
    }

    public Button createInputButtonToGrowStick(){
        Button btn=new Button();
        return btn;
    }
    public void initialiseButtonListeners(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if ((mouseEvent.getButton().equals(MouseButton.PRIMARY) && flag == false)) {
                        timeline.play();
                        flag2=false;
                    }

                }


        });
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                if(canFlip){
                    OurHero.flipHero();
                }
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)&&flag2==false) {
                    System.out.println("Released executing");
                    timeline.stop();
                    flag=true;
                    flag2=true;

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //System.out.println(SceneManager.rec.getX());
                    st.fallStick(SceneManager.rec);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    canFlip=true;
                    OurHero.moveHero();
                }
            }
        });
    }

    private void setupTimeline() {
        timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                growStick();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void growStick() {
        st.growStick(SceneManager.rec);
    }
}
