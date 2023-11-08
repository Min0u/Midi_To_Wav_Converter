package Midi;

import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message implements Extractable {
    // Attributs
    private int tempo;
    private final List<MidiEvent> events;
    private final FichierMidi fichierMidi;
    private final List<NoteJouee> notes;

    // Constructeur
    public Message(FichierMidi fm, List<MidiEvent> e) {
        this.tempo = 0;
        this.fichierMidi = fm;
        this.events = e;
        this.notes = new ArrayList<>();
    }

    // Getters
    public int getTempo() {
        return this.tempo;
    }

    public List<NoteJouee> getNotes() {
        return this.notes;
    }

    // Setters
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    // Méthodes
    @Override
    public void extract() {
        Map<Integer, Long> notesActive = new HashMap<>();

        for (MidiEvent event : this.events) {
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

        NoteJouee noteJouee = new NoteJouee(infos, this.fichierMidi, this);
        add(noteJouee);
    }

    public void mmInfo(MidiMessage message) {
        byte[] msg = message.getMessage();
        if (((msg[1] & 0xFF) == 0x51) && (msg[2] == 0x03)) {
            int mspq = (msg[5] & 0xFF)
                    | ((msg[4] & 0xFF) << 8)
                    | ((msg[3] & 0xFF) << 16);
            int tempo = Math.round(60000001f / mspq);
            int tempoInit = getTempo();
            if (tempoInit != tempo) {
                setTempo(tempo);
            }
        }
    }

    public void add(NoteJouee note) {
        this.notes.add(note);
    }

    public float calculTotalTime() {
        float totalTime = 0;
        for (NoteJouee note : this.getNotes()) {
            totalTime = Math.max(totalTime, note.getTime() + note.getDuration());
        }
        return totalTime;
    }
}
