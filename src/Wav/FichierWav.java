package Wav;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class FichierWav {
    // Constructeur
    private FichierWav() {
        throw new IllegalStateException("Utility class");
    }

    // Méthodes
    private static byte[] convertirEnOctets(int[] wave) {
        ByteBuffer bb = ByteBuffer.allocate(wave.length * 4);
        for (int w : wave) {
            bb.putInt(w);
        }
        return bb.array();
    }

    public static void ecrireFichierWav(String nomFichier, int[] signal) {
        try {
            AudioFormat format = new AudioFormat(44100, 8, 1, true, true);
            byte[] octets = convertirEnOctets(signal);
            AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(octets), format, octets.length);
            File file = new File(nomFichier);
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, file);
            System.out.println("Fichier WAV enregistré avec succès : " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
