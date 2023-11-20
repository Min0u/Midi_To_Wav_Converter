package Midi;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

public class Event implements Extractable {
    // Attributs
    private final List<MidiEvent> events;
    private final FichierMidi fichierMidi;

    // Constructeur
    public Event(FichierMidi fm) {
        this.fichierMidi = fm;
        this.events = new ArrayList<>();
    }

    // Getters
    public List<MidiEvent> getEvents() {
        return this.events;
    }

    // Méthodes
    @Override
    public void extract() {
        for (Track track : this.fichierMidi.getTracks()) {
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                this.events.add(event);
            }
        }
        System.out.println("Extraction des Events terminé...");
    }
}
