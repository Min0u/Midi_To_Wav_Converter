import Midi.*;
import Wav.FichierWav;
import Wav.Signal;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.util.List;

public class Midi_To_Wav {
    public static void main(String[] args) {
        // Sequence, resolution
        String fileMidi = "C:\\Users\\Admin\\Desktop\\FAC\\UCA\\Licence\\L3\\S1\\PCOO\\TD\\Projet 2\\Fichier Test\\fichier3.mid";
        FichierMidi f = new FichierMidi();
        f.extract(fileMidi);
        Sequence sequence = FichierMidi.getSequence();

        // Midi.Tracks
        Tracks tracks = new Tracks();
        tracks.extract(sequence);
        List<Track> tracksList = Tracks.getTracks();

        // Events
        Event event = new Event();
        event.extract(tracksList);
        List<MidiEvent> events = Event.getEvents();

        // Messages
        Message messages = new Message();
        messages.extract(events);

        // totalTime, Midi.Notes
        float totalTime = FichierMidi.calculTotalTime();
        FichierMidi.setTotalTime(totalTime);

        // Wave.Signal
        Signal s = new Signal();
        int[] signal = s.genererSignal(Notes.getNotes(), FichierMidi.getTotalTime());

        // Wave.FichierWav
        String fileWav = "C:\\Users\\Admin\\Desktop\\FAC\\UCA\\Licence\\L3\\S1\\PCOO\\TD\\Projet 2\\Fichier Test\\fichier3.wav";
        FichierWav.ecrireFichierWav(fileWav, signal);
    }
}