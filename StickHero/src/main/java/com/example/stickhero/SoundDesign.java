package com.example.stickhero;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class SoundDesign implements Runnable {



    private int ch;
    public SoundDesign(int i){
        this.ch=i;
    }
    public void stickGrowSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\stick_grow_loop.wav";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void backgroundSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\music.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }

    public void stickFallSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\stick_land_sound.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }

    public void stickFallingSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\woodfall2.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void scoreSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\Score.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void perfectLandSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\victory.wav";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void cherryCollectedSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\cherrySound.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void deathSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\death2.wav";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void flipSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\flip.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void buttonSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\button.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void bombSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\bombExplosion.wav";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    public void timeSound(){
        String audioFile = "src\\main\\resources\\SoundDesign\\Time.mp3";
        Media media = new Media(new File(audioFile).toURI().toString());

        // Create a media player
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        if(!Menu.muteFlag)
        mediaPlayer.play();
    }
    @Override
    public void run() {
        switch (ch){
            case 1:
                stickFallSound();
                break;
            case 2:
                stickGrowSound();
                break;
            case 3:
                scoreSound();
                break;
            case 4:
                cherryCollectedSound();
                break;
            case 5:
                deathSound();
                break;
            case 6:
                perfectLandSound();
                break;
            case 7:
                flipSound();
                break;
            case 8:
                buttonSound();
                break;
            case 9:
                stickFallingSound();
                break;
            case 10:
                backgroundSound();
                break;
            case 11:
                bombSound();
                break;
            case 12:
                timeSound();
                break;
            default:

                break;

    }

}
}
