# Tic Tac Toe

This project is a Java Maven implementation of the classic Tic Tac Toe game.

The application can be played through the console and includes automated tests, GitHub Actions for continuous integration, and a workflow for building and uploading the JAR artifact.

## Features

- 3x3 Tic Tac Toe board
- Two players: X and O
- Move validation
- Detection of horizontal, vertical and diagonal wins
- Draw detection
- Rejection of further moves after the game has ended
- Option to start a new game after win or draw
- Console-based user interaction

## Project Structure

```text
tictactoe/
├── src/
│   ├── main/java/at/fhtechnikum/tictactoe/
│   │   ├── Board.java
│   │   ├── Game.java
│   │   ├── Main.java
│   │   └── Player.java
│   └── test/java/at/fhtechnikum/tictactoe/
│       ├── BoardTest.java
│       ├── BoardPrintTest.java
│       ├── DrawTest.java
│       ├── GameEndTest.java
│       ├── GameLogicTest.java
│       ├── MainConsoleTest.java
│       ├── PlayerTest.java
│       ├── RestartTest.java
│       └── WinnerTest.java
├── pom.xml
└── README.md
```

## Requirements

- Java 25
- Maven

## Run Tests

From the repository root:

```bash
cd tictactoe
mvn test
```

The project contains automated JUnit tests covering positive and negative cases for board behavior, player validation, game logic, winner detection, draw detection, restart behavior and console input handling.

## Build JAR

From the repository root:

```bash
cd tictactoe
mvn package
```

The generated JAR file is created in:

```text
tictactoe/target/
```

## DevOps Workflow

The project uses a Kanban board to manage user stories and tasks.

Development is done on feature branches using the naming pattern:

```text
feature/...
```

All changes are merged into `main` through pull requests.

## Continuous Integration

GitHub Actions is used to run tests automatically.

On every push to a feature branch, the CI workflow runs:

```bash
mvn test
```

This ensures that the automated test suite is executed before changes are merged.

## JAR Artifact Upload

When changes are merged into `main`, GitHub Actions builds the project with:

```bash
mvn package
```

The generated JAR file is uploaded as a GitHub Actions artifact named:

```text
tictactoe-jar
```

The artifact can be found in GitHub under:

```text
Actions → Build and Upload JAR → latest successful main run → Artifacts
```