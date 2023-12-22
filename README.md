# MIDI to WAV Converter

Ce projet propose un convertisseur Java permettant de convertir des fichiers MIDI en fichiers WAV. Il est basé sur les packages `Midi` et `Wav` qui contiennent des classes pour l'extraction des données MIDI, le traitement des messages, la génération des notes et la création des fichiers WAV.

## Structure du Projet

Le projet est organisé en plusieurs packages :

- **Midi**: Contient les classes liées à l'extraction et au traitement des fichiers MIDI.
- **Wav**: Contient les classes responsables de la génération des fichiers WAV.
- **To**: Contient la classe `MidiToWav` qui orchestre la conversion MIDI vers WAV.
  
## Comment Utiliser

### Prérequis

Avant de commencer, assurez-vous d'avoir installé le **Java Development Kit (JDK)** sur votre machine. Vous pouvez le télécharger depuis [le site officiel d'Oracle](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html).

### Compilation et Exécution du Projet

1. **Téléchargez le Projet**

   Clonez ou téléchargez ce dépôt sur votre machine.

2. **Compilez le Projet**

   Ouvrez un terminal ou une invite de commande. Accédez au répertoire racine du projet et compilez les fichiers source Java.

3. **Exécutez le Programme**

   Restez dans le même répertoire que les fichiers compilés (*.class) et exécutez le fichier principal du programme.


5. **Conversion de Fichiers MIDI en WAV**

   Pour convertir un fichier MIDI en WAV, utilisez la classe MidiToWav du package To. Vous pouvez appeler la méthode statique convert en passant le chemin du fichier MIDI en entrée et le chemin du fichier WAV en sortie.

**Note** : Ce projet fonctionne avec des fichiers MIDI qui suivent un format similaire aux fichiers MIDI du dossier `Fichier Test` fourni dans ce dépôt. Assurez-vous que le fichier MIDI que vous souhaitez convertir est structuré de                 manière compatible avec ce programme pour garantir une conversion réussie.
