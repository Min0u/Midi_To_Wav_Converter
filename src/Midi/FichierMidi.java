package Midi;

import javax.sound.midi.*;
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
    private final List<MidiEvent> events;

    // Constructeur
    public FichierMidi(String filePath){
        this.filePath = filePath;
        this.tracks = new ArrayList<>();
        this.events = new ArrayList<>();
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

    public List<MidiEvent> getEvents() {
        return this.events;
    }

    //  Setters
    public void setTotalTime(float nv_totalTime) {
        this.totalTime = nv_totalTime;
    }

    //  Méthodes
    @Override
    public void extract() {
        try {
            File file = new File(this.filePath);
            Sequence seq = MidiSystem.getSequence(file);
            int res = seq.getResolution();
            List<Track> t = List.of(seq.getTracks());
            for (Track track : t) {
                for (int i = 0; i < track.size(); i++) {
                    MidiEvent event = track.get(i);
                    this.events.add(event);
                }
            }

            this.resolution = res;
            this.tracks = t;

            System.out.println("Extraction des Events terminé...");
            System.out.println("Début de l'extraction du fichier MIDI : " + file.getName());
            System.out.println("Extraction de la séquence et de la résolution terminée...");
            System.out.println("Extraction des tracks terminée...");
        } catch (InvalidMidiDataException e) {
            System.out.println("Erreur lors de la lecture du fichier midi !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier !");
        }
    }
}
