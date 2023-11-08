package Wav;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class FichierWav {
    // Constructeur
    private FichierWav() {
    }

    // Méthodes
    public static byte[] convertirEnOctets(int[] signal) {
        int n = signal.length;
        byte[] bytes = new byte[n * 4]; // Chaque entier est de 4 octets

        for (int i = 0; i < n; i++) {
            int entier = signal[i];

            bytes[i * 4] = (byte) (entier >> 24);
            bytes[i * 4 + 1] = (byte) (entier >> 16);
            bytes[i * 4 + 2] = (byte) (entier >> 8);
            bytes[i * 4 + 3] = (byte) entier;
        }

        return bytes;
    }

    public static void ecrireFichierWav(String nomFichier, int[] signal) {
        try {
            AudioFormat format = new AudioFormat(44100, 8, 1, true, true);
            byte[] b = convertirEnOctets(signal);
            AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(b), format, b.length);
            File file = new File(nomFichier);
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, file);
            System.out.println("Fichier WAV enregistré avec succès : " + file.getName() + "\n");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier");
        }
    }
}
