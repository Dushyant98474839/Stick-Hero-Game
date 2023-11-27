package com.example.stickhero;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class SceneManager {
    private Rectangle rinst;
    private Text instructions,pressHoldMouse,SpaceFlip;
    private static boolean continueflag=true;
    private static boolean counted=false;
    private static boolean transflag=false;
    private static boolean pauseflag=false;

    public static boolean isTransflag() {
        return transflag;
    }

    public static void setTransflag(boolean transflag) {
        SceneManager.transflag = transflag;
    }

    public static boolean isContinueflag() {
        return continueflag;
    }

    public static void setContinueflag(boolean continueflag) {
        SceneManager.continueflag = continueflag;
    }
    static ImageView ch=null;

    public static AnchorPane ap;
    private static AnchorPane mainpage;
    private static Scene mainscene;

    public Scene getMainscene() {
        return mainscene;
    }

    public void setMainscene(Scene mainscene) {
        SceneManager.mainscene = mainscene;
    }

    public static void setPauseflag(boolean pauseflag) {
        SceneManager.pauseflag = pauseflag;
    }
    //private Stage mainstage;

    public static Rectangle getRec() {
        return rec;
    }

    public static void setRec(Rectangle rec) {
        SceneManager.rec = rec;
    }

    public static final int height=800;
    public static final int width=600;
    public static final int offsetX=60;
    public static final int offsetY=-53;
    private Rectangle rectangle=new Rectangle(20,20,30,30);
    static Text cherrycount=null;
    Text scorecount;
    private ImageView pause;
    //public static volatile boolean ismoving=false;
    public SceneManager(int i){}

    public SceneManager() throws IOException{
        //ismoving=false;
        counted=false;
        transflag=false;
        mainpage=new AnchorPane();
        mainscene=new Scene(mainpage,width,height);
        pauseflag=false;
//        mainstage=new Stage();
        //mainstage.setScene(mainscene);
//        mainstage.setResizable(false);
//        mainstage.setTitle("Stick Hero");
//        Image icon=new Image("file:///D:\\JAVA PRJ\\StickHero\\src\\main\\resources\\Assets\\Logo.png");
//        mainstage.getIcons().add(icon);
        pause=createImageView("pause.png",20,20,30,35,0,new DropShadow());
        mainpage.getChildren().add(pause);
        switchtoPause();

        rectangle.setOpacity(0);
        mainpage.getChildren().add(rectangle);


        Image image = new Image("background.png");
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background...)
        Background background = new Background(backgroundImage);
        mainpage.setBackground(background);
        collisiontimer.start();
        collisiontimerCherry.start();

        addInstruction();
        addScoreDisplay();
        if(cherrycount!=null){
            mainpage.getChildren().remove(cherrycount);
        }
        addCherryScore();
        addFirstPillar();
        System.out.println("Hero pillar added");
        //returnSticktoDefault();
        addHero();
        addPillars();
        System.out.println("First pillar added");
        if(Math.random()>0.5) {
            addCherry();
        }
        System.out.println("* "+transflag);
        generateStick();
        System.out.println("@"+transflag);
        startGameLoop();
        System.out.println("#"+transflag);

    }
    public void switchtoPause(){
        if(PauseMenu.root==null) {
            PauseMenu mn = new PauseMenu();
        }
        pause.setOnMouseClicked(mouseEvent -> {
            pauseflag=true;


            PauseMenu o=new PauseMenu(1);
            o.updateCherryCount();
            mainpage.getChildren().add(PauseMenu.root);
            PauseMenu.root.toFront();
        });
        rectangle.setOnMousePressed(mouseEvent -> {
            pauseflag=true;

            if(PauseMenu.root==null) {
                PauseMenu mn = new PauseMenu();
            }
            PauseMenu o=new PauseMenu(1);
            o.updateCherryCount();
            mainpage.getChildren().add(PauseMenu.root);
            PauseMenu.root.toFront();
        });
    }
    public static void removePauseMenu(){
        mainpage.getChildren().remove(PauseMenu.root);
        pauseflag=false;
    }
    private Timeline gameLoop;
    private void startGameLoop() {
         gameLoop = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if(!continueflag){
                System.out.println("done");
                collisiontimer.stop();
                collisiontimerCherry.stop();
                RealSceneMangaer rg=new RealSceneMangaer();
                try {
                    rg.switchToGameover();
                    //mainstage.close();
                    gameLoop.stop();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(transflag);
            if(transflag&&!pauseflag){
                System.out.println("- "+transflag);
                remInstruction();
                System.out.println("ff");
                counted=false;
                addPillars();
                System.out.println("Subsequent pillar added");
                if(Math.random()>0.5) {
                    addCherry();
                }
                transflag=(false);
                //returnSticktoDefault();
                //System.out.println(rec.getHeight()+" "+rec.getX()+" "+rec.getY());
                //generateStick();
            }
            //System.out.println("flagloop");
        }));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }
