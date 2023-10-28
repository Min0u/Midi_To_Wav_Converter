package Midi;

import java.util.ArrayList;
import java.util.List;

public class Notes {
    private static final List<Notes> notes = new ArrayList<>();
    int channel;
    int key;
    int octave;
    int volume;
    float frequence;
    int note;
    int command;
    float time;
    float duration;

    // Constructeur
    public Notes(Object[] infos) {
        this.channel = (int) infos[0];
        this.key = (int) infos[1];
        this.octave = (int) infos[2];
        this.volume = (int) infos[3];
        this.frequence = (float) infos[4];
        this.note = (int) infos[5];
        this.command = (int) infos[6];
        long start = (long) infos[7];
        long end = (long) infos[8];

        this.time = (((float) start) * 60 / (4 * FichierMidi.getTempo() * FichierMidi.getResolution()));
        float endTime = (((float) end) * 60 / (4 * FichierMidi.getTempo() * FichierMidi.getResolution()));
        this.duration = endTime - time;
    }

    // Getters
    public static List<Notes> getNotes() {
        return notes;
    }

    public float getDuration() {
        return duration;
    }

    public float getFrequence() {
        return frequence;
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

    public float getTime() {
        return time;
    }

    // Méthodes
    public static void add(Notes note) {
        notes.add(note);
    }

}
