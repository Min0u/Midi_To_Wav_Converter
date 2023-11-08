package Midi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FichierMidi implements Extractable {
    // Attributs
    private List<Track> tracks;
    private long resolution;
    private float totalTime;
    private final String filePath;

    // Constructeur
    public FichierMidi(String filePath){
        this.filePath = filePath;
        this.tracks = new ArrayList<>();
        this.extract();
    }


    //  Getters
    public long getResolution() {
        return this.resolution;
    }

    public float getTotalTime() {
        return this.totalTime;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    //  Setters
    public void setTotalTime(float nv_totalTime) {
        this.totalTime = nv_totalTime;
    }

    private void setResolution(int nv_resolution) {
        this.resolution = nv_resolution;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    //  Méthodes
    @Override
    public void extract() {
        try {
            File file = new File(this.filePath);
            Sequence seq = MidiSystem.getSequence(file);
            int res = seq.getResolution();
            List<Track> t = List.of(seq.getTracks());

            setResolution(res);
            setTracks(t);

            System.out.println("Début de l'extraction du fichier MIDI : " + file.getName());
            System.out.println("Extraction de la séquence et de la résolution terminée...");
            System.out.println("Extraction des tracks terminée...");
        } catch (InvalidMidiDataException | IOException e) {
            if (e instanceof InvalidMidiDataException) {
                System.out.println("Erreur lors de la lecture du fichier midi !");
            } else {
                System.out.println("Erreur lors de la lecture du fichier !");
            }
        }
    }
}
