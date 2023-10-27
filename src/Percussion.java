import java.util.Random;

public class Percussion implements Instrument {
    // Attributs
    private static int[] signal;

    // Getters
    public static int[] getSignal() {
        return signal;
    }

    // Méthodes
    @Override
    public void jouerSignal(Notes note) {
        float duration = note.getDuration();
        int volume = note.getVolume();
        int[] nv_signal = new int[(int) (44100 * duration)];
        Random random = new Random();

        for (int i = 0; i < nv_signal.length; i++) {
            nv_signal[i] = random.nextInt(-128, 128);
        }

        signal = nv_signal;
    }
}
