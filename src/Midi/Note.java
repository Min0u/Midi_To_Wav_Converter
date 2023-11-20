package Midi;

public enum Note {
    // Notes
    DO(261.626f), DO_DIESE(277.183f), RE(293.665f), RE_DIESE(311.127f), MI(329.628f), FA(349.228f), FA_DIESE(369.994f), SOL(391.995f), SOL_DIESE(415.305f), LA(440.000f), LA_DIESE(466.164f), SI(493.883f);

    // Attributs
    private final float frequence_ref;

    // Constructeur
    Note (float frequence) {
        this.frequence_ref = frequence;
    }

    // Getters
    public float getNoteFrequence(int nv_octave) {
        int octave = 4;
        int diff = nv_octave - octave;
        return frequence_ref * (float) Math.pow(2, diff);
    }
}
