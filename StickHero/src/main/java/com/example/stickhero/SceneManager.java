package com.example.stickhero;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

//import static com.example.stickhero.OurHero.trn0;

public class SceneManager {
    private static Rectangle rinst;
    private static Text instructions;
    private static Text pressHoldMouse;
    private static Text SpaceFlip;
    private static boolean continueflag=true;
    private static boolean counted=false;
    private static boolean collision=false;
    private static boolean transflag=false;
    private static boolean pauseflag=false;

    public static boolean isTransflag() {
        return transflag;
    }
    private Cherries cherries;
    private Mines mines;
    private static Rectangle redarea;
    private static Timeline gameLoop;

    public static Timeline getGameLoop() {
        return gameLoop;
    }

    public static void setGameLoop() {
        if(gameLoop!=null)
        SceneManager.gameLoop.stop();
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
    static ImageView chmines=null;

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
    private static Text scorecount;
    private static boolean reminstFlag;
    private ImageView pause;
    static BackgroundImage backgroundImage;
    static Rectangle rec=new Rectangle(70,550,5,0);
    private static String backgroundrandom;

    public static String getBackgroundrandom() {
        return backgroundrandom;
    }
    private BandanaAnimation bandanaobj;
    private Thread thrdBandana;
    private OurHero obh;

    public SceneManager(int i){}

    public SceneManager() throws IOException{
        obh=OurHero.getInstance();
        rec=new Rectangle(70,550,5,0);
        //ismoving=false;
        counted=false;
        transflag=false;
        chmines=null;
        //playMusic();
        mainpage=new AnchorPane();
        if(Menu.inceptionFlag) {
            mainpage.setScaleY(-1);
        }
        mainscene=new Scene(mainpage,width,height);
        pauseflag=false;
        pause=createImageView("pause.png",20,20,30,35,0,new DropShadow());
        mainpage.getChildren().add(pause);
        switchtoPause();
        Button b1 = (Button) PauseMenu.root.lookup("#mainmenu");
        System.out.println(b1);
        b1.setDisable(false);

        rectangle.setOpacity(0);
        mainpage.getChildren().add(rectangle);



        backgroundrandom="background"+String.valueOf(((int)(Math.random()*10))+1)+".jpeg";
        if(Menu.inceptionFlag){
            backgroundrandom="inception.jpg";
        }
        System.out.println(backgroundrandom);
        Image image = new Image(backgroundrandom);
        // new BackgroundSize(width, height, widthAsPercentage, heightAsPercentage, contain, cover)
        BackgroundSize backgroundSize = new BackgroundSize(width, height, false, false, true, true);
        // new BackgroundImage(image, repeatX, repeatY, position, size)
        backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        // new Background...)
        Background background = new Background(backgroundImage);
        mainpage.setBackground(background);
        collisiontimer.start();
        collisiontimerCherry.start();
        collisiontimerMines.start();

        if(Menu.inceptionFlag==false) {
            addInstruction();
        }
        reminstFlag=false;
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


        bandanaobj=BandanaAnimation.getInstance();//SingleTon Design Pattern Implementation
        thrdBandana=new Thread(bandanaobj);//Bandana Animation Thread Created
        thrdBandana.start();//Bandana Animation Thread Started

        cherries=new Cherries();
        if(Math.random()>0.5) {
            System.out.println("Adding cherry");
            addCherry();
        }
        mines=new Mines();

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
            SoundDesign obButton=new SoundDesign(8);
            new Thread(obButton).start();
            pauseflag=true;
            Sticks.stopStickAnimation();
            if (OurHero.getTrn0() != null) OurHero.getTrn0().pause();
            if (OurHero.getTrn2() != null) OurHero.getTrn2().pause();
            if (OurHero.getTrn() != null) OurHero.getTrn().pause();
            if (OurHero.getTrn3() != null) OurHero.getTrn3().pause();
            if (OurHero.getTrn4() != null) OurHero.getTrn4().pause();
            if(trn!=null)trn.pause();
            if(trn0!=null)trn0.pause();
            if(trn1!=null)trn1.pause();
            if(trn2!=null)trn2.pause();
            if(trn3!=null)trn3.pause();
            if(trn4!=null)trn4.pause();
            if(trn5!=null)trn5.pause();
            if(t!=null)t.pause();

            PauseMenu o=new PauseMenu(backgroundrandom);
            o.updateCherryCount();
            mainpage.getChildren().add(PauseMenu.root);
            PauseMenu.root.toFront();
        });
        rectangle.setOnMousePressed(mouseEvent -> {
            SoundDesign obButton=new SoundDesign(8);
            new Thread(obButton).start();
            pauseflag=true;
            if (OurHero.getTrn0() != null) OurHero.getTrn0().pause();
            if (OurHero.getTrn2() != null) OurHero.getTrn2().pause();
            if (OurHero.getTrn() != null) OurHero.getTrn().pause();
            if (OurHero.getTrn3() != null) OurHero.getTrn3().pause();
            if (OurHero.getTrn4() != null) OurHero.getTrn4().pause();
            if(trn!=null)trn.pause();
            if(trn0!=null)trn0.pause();
            if(trn1!=null)trn1.pause();
            if(trn2!=null)trn2.pause();
            if(trn3!=null)trn3.pause();
            if(trn4!=null)trn4.pause();
            if(trn5!=null)trn5.pause();
            if(t!=null)t.pause();

            Sticks.stopStickAnimation();
            if(PauseMenu.root==null) {
                PauseMenu mn = new PauseMenu();
            }
            PauseMenu o=new PauseMenu(backgroundrandom);
            o.updateCherryCount();
            mainpage.getChildren().add(PauseMenu.root);
            PauseMenu.root.toFront();
        });
    }
    public static void removePauseMenu(){
        if (OurHero.getTrn0() != null && OurHero.getTrn0().getStatus() == Animation.Status.PAUSED) {
            OurHero.getTrn0().play();
        }
        if (OurHero.getTrn2() != null && OurHero.getTrn2().getStatus() == Animation.Status.PAUSED) {
            OurHero.getTrn2().play();
        }
        if (OurHero.getTrn() != null && OurHero.getTrn().getStatus() == Animation.Status.PAUSED) {
            OurHero.getTrn().play();
        }
        if (OurHero.getTrn3() != null && OurHero.getTrn3().getStatus() == Animation.Status.PAUSED) {
            OurHero.getTrn3().play();
        }
        if (OurHero.getTrn4() != null && OurHero.getTrn4().getStatus() == Animation.Status.PAUSED) {
            OurHero.getTrn4().play();
        }
        if(trn0!=null && trn0.getStatus()==Animation.Status.PAUSED){
            trn0.play();
        }
        if(trn!=null && trn.getStatus()==Animation.Status.PAUSED){
            trn.play();
        }
        if(trn1!=null && trn1.getStatus()==Animation.Status.PAUSED){
            trn1.play();
        }
        if(trn2!=null && trn2.getStatus()==Animation.Status.PAUSED){
            trn2.play();
        }
        if(trn3!=null && trn3.getStatus()==Animation.Status.PAUSED){
            trn3.play();
        }
        if(trn4!=null && trn4.getStatus()==Animation.Status.PAUSED){
            trn4.play();
        }
        if(t!=null && t.getStatus()==Animation.Status.PAUSED){
            t.play();
        }

        Sticks.resumeStickAnimation();
        mainpage.getChildren().remove(PauseMenu.root);
        pauseflag=false;
    }
    private void startGameLoop() {
         gameLoop = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
            if(!continueflag){
                gameLoop.stop();

                thrdBandana.interrupt();//Bandana Animation Thread Stopped

                System.out.println("done");
                collisiontimer.stop();
                collisiontimerCherry.stop();
                collisiontimerMines.stop();
                RealSceneMangaer rg=new RealSceneMangaer();
                try {
                    rg.changeScene(3);//IMPLEMENTED USING FACADE Design Pattern

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(transflag);
            if(transflag&&!pauseflag){
                System.out.println("- "+transflag);
                if(reminstFlag==false) {
                    new Thread(() -> {
                        Platform.runLater(() -> {
                            remInstruction();
                        });
                    }).start();
                    reminstFlag=true;
                }
                System.out.println("ff");
                counted=false;
                collision=false;
                addPillars();
                System.out.println("Subsequent pillar added");


                        if(Math.random()>0.25) {
                            addCherry();
                        }


                new Thread(() -> {
                    Platform.runLater(() -> {
                        if(((int)Pillars.getLastpillar().getX()-75)>175) {
                            addMines();
                        } else if(Math.random()>0.5){
                            addMines();
                        }
                    });
                }).start();

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
        if(redarea!=null){
            mainpage.getChildren().remove(redarea);
        }
        redarea=new Rectangle();
        redarea.setX(pillar.getX()+pillar.getWidth()/2-10);
        redarea.setY(pillar.getY());
        redarea.setFill(Color.RED);
        redarea.setWidth(20);
        redarea.setHeight(5);
        mainpage.getChildren().add(redarea);
        TranslateTransition tpillar=new TranslateTransition(Duration.millis(500),pillar);
        tpillar.setByY(-450);
        TranslateTransition tpillarred=new TranslateTransition(Duration.millis(500),redarea);
        tpillarred.setByY(-450);
        new Thread(() -> {
            Platform.runLater(() -> {
                tpillar.play();
                tpillarred.play();
            });
        }).start();


        tpillar.setOnFinished(actionEvent -> {
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
        OurHero obj=OurHero.getInstance();
        ap=obj.createHero();
        ap.setLayoutX(0);
        //System.out.println(Pillars.getLastpillar().getY());
        ap.setLayoutY(Pillars.getLastpillar().getY()+offsetY);
        mainpage.getChildren().add(ap);
//        new Thread(() -> {
//            Platform.runLater(() -> {
//                bandanaAnimation();
//            });
//        }).start();

    }

    public void generateStick(){
        Buttons btn=new Buttons();
        mainpage.getChildren().add(btn);
        mainpage.getChildren().add(rec);
        System.out.println("button added");
    }
    public static void returnSticktoDefault(){
        mainpage.getChildren().remove(rec);
        rec=new Rectangle(70,550,5,0);
        mainpage.getChildren().add(rec);

    }
    private static TranslateTransition trn3;
    private static TranslateTransition trn5;
    private static TranslateTransition trn4;
    private static TranslateTransition trn2;
   private static TranslateTransition trn1;
   private static TranslateTransition trn;
   private static TranslateTransition trn0;


    public OurHero getObh() {
        return obh;
    }

    public void setObh(OurHero obh) {
        this.obh = obh;
    }

    static TranslateTransition t;
    public void playMusic(){
        String audioFile = "src\\main\\resources\\music.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public static void translateAfterLanding(){

//        Button b1 = (Button) PauseMenu.root.lookup("#mainmenu");
//        System.out.println(b1);
//        b1.setDisable(true);
//        System.out.println("Disabled");

        //ismoving=true;
        double distance=Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()-75;
        distance=-1*distance;
//        TranslateTransition trn0=new TranslateTransition(Duration.millis(1000),mainpage);
//        trn0.setByX(distance);
        trn=new TranslateTransition(Duration.millis(1000),rec);
        trn.setByX(distance);
        trn0=new TranslateTransition(Duration.millis(1000),redarea);
        trn0.setByX(distance);
        trn1=new TranslateTransition(Duration.millis(1000),Pillars.getLastpillar());
        trn1.setByX(distance);
        System.out.println(Pillars.getLastpillar().getX());

        trn2=new TranslateTransition(Duration.millis(1000),Pillars.getHeropillar());
        trn2.setByX(distance);

        Pillars.setHeropillar(Pillars.getLastpillar());
        trn3=new TranslateTransition(Duration.millis(1000),ap);
        trn3.setByX(distance);
        trn4=new TranslateTransition(Duration.millis(1000),ch);
        trn4.setByX(distance);
        System.out.println("Cherry translated");
        trn5=new TranslateTransition(Duration.millis(1000),chmines);
        trn5.setByX(distance);
//        trn0.play();
//        TranslateTransition trn5 = new TranslateTransition(Duration.millis(1000),backgroundImage);
//        trn5.setByX(distance);
        trn.play();
        trn0.play();
        trn1.play();
        trn2.play();
        trn3.play();
        trn5.play();

        trn4.play();
        trn3.setOnFinished(event -> {
            returnSticktoDefault();
            transflag=true;
            //ismoving=false;


        });
        trn4.setOnFinished(Event -> {
            //b1.setDisable(false);
            System.out.println("Enabled");
        });
    }
    ImageView cherryImageView;
    public void addCherryScore(){
        if(cherrycount!=null) {
            mainpage.getChildren().removeAll(cherrycount,cherryImageView);

        }
        cherryImageView = createImageView("cherry.png", 495.0, 10.0, 60.0, 55.0, 0.0, new Glow());
        cherrycount = createText(": "+(obh.getCherrycount()), 550.0, 50.0, 30.0,new Glow(0));
        cherrycount.setFill(Color.WHITE);
        Rectangle rec=new Rectangle(495,17.5,100,45);
        rec.setOpacity(0.35);
        rec.setArcWidth(20);
        rec.setArcHeight(20);
        mainpage.getChildren().addAll(rec,cherryImageView,cherrycount);
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

        System.out.println("Cherry function invoking");
        ch=cherries.make();
        if(ch!=null) {

            mainpage.getChildren().add(ch);
            ch.toFront();
        }
        System.out.println("cherry added successfully");
    }
    public void addMines(){
        if(chmines!=null){
            mainpage.getChildren().remove(chmines);
        }

        System.out.println("Mines function invoking");
        chmines=mines.make();
        if(chmines!=null) {
            mainpage.getChildren().add(chmines);
        }
        System.out.println("Mines added successfully");
    }
    AnimationTimer collisiontimer=new AnimationTimer() {
        @Override
        public void handle(long l) {
            checkCollision(ap,Pillars.getLastpillar());
        }
    };
    AnimationTimer collisiontimerMines=new AnimationTimer() {
        @Override
        public void handle(long l) {
            checkCollisionMines(ap,chmines);
        }
    };
    public void checkCollisionMines(AnchorPane ap,ImageView ch){
        if(chmines!=null) {
            if (ap.getBoundsInParent().intersects(ch.getBoundsInParent())&&collision==false) {
                collision=true;
                System.out.println("Bomb Collision detected");
                OurHero.stopThread();
                //trn3.stop();
                SceneManager.setTransflag(false);

                if (OurHero.getTrn0() != null) OurHero.getTrn0().stop();
                if (OurHero.getTrn2() != null) OurHero.getTrn2().stop();
                if (OurHero.getTrn() != null) OurHero.getTrn().stop();
                if (OurHero.getTrn3() != null) OurHero.getTrn3().stop();
                if (OurHero.getTrn4() != null) OurHero.getTrn4().stop();

                RotateTransition rt=new RotateTransition(Duration.millis(100),ap);
                TranslateTransition t=new TranslateTransition(Duration.millis(500),ap);
                if(OurHero.isFlipped()) {
                    t.setByY(50);
                }
                else {
                    t.setByY(-50);
                }
                OurHero.setFlipped(false);
                rt.setByAngle(180);
                rt.setCycleCount(5);
                rt.play();
                t.play();
                mainpage.getChildren().remove(ch);
                SoundDesign soundObjj=new SoundDesign(11);
                new Thread(soundObjj).start();
                SoundDesign soundObjij=new SoundDesign(5);
                new Thread(soundObjij).start();
                rt.setOnFinished(actionEvent -> {



                mainpage.getChildren().remove(ap);


                ch.setY(120000);
                SceneManager.setContinueflag(false);
                });
            }
        }
    }
    public static void checkCollision(AnchorPane ap, Rectangle p){
        if(ap.getBoundsInParent().intersects(p.getBoundsInParent())&& OurHero.isFlipped()){
            System.out.println("Collision detected");
            OurHero.stopThread();
            //trn3.stop();
            SceneManager.setTransflag(false);
            OurHero.setFlipped(false);
            if (OurHero.getTrn0() != null) OurHero.getTrn0().stop();
            if (OurHero.getTrn2() != null) OurHero.getTrn2().stop();
            if (OurHero.getTrn() != null) OurHero.getTrn().stop();
            if (OurHero.getTrn3() != null) OurHero.getTrn3().stop();
            if (OurHero.getTrn4() != null) OurHero.getTrn4().stop();
            t=new TranslateTransition(Duration.millis(1000),ap);
            t.setByY(255);
            t.play();
            SoundDesign soundobj=new SoundDesign(5);
            Thread t1=new Thread(soundobj);
            t1.start();

            t.setOnFinished(actionEvent -> {
                SceneManager.setContinueflag(false);
                System.out.println("Collision fall");

            });


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

        scorecount = createText("Score: " + (obh.getScore()), 230.0, 190.0, 40.0, new Glow(0));
        scorecount.setFill(Color.WHITE);
        mainpage.getChildren().add(scorecount);
    }
    public void checkCollisionCherry(AnchorPane ap,ImageView ch){
        mainpage.getChildren().remove(scorecount);
        scorecount = createText("Score: " + (obh.getScore()), 230.0, 190.0, 40.0, new Glow(0));
        scorecount.setFill(Color.WHITE);
        mainpage.getChildren().add(scorecount);
        if(ch!=null) {
            if (ap.getBoundsInParent().intersects(ch.getBoundsInParent())&&counted==false&&OurHero.isFlipped()) {
                counted=true;
                System.out.println("Ch: "+OurHero.getInstance().getCherrycount());
                OurHero.getInstance().setCherrycount(OurHero.getInstance().getCherrycount() + 1);
                mainpage.getChildren().remove(cherrycount);
                mainpage.getChildren().remove(ch);
                SoundDesign soundObjj=new SoundDesign(4);
                new Thread(soundObjj).start();
                cherrycount = createText(": " + (OurHero.getInstance().getCherrycount()), 550.0, 50.0, 30.0, new Glow(0));
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
        rinst.setOpacity(0.55);
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
    public static void remInstruction(){
        FadeTransition f1 = new FadeTransition(Duration.seconds(2), rinst);
        FadeTransition f2 = new FadeTransition(Duration.seconds(2), instructions);
        FadeTransition f3 = new FadeTransition(Duration.seconds(2), pressHoldMouse);
        FadeTransition f4 = new FadeTransition(Duration.seconds(2), SpaceFlip);
        f1.setFromValue(0.55);
        f1.setToValue(0);
        f2.setFromValue(1);
        f2.setToValue(0);

        f3.setFromValue(1);
        f3.setToValue(0);

        f4.setFromValue(1);
        f4.setToValue(0);
        f1.play();
        f2.play();
        f3.play();
        f4.play();
        f1.setOnFinished(actionEvent -> {
            Platform.runLater(() -> {
                mainpage.getChildren().removeAll(rinst, instructions, pressHoldMouse, SpaceFlip);
            });
        });
    }
    public void remCherrydisplay(){
        mainpage.getChildren().remove(cherrycount);
    }

    public void perfectLand(){
        OurHero ob=OurHero.getInstance();
        if(SceneManager.rec.getHeight()+SceneManager.rec.getX()+5>=Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()/2-10 && SceneManager.rec.getHeight()+SceneManager.rec.getX()+5<=Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()/2+10){
            ob.setScore(ob.getScore()+1);
            Text t=createText("Perfect!\n   +1", 0, 0, 20.0, new Glow(0));
            t.setX(Pillars.getLastpillar().getX()+Pillars.getLastpillar().getWidth()/2-30);
            t.setY(Pillars.getLastpillar().getY()-500);
            t.setFill(Color.BLACK);
            mainpage.getChildren().add(t);
            SoundDesign obkjj=new SoundDesign(6);
            new Thread(obkjj).start();
            TranslateTransition trntext=new TranslateTransition(Duration.millis(1000),t);
            trntext.setByY(-50);
            FadeTransition f1 = new FadeTransition(Duration.millis(1100), t);
            f1.setFromValue(1);
            f1.setToValue(0);
            trntext.play();
            f1.play();
            f1.setOnFinished(actionEvent -> {
                mainpage.getChildren().removeAll(t);

            });


        }
    }
}
