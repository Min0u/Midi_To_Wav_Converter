package Wav;

import Midi.Notes;

import java.util.List;

public class Signal {
    // Attributs
    private static final int sampleRate = 44100;

    // Méthodes
    public static int[] signalPercussion(){
        return Percussion.getSignal();
    }

    public static int[] signalAutreInstrument(){
        return AutreInstrument.getSignal();
    }

    public int[] genererSignal(List<Notes> notes, float totalTime) {
        int[] nv_signal = new int[(int)(sampleRate * totalTime)];
        Percussion p = new Percussion();
        AutreInstrument ai = new AutreInstrument();

        for (Notes note : notes) {
            int channel = note.getChannel();
            int[] signalNote;
            if (channel == 9) {
                // Wave.Percussion
                p.jouerSignal(note);
                signalNote = signalPercussion();
            } else {
                // Autre instrument
                ai.jouerSignal(note);
                signalNote = signalAutreInstrument();
            }

            int debutNote = (int) (note.getTime() * sampleRate);
            for (int i = 0; i < signalNote.length; i++) {
                nv_signal[debutNote + i] = Math.max(-128, Math.min(127, nv_signal[debutNote + i] + signalNote[i] * note.getVolume() / 127));
            }
        }

        return nv_signal;
    }
}