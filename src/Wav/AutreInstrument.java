package Wav;

import Midi.Notes;

public class AutreInstrument implements Instrument {
    // Attributs
    private static int[] signal;

    // Getters
    public static int[] getSignal() {
        return signal;
    }

    public static void setSignal(int[] nv_signal) {
        signal = nv_signal;
    }

    // Methodes
    @Override
    public void jouerSignal(Notes note) {
        float duration = note.getDuration();
        float frequence = note.getFrequence();
        int[] nv_signal = new int[(int) (44100 * duration)];

        for (int i = 0; i < nv_signal.length; i++) {
            if ((4 * i % (44100f / frequence)) > 22050f / frequence) {
                nv_signal[i] = 127;
            } else {
                nv_signal[i] = -128;
            }
        }

        setSignal(nv_signal);
    }
}