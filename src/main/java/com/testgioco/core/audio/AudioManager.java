package com.testgioco.core.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AudioManager {
    private static AudioManager instance;
    private List<Clip> activeClips;

    private AudioManager() {
        activeClips = new ArrayList<>();
    }

    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }
        return instance;
    }

    public void playSound(String path) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            activeClips.add(clip);

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    activeClips.remove(clip);
                }
            });

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopAllSounds() {
        for (Clip clip : activeClips) {
            clip.stop();
        }
        activeClips.clear();
    }
}