//    public Stage getStage(){
//        return mainstage;
//    }
    public void addFirstPillar(){
        Pillars pillars=new Pillars();
        Rectangle firstpillar=pillars.makeFirstPillar();
        mainpage.getChildren().add(firstpillar);
    }
    public void addPillars(){
        System.out.println("Scenepillarcallloop");
        Pillars pillars=new Pillars();
        Rectangle pillar=pillars.makePillars();
        System.out.println("Pillar returned");
        mainpage.getChildren().add(pillar);
        System.out.println("Pillar Added");
        Buttons.setFlag(false);
        Text warning=createText("Don't click on pillars",pillar.getX()+10,pillar.getY()+100,15,new Glow());
        warning.setFill(Color.WHITE);
        pillar.setOnMousePressed(mouseEvent -> {
            warning.setLayoutX(mouseEvent.getSceneX()-20);
            warning.setLayoutY(mouseEvent.getSceneY());
            mainpage.getChildren().add(warning);
        });
        pillar.setOnMouseReleased(mouseEvent -> {
            mainpage.getChildren().remove(warning);
        });
    }
//    Button buttonip=new Button();
//    public void createInputBtnToGrowStick(){
//        Buttons btn=new Buttons();
//        buttonip=btn.createInputButtonToGrowStick();
//        mainpage.getChildren().add(buttonip);
//    }
//    public void removeInputBtnToGrowStick(){
//        mainpage.getChildren().remove(buttonip);
//    }
    public void addHero() throws IOException {
        OurHero obj=new OurHero();
        ap=obj.createHero();
        ap.setLayoutX(0);
        //System.out.println(Pillars.getLastpillar().getY());
        ap.setLayoutY(Pillars.getLastpillar().getY()+offsetY);
        mainpage.getChildren().add(ap);
    }
    static Rectangle rec=new Rectangle(70,550,5,0);
    public void generateStick(){
        Buttons btn=new Buttons();
        mainpage.getChildren().add(btn);
        mainpage.getChildren().add(rec);
        System.out.println("button added");
    }
    public static void returnSticktoDefault(){
        mainpage.getChildren().remove(rec);
        rec=new Rectangle(70,Pillars.getLastpillar().getY(),5,0);
        mainpage.getChildren().add(rec);

    }
    static TranslateTransition trn3;
    public static void translateAfterLanding(){

//            Button b1 = (Button) PauseMenu.root.lookup("#mainmenu");
//            System.out.println(b1);
//            b1.setVisible(false);
//            System.out.println("Disabled");

        //ismoving=true;
        double distance=Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()-75;
        distance=-1*distance;
//        TranslateTransition trn0=new TranslateTransition(Duration.millis(1000),mainpage);
//        trn0.setByX(distance);
        TranslateTransition trn=new TranslateTransition(Duration.millis(1000),rec);
        trn.setByX(distance);
        TranslateTransition trn1=new TranslateTransition(Duration.millis(1000),Pillars.getLastpillar());
        trn1.setByX(distance);
        System.out.println(Pillars.getLastpillar().getX());

        TranslateTransition trn2=new TranslateTransition(Duration.millis(1000),Pillars.getHeropillar());
        trn2.setByX(distance);

        Pillars.setHeropillar(Pillars.getLastpillar());
        trn3=new TranslateTransition(Duration.millis(1000),ap);
        trn3.setByX(distance);
        TranslateTransition trn4=new TranslateTransition(Duration.millis(1000),ch);
        trn4.setByX(distance);
//        trn0.play();
        trn.play();
        trn1.play();
        trn2.play();
        trn3.play();

        trn4.play();
        trn3.setOnFinished(event -> {
            returnSticktoDefault();
            transflag=true;
           // ismoving=false;

//            b1.setVisible(true);
//            System.out.println("Enabled");
        });
    }

    public void addCherryScore(){
        if(cherrycount!=null) {
            mainpage.getChildren().remove(cherrycount);
        }
        ImageView cherryImageView = createImageView("cherry.png", 495.0, 10.0, 60.0, 55.0, 0.0, new Glow());
        cherrycount = createText(": "+(OurHero.getCherrycount()), 550.0, 50.0, 30.0,new Glow(0));
        cherrycount.setFill(Color.WHITE);
        mainpage.getChildren().addAll(cherryImageView,cherrycount);
    }
    public ImageView createImageView(String imageUrl, double layoutX, double layoutY, double fitWidth, double fitHeight, double rotate, javafx.scene.effect.Effect effect) {
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

    public static void setToDefault(){
        rec=new Rectangle(70,Pillars.getLastpillar().getY(),5,0);
        mainpage.getChildren().add(rec);
        ap.setLayoutX(75);
        continueflag=true;
    }

    public void addCherry(){
        if(ch!=null){
            mainpage.getChildren().remove(ch);
        }
        Cherries cherries=new Cherries();
        ch=cherries.makecherries();
        mainpage.getChildren().add(ch);
    }
    AnimationTimer collisiontimer=new AnimationTimer() {
        @Override
        public void handle(long l) {
            checkCollision(ap,Pillars.getLastpillar());
        }
    };
    public static void checkCollision(AnchorPane ap, Rectangle p){
        if(ap.getBoundsInParent().intersects(p.getBoundsInParent())&& OurHero.isFlipped()){
            //trn3.stop();
            SceneManager.setContinueflag(false);
            SceneManager.setTransflag(false);
            OurHero.setFlipped(false);
        }
    }


    AnimationTimer collisiontimerCherry=new AnimationTimer() {
        @Override
        public void handle(long l) {
            checkCollisionCherry(ap,ch);
        }
    };
    public void addScoreDisplay(){
        Rectangle r=new Rectangle();
        r.setArcHeight(20);
        r.setArcWidth(20);
        r.setOpacity(0.35);
        r.setFill(Color.BLACK);
        r.setHeight(68);
        r.setWidth(191);
        r.setLayoutX(205);
        r.setLayoutY(144);
        mainpage.getChildren().add(r);
        scorecount = createText("Score: " + (OurHero.getScore()), 230.0, 190.0, 40.0, new Glow(0));
        scorecount.setFill(Color.WHITE);
        mainpage.getChildren().add(scorecount);
    }
    public void checkCollisionCherry(AnchorPane ap,ImageView ch){
        mainpage.getChildren().remove(scorecount);
        scorecount = createText("Score: " + (OurHero.getScore()), 230.0, 190.0, 40.0, new Glow(0));
        scorecount.setFill(Color.WHITE);
        mainpage.getChildren().add(scorecount);
        if(ch!=null) {
            if (ap.getBoundsInParent().intersects(ch.getBoundsInParent())&&counted==false) {
                counted=true;
                OurHero.setCherrycount(OurHero.getCherrycount() + 1);
                mainpage.getChildren().remove(cherrycount);
                mainpage.getChildren().remove(ch);
                cherrycount = createText(": " + (OurHero.getCherrycount()), 550.0, 50.0, 30.0, new Glow(0));
                cherrycount.setFill(Color.WHITE);

                mainpage.getChildren().add(cherrycount);
            }
        }
    }

    public void addInstruction(){
        rinst=new Rectangle();
        rinst.setX(50);
        rinst.setY(250);
        rinst.setWidth(500);
        rinst.setHeight(205);
        rinst.setArcHeight(20);
        rinst.setArcWidth(20);
        rinst.setOpacity(0.35);
        rinst.setFill(Color.BLACK);
        System.out.println("Instruction added");
        instructions=new Text("Instructions!");
        instructions.setY(305);
        instructions.setX(195);
        instructions.setFill(Color.WHITE);
        instructions.setFont(new Font("Arial",40));
        pressHoldMouse=new Text("1. Press and Hold Mouse to Grow Stick.");
        pressHoldMouse.setY(350);
        pressHoldMouse.setX(75);
        pressHoldMouse.setFill(Color.WHITE);
        pressHoldMouse.setFont(new Font("Arial",20));
        SpaceFlip=new Text("2. Click Spacebar to Flip Hero.\n\n\t\t\t   "+ "-Input Attentively-");
        SpaceFlip.setX(75);
        SpaceFlip.setY(390);
        SpaceFlip.setFill(Color.WHITE);
        SpaceFlip.setFont(new Font("Arial",20));
        mainpage.getChildren().addAll(rinst,instructions,pressHoldMouse,SpaceFlip);

    }
    public void remInstruction(){
        mainpage.getChildren().removeAll(rinst,instructions,pressHoldMouse,SpaceFlip);
    }
    public void remCherrydisplay(){
        mainpage.getChildren().remove(cherrycount);
    }

}
