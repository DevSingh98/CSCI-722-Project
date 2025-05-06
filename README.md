# CSCI-722-Project

## Phase-Based Turing Machine and Membership System

This repository contains code for the two major phases of the project for CSCI-722: a Membership Management System (Phase 1) and a Turing Machine Simulator with a Step Counter Predicate (Phase 3).

---

## 📁 Phase 1: Membership Management System

### Overview
A Java-based system to manage member records using a `Hashtable`, allowing for command-line input, duplicate checks, and flexible output options.

### Features
- Read member data from a file.
- Add new members through command-line arguments.
- Prevent duplicate member IDs.
- Write either all members or only the newly added one to an output file.
- Parse arguments in any order with case-insensitivity.

### Prerequisites
- Java Development Kit (JDK) 8 or later.

### Usage

#### Compile
```sh
javac *.java
```

#### Run
```sh
java Membership -inputFile=input.txt -outputFile=output.txt -id=123 -firstname=John -lastname=Doe -age=25 -NewYork=true -printAllMemberships=true
```

### Command-Line Arguments

| Argument               | Description                                                                |
|------------------------|----------------------------------------------------------------------------|
| -inputFile             | Input file with existing member records.                                   |
| -outputFile            | Output file to store new or all members.                                   |
| -id                    | Unique member ID (usually a phone number).                                 |
| -firstname             | First name of the member.                                                  |
| -lastname              | Last name of the member.                                                   |
| -age                   | Age of the member.                                                         |
| -NewYork               | Boolean indicating if the member lives in New York.                        |
| -printAllMemberships   | If true, prints all members; else, only the newly added member.            |

---

## 📁 Phase 3: Turing Machine Simulator with Step Counter Predicate

### Overview
This phase implements a deterministic Turing Machine simulator in Java that:
- Loads a Turing Machine definition from a file.
- Reads an initial tape input.
- Runs up to a user-defined number of steps.
- Outputs whether the machine halted and the final state of the tape.

### Features
- HashTable-based transition table using key `<State><Symbol>`.
- Tape simulation with dynamic indexing.
- CLI flags for flexible configuration.
- Debug mode (Steps=0) to display input file contents.

### Prerequisites
- Java Development Kit (JDK) 8 or later.

### Usage

#### Compile
```sh
javac *.java
```

#### Run
```sh
java Main TransitionsFile=transitions.txt InitialTapeInput=input.txt FinalOutput=output.txt Steps=10
```

### Flags

| Flag              | Description                                                                 |
|-------------------|-----------------------------------------------------------------------------|
| TransitionsFile   | File with state transition rules.                                           |
| InitialTapeInput  | File with the initial tape content.                                         |
| FinalOutput       | File to write final tape and halting status.                                |
| Steps             | Max number of steps to simulate. `Steps=0` triggers debug mode.             |

### Example Transitions (`transitions.txt`)
```txt
0,1,0,R,0
0,0,0,R,1
```

### Example Input (`input.txt`)
```txt
1101
```

### Example Output (`output.txt`)
```txt
Final Tape: 0001
Machine Halted: true
```
