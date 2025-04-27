# Tic Tac Toe (Java Console Game)

This is a simple command-line based Tic Tac Toe game written in Java. The game allows a human player to play against an AI player (with random moves). It's a turn-based 3x3 board game where the goal is to get three of your marks in a row—vertically, horizontally, or diagonally.

## Features

- Two players: Human vs AI
- Console-based user interface
- AI selects random valid moves
- Detects win by row, column, or diagonal
- Detects tie when the board is full

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/tic-tac-toe-java.git
   cd tic-tac-toe-java
2. **Compile the Code**
    ```bash
    javac LounchGame.java
3. **Run the Game**
    ```bash
    java LounchGame

## Project Structure

- **TicTacToe**: Contains the board, utility functions, and win/tie checks.
- **Player**: Abstract base class for both Human and AI players.
- **HumanPlayer**: Allows human input through the console.
- **AIPlayer**: Generates random valid moves for the computer.
- **LounchGame**: Main class to launch and run the game loop.

## Requirements

- Java 8 or higher