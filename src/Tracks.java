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

    // Méthodes
    @Override
    public void extract(Sequence sequence) {
        tracks = List.of(sequence.getTracks());
    }
}
