import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message implements Extractable<List<MidiEvent>> {
    // Méthodes
    @Override
    public void extract(List<MidiEvent> events) {
        List<ShortMessage> shortMessages = new ArrayList<>();
        Map<Integer, Long> activeNotes = new HashMap<>();

        // Set Tempo
        for (MidiEvent event : events) {
            MidiMessage message = event.getMessage();
            if (message instanceof ShortMessage shortMessage) {
                int key = shortMessage.getData1();
                if (shortMessage.getCommand() == ShortMessage.NOTE_ON) {
                    activeNotes.put(key, event.getTick());
                } else if (shortMessage.getCommand() == ShortMessage.NOTE_OFF) {
                    Long start = activeNotes.remove(key);

                    if (start!= null) {
                        smInfo(shortMessage, start, event.getTick());
                    }
                }
            } else if (message instanceof MetaMessage) {
                mmInfo(message);
            }
        }
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
        Notes notes = new Notes(channel, key, octave, volume, frequence, note, command, start, end);
        Notes.add(notes);
    }


    public void mmInfo(MidiMessage message) {
        byte[] msg = message.getMessage(); // Le contenu du message
        if (((msg[1] & 0xFF) == 0x51) && (msg[2] == 0x03)) {
            int mspq = (msg[5] & 0xFF)
                    | ((msg[4] & 0xFF) << 8)
                    | ((msg[3] & 0xFF) << 16);
            int tempo = Math.round(60000001f / mspq); // Le tempo est calculé
            int tempoInit = FichierMidi.getTempo();
            if (tempoInit != tempo) {
                FichierMidi.setTempo(tempo);
            }
        }
    }
}
