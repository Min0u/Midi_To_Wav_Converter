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
        String fileMidi = "Chemin\\Vers\\Fichier\\Midi"; // Remplacez "Chemin\\Vers\\Fichier\\Midi" par le chemin votre fichier Midi.
        FichierMidi f = new FichierMidi();
        f.extract(fileMidi);
        Sequence sequence = FichierMidi.getSequence();

        // Tracks
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

        // totalTime, Notes
        float totalTime = FichierMidi.calculTotalTime();
        FichierMidi.setTotalTime(totalTime);

        // Signal
        Signal s = new Signal();
        int[] signal = s.genererSignal(Notes.getNotes(), FichierMidi.getTotalTime());

        // FichierWav
        String fileWav = "Chemin\\Vers\\Fichier\\Wav"; // Remplacez "Chemin\\Vers\\Fichier\\Midi" par le chemin votre fichier Wav.
        FichierWav.ecrireFichierWav(fileWav, signal);
    }
}
