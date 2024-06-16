# MIDI to WAV Converter

This project offers a Java converter to convert MIDI files to WAV files. It is based on the `Midi` and `Wav` packages which contain classes for MIDI data extraction, message processing, note generation, and WAV file creation.

## Project Structure

The project is organized into several packages:

- **Midi**: Contains classes related to MIDI file extraction and processing.
- **Wav**: Contains classes responsible for WAV file generation.
- **To**: Contains the `MidiToWav` class which orchestrates MIDI to WAV conversion.

## How to Use

### Prerequisites

Before you begin, make sure you have the **Java Development Kit (JDK)** installed on your machine. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html).

### Compiling and Running the Project

1. **Download the Project**

   Clone or download this repository to your machine.

2. **Compile the Project**

   Open a terminal or command prompt. Navigate to the root directory of the project and compile the Java source files.

3. **Run the Program**

   Stay in the same directory where the compiled files (*.class) are located and execute the main program file.

4. **Converting MIDI to WAV Files**

   To convert a MIDI file to WAV, use the `MidiToWav` class from the `To` package. Call the static `convert` method, passing the input MIDI file path and the output WAV file path.

**Note**: This project works with MIDI files that follow a format similar to the MIDI files in the `Test Files` folder provided in this repository. Ensure that the MIDI file you wish to convert is structured in a compatible manner with this program to ensure successful conversion.
