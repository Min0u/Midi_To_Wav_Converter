package To;

import Midi.Event;
import Midi.FichierMidi;
import Midi.Message;
import Midi.NoteJouee;
import Wav.FichierWav;
import Wav.Signal;

public class MidiToWav {

    private MidiToWav() {
    }

    public static void convert(String MidiFile, String WavFile) {
        // Sequence, resolution
        FichierMidi f = new FichierMidi(MidiFile);

        // Messages
        Message messages = new Message(f);
        messages.extract();

        // totalTime, Notes
        float totalTime = messages.calculTotalTime();
        f.setTotalTime(totalTime);

        // Signal
        Signal s = new Signal();
        int[] signal = s.genererSignal(messages.getNotes(), f.getTotalTime());

        // FichierWav
        FichierWav.ecrireFichierWav(WavFile, signal);
    }
}
