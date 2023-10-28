# MIDI to WAV Converter

Ce dépôt présente un convertisseur de fichiers MIDI en fichiers WAV, développé en Java en utilisant Java Sound API. Ce programme permet d'extraire les données MIDI, de les traiter et de générer des fichiers audio WAV.

## Structure du Projet

Le projet est organisé en packages, à l'exception du fichier `Midi_To_Wav.java` qui contient le point d'entrée "main" et qui se trouve dans le répertoire principal :

- **Midi** : Contient les classes liées au traitement MIDI, y compris l'extraction de séquences, de pistes et d'événements MIDI.
- **Wav** : Contient les classes liées à la génération de fichiers audio WAV, y compris la conversion des données MIDI en signal audio.
- **Midi_To_Wav.java** : Classe principale pour exécuter la conversion MIDI vers WAV.

## Comment Utiliser

### Prérequis

Avant de commencer, assurez-vous d'avoir installé le **Java Development Kit (JDK)** sur votre machine. Vous pouvez le télécharger depuis [le site officiel d'Oracle](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html).

### Compilation et Exécution du Projet

1. **Téléchargez le Projet**

   Clonez ou téléchargez ce dépôt sur votre machine.

2. **Compilez le Projet**

   Ouvrez un terminal ou une invite de commande. Accédez au répertoire racine du projet et compilez les fichiers source Java :

   ```sh
   javac chemin/vers/les/fichiers/*.java
   ```

   Remplacez chemin/vers/les/fichiers/ par le chemin vers les fichiers source Java dans votre système.

3. **Exécutez le Programme**

   Restez dans le même répertoire que les fichiers compilés (*.class) et exécutez le fichier principal du programme :

   ```sh
   java -cp chemin/vers/les/classes Midi_To_Wav
   ```

   Remplacez chemin/vers/les/classes/ par le chemin vers les fichiers compilés.

5. **Configurer les Fichiers d'Entrée et de Sortie**

   Avant d'exécuter le programme, modifiez le chemin du fichier MIDI d'entrée et du fichier WAV de sortie dans la classe Midi_To_Wav.java.
6. **Vérifiez le Fichier de Sortie**

   Après l'exécution réussie, le fichier WAV converti sera généré dans le dossier spécifié.
