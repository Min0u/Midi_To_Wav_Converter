package Midi;

public class NoteJouee {
    // Attributs
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
    public NoteJouee(Object[] infos, FichierMidi fm, Message m) {
        this.channel = (int) infos[0];
        this.key = (int) infos[1];
        this.octave = (int) infos[2];
        this.volume = (int) infos[3];
        this.frequence = (float) infos[4];
        this.note = (int) infos[5];
        this.command = (int) infos[6];
        long start = (long) infos[7];
        long end = (long) infos[8];

        this.time = (((float) start) * 60 / (4 * m.getTempo() * fm.getResolution()));
        float endTime = (((float) end) * 60 / (4 * m.getTempo() * fm.getResolution()));
        this.duration = endTime - time;
    }

    // Getters
    public float getDuration() {
        return this.duration;
    }

    public float getFrequence() {
        return this.frequence;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getChannel() {
        return this.channel;
    }

    public float getTime() {
        return this.time;
    }
}
