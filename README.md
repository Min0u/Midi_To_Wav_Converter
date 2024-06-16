# MIDI to WAV Converter

This project provides a Java-based converter for converting MIDI files to WAV files. It is built upon the `Midi` and `Wav` packages which contain classes for MIDI data extraction, message processing, note generation, and WAV file creation.

## Project Structure

The project is organized into several packages:

- **Midi**: Contains classes related to MIDI file extraction and processing.
- **Wav**: Contains classes responsible for WAV file generation.
- **To**: Contains the `MidiToWav` class which orchestrates the MIDI to WAV conversion.

## How to Use

### Prerequisites

Before you begin, ensure you have installed the **Java Development Kit (JDK)** on your machine. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html).

### Compilation and Execution of the Project

1. **Download the Project**

   Clone or download this repository to your machine.

2. **Compile the Project**

   Open a terminal or command prompt. Navigate to the root directory of the project and compile the Java source files.

   ```bash
   javac path/to/your/project/*.java
   ```

3. **Execute the Program**

   Stay in the same directory as the compiled files (*.class) and execute the main program file.

   ```bash
   java path.to.your.project.Main
   ```

4. **Converting MIDI to WAV Files**

   To convert a MIDI file to WAV, use the `MidiToWav` class from the `To` package. Call the static `convert` method, passing in the input MIDI file path and the output WAV file path.

   ```java
   MidiToWav.convert("input.mid", "output.wav");
   ```

**Note**: This project works with MIDI files that follow a format similar to those in the `Test Files` directory provided in this repository. Ensure that the MIDI file you intend to convert is structured compatibly with this program to ensure successful conversion.
