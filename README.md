# MIDI to WAV Converter

Ce projet Java vous permet de convertir des fichiers MIDI en fichiers WAV. Il utilise Java Sound API pour extraire les données MIDI, les traiter et générer un fichier audio WAV.

## Prérequis

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html) - Assurez-vous d'avoir installé JDK sur votre système.
- **Bibliothèques MIDI et WAV** - Assurez-vous d'avoir les bibliothèques nécessaires pour le traitement MIDI et WAV dans votre projet.

## Comment Utiliser

1. **Téléchargez le Projet**

   Vous pouvez télécharger le projet sous forme de fichier ZIP en cliquant sur le bouton "Code" en haut à droite de cette page, puis en sélectionnant "Download ZIP". Extrayez ensuite le fichier ZIP sur votre ordinateur.

2. **Compilez le Projet**

   Assurez-vous d'avoir les bibliothèques nécessaires dans votre classpath. Compilez le projet à l'aide de votre environnement de développement Java préféré.

3. **Exécutez le Programme**

   Utilisez votre environnement de développement Java ou exécutez le programme via la ligne de commande :

   ```bash
   java Midi_To_Wav

4. Configurer les Fichiers d'Entrée et de Sortie

   Modifiez le chemin du fichier MIDI d'entrée et du fichier WAV de sortie dans la classe Midi_To_Wav.java avant d'exécuter le programme.

5. Vérifiez le Fichier de Sortie

   Après l'exécution réussie, le fichier WAV converti sera généré dans le dossier spécifié.

## Structure du Projet
+ Midi/ - Package contenant les classes liées au traitement MIDI.
+ Wav/ - Package contenant les classes liées à la génération de fichiers WAV.
+ Midi_To_Wav.java - Classe principale pour exécuter la conversion.
