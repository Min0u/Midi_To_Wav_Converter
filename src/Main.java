import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sequence, resolution
        String filePath = "C:\\Users\\Admin\\Desktop\\FAC\\UCA\\Licence\\L3\\S1\\PCOO\\TD\\Projet 2\\Fichier Test\\fichier3.mid";
        FichierMidi fichierMidi = new FichierMidi(filePath);
        Sequence sequence = FichierMidi.getSequence();
        long resolution = FichierMidi.getResolution();

        System.out.println("Sequence: " + sequence);
        System.out.println("Resolution: " + resolution);

        // Tracks
        Tracks tracks = new Tracks();
        tracks.extract(sequence);
        List<Track> tracksList = Tracks.getTracks();

        System.out.println("Tracks: " + tracksList);

        // Events
        Event event = new Event();
        event.extract(tracksList);
        List<MidiEvent> events = Event.getEvents();

        System.out.println("Events: " + events);

        // Messages
        Message messages = new Message();
        messages.extract(events);

        // totalTime, Notes
        List<Notes> notes = Notes.getNotes();
        float totalTime = FichierMidi.calculTotalTime();
        FichierMidi.setTotalTime(totalTime);

        System.out.println("Notes: " + notes);

        // Signal
        Signal s = new Signal();
        int[] signal = s.genererSignal(Notes.getNotes(), FichierMidi.getTotalTime());

        // FichierWav
        String filePathWav = "C:\\Users\\Admin\\Desktop\\FAC\\UCA\\Licence\\L3\\S1\\PCOO\\TD\\Projet 2\\Fichier Test\\fichier3.wav";
        FichierWav.ecrireFichierWav(filePathWav, signal);
    }
}