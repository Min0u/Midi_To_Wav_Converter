package Midi;

import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.util.List;

public class Tracks implements Extractable<Sequence> {
    // Attributs
    private static List<Track> tracks;

    // Getters
    public static List<Track> getTracks() {
        return tracks;
    }

    // Setters
    public static void setTracks(List<Track> nv_tracks) {
        tracks = nv_tracks;
    }

    // Méthodes
    @Override
    public void extract(Sequence sequence) {
        setTracks(List.of(sequence.getTracks()));
        System.out.println("Extracted des Tracks terminé...");
    }
}
