package Midi;

import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message implements Extractable<List<MidiEvent>> {
    // Méthodes
    @Override
    public void extract(List<MidiEvent> events) {
        Map<Integer, Long> notesActive = new HashMap<>();

        for (MidiEvent event : events) {
            MidiMessage message = event.getMessage();
            if (message instanceof ShortMessage shortMessage) {
                int key = shortMessage.getData1();
                if (shortMessage.getCommand() == ShortMessage.NOTE_ON) {
                    // on ajoute la note à la liste des notes actives
                    notesActive.put(key, event.getTick());
                } else if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
                    // on récupère le début de la note
                    Long start = notesActive.remove(key);

                    // si la note est active, on l'ajoute à la liste des notes sinon, on ne fait rien
                    if (start!= null) {
                        smInfo(shortMessage, start, event.getTick());
                    }
                }
            } else if (message instanceof MetaMessage) {
                mmInfo(message);
            }
        }
        System.out.println("Extraction des Messages et des Notes terminé...");
    }

    public void smInfo(ShortMessage sm, long start, long end) {
        int channel = sm.getChannel();
        int command = sm.getCommand();
        int key = sm.getData1();
        int volume = sm.getData2();

        int note = key % 12;
        int octave = (key / 12) - 1;
        Note n = Note.values()[note];
        float frequence = n.getNoteFrequence(octave);
        Object[] infos = {channel, key, octave, volume, frequence, note, command, start, end};

        Notes notes = new Notes(infos);
        Notes.add(notes);
    }


    public void mmInfo(MidiMessage message) {
        byte[] msg = message.getMessage();
        if (((msg[1] & 0xFF) == 0x51) && (msg[2] == 0x03)) {
            int mspq = (msg[5] & 0xFF)
                    | ((msg[4] & 0xFF) << 8)
                    | ((msg[3] & 0xFF) << 16);
            int tempo = Math.round(60000001f / mspq);
            int tempoInit = FichierMidi.getTempo();
            if (tempoInit != tempo) {
                FichierMidi.setTempo(tempo);
            }
        }
    }
}
