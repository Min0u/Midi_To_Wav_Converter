import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import java.io.File;
import java.io.IOException;

public class FichierMidi {
    // Attributs
    private static Sequence sequence;
    private static long resolution;
    private static float totalTime;
    private static int tempo;

    // Constructeur
    public FichierMidi(String file) {
        try {
            this.sequence = MidiSystem.getSequence(new File(file));
            this.resolution = sequence.getResolution();
            this.totalTime = 0;
        } catch (InvalidMidiDataException | IOException e) {
            e.printStackTrace();
        }
    }

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

    //  Méthodes
    public static float calculTotalTime() {
        float totalTime = 0;
        for (Notes note : Notes.getNotes()) {
            totalTime = Math.max(totalTime, note.getTime() + note.getDuration());
        }
        return totalTime;
    }
}
