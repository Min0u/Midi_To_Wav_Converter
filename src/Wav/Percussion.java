package Wav;

import Midi.Notes;

import java.util.Random;

public class Percussion implements Instrument {
    // Attributs
    private static final Random random = new Random();
    private static int[] signal;

    // Getters
    public static int[] getSignal() {
        return signal;
    }

    // Setters
    public static void setSignal(int[] nv_signal) {
        signal = nv_signal;
    }

    // Méthodes
    @Override
    public void jouerSignal(Notes note) {
        float duration = note.getDuration();
        int[] nv_signal = new int[(int) (44100 * duration)];

        for (int i = 0; i < nv_signal.length; i++) {
            nv_signal[i] = random.nextInt(-128, 128);
        }

        setSignal(nv_signal);
    }
}
