# Tic Tac Toe Game

## Overview
This is a simple desktop Tic Tac Toe game built using Java's Abstract Window Toolkit (AWT). The game allows two players to take turns clicking on a grid to place their X or O. The application checks for a winner after each turn and provides an option to start a new game.

## Features
- **Tic Tac Toe Grid**: A 3x3 grid where players can place X or O.
- **Player Turns**: The game alternates turns between Player X and Player O, displaying whose turn it is.
- **Check Winner**: The game checks for a winner after each turn and displays the result. If there is no winner and the grid is full, it declares a draw.
- **Reset Game**: A "New Game" button allows players to reset the grid and start over.
- **Visual Enhancements**: 
  - The background color of the window is set to `#7469B6`.
  - The background color of the buttons is set to `#AD88C6`.
  - The status message is clearly visible with a large, bold font.
  - The "New Game" button is big and easy to spot.

## Technical Requirements
- Java Development Kit (JDK) installed on your computer.

## How to Run
1. **Compile the Java file**:
   Open a terminal or command prompt and navigate to the directory containing `TicTacToe.java`. Run the following command to compile the Java file:
   ```sh
   javac TicTacToe.java
