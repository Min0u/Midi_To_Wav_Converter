package Midi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import java.io.File;
import java.io.IOException;

public class FichierMidi implements Extractable<String> {
    // Attributs
    private static Sequence sequence;
    private static long resolution;
    private static float totalTime;
    private static int tempo;

    //  Getters
    public static long getResolution() {
        return resolution;
    }

    public static int getTempo() {
        return tempo;
    }

    public static Sequence getSequence() {
        return sequence;
    }

    public static float getTotalTime() {
        return totalTime;
    }

    //  Setters
    public static void setTempo(int nv_tempo) {
        tempo = nv_tempo;
    }

    public static void setTotalTime(float nv_totalTime) {
        totalTime = nv_totalTime;
    }

    private static void setResolution(int nv_resolution) {
        resolution = nv_resolution;
    }

    private static void setSequence(Sequence nv_sequence) {
        sequence = nv_sequence;
    }

    //  Méthodes
    public static float calculTotalTime() {
        float totalTime = 0;
        for (Notes note : Notes.getNotes()) {
            totalTime = Math.max(totalTime, note.getTime() + note.getDuration());
        }
        return totalTime;
    }

    @Override
    public void extract(String f) {
        try {
            File file = new File(f);
            Sequence seq = MidiSystem.getSequence(file);
            int res = seq.getResolution();

            setSequence(seq);
            setResolution(res);
            setTempo(0);

            System.out.println("Début de l'extraction du fichier MIDI : " + file.getName());
            System.out.println("Extraction de la séquence et de la résolution terminée...");
        } catch (InvalidMidiDataException | IOException e) {
            e.printStackTrace();
        }
    }
}
