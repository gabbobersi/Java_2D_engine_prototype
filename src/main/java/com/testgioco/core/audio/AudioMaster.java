package com.testgioco.core.audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class AudioMaster {
    public static void play(String path){
        AudioInputStream audioInputStream = null;
        try{
            // Example: path = "assets/audio/music.wav"
            File music = new File(path);
            if (music.exists()){
                audioInputStream = AudioSystem.getAudioInputStream(music);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);

                // Lowering the volume
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-15.0f);

                clip.start();
            } else {
                System.out.println("Music does not exist");
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Chiudi l'AudioInputStream nel blocco finally
            if (audioInputStream != null) {
                try {
                    audioInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
