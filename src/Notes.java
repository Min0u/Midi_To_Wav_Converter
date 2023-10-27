import java.util.ArrayList;
import java.util.List;

public class Notes {
    private static List<Notes> notes = new ArrayList<>();
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
    public Notes(int channel, int key, int octave, int volume, float frequence, int note, int command, long start, long end) {
        this.channel = channel;
        this.key = key;
        this.octave = octave;
        this.volume = volume;
        this.frequence = frequence;
        this.note = note;
        this.command = command;
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
