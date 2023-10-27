import javax.sound.midi.MidiEvent;
import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

public class Event implements Extractable<List<Track>> {
    // Attributs
    private static List<MidiEvent> events = new ArrayList<>();

    // Getters
    public static List<MidiEvent> getEvents() {
        return events;
    }

    // Méthodes
    @Override
    public void extract(List<Track> tracks) {
        for (Track track : tracks) {
            for (int i = 0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                events.add(event);
            }
        }
    }
}
