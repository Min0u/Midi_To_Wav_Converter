public enum Note {
    DO(261.626f), DO_DIESE(277.183f), RE(293.665f), RE_DIESE(311.127f), MI(329.628f), FA(349.228f), FA_DIESE(369.994f), SOL(391.995f), SOL_DIESE(415.305f), LA(440.000f), LA_DIESE(466.164f), SI(493.883f);

    private float frequence_ref;
    private int octave;

    Note (float frequence) {
        this.frequence_ref = frequence;
        this.octave = 4;
    }

    public float getNoteFrequence(int octave) {
        return frequence_ref * (float) Math.pow(2, octave - 4);
    }
}
