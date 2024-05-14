// Tic Tac Toe is fun!!! WIEE HEEEEE :>> Name: Carylle Hope A. Toyogon

import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends Frame implements ActionListener {
    private Button[] buttons = new Button[9];
    private boolean xTurn = true;
    private Label statusLabel = new Label("Player X's turn", Label.CENTER);
    private Button newGameButton = new Button("New Game");

    public TicTacToe() {
        
        // Set background color for the window
        setBackground(Color.decode("#7469B6"));
        setLayout(new BorderLayout());

        // Panel for the Tic Tac Toe grid
        Panel gridPanel = new Panel();
        gridPanel.setLayout(new GridLayout(3, 3));
        
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            buttons[i].setBackground(Color.decode("#AD88C6"));
            buttons[i].addActionListener(this);
            gridPanel.add(buttons[i]);
        }

        // Panel for the status and new game button
        Panel controlPanel = new Panel();
        controlPanel.setLayout(new BorderLayout());

        // Style the status label
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setForeground(Color.WHITE);
        controlPanel.add(statusLabel, BorderLayout.CENTER);

        // Style the new game button
        newGameButton.setFont(new Font("Arial", Font.BOLD, 20));
        newGameButton.setBackground(Color.decode("#AD88C6"));
        newGameButton.setPreferredSize(new Dimension(200, 50));
        
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
        
        controlPanel.add(newGameButton, BorderLayout.EAST);

        // Add panels to the frame
        add(gridPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Frame settings
        setTitle("Tic Tac Toe");
        setSize(600, 600);
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }


    @Override

    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        
        if (!clickedButton.getLabel().equals("")) {
            return; // Button already clicked
        }
        
        if (xTurn) {
            clickedButton.setLabel("X");
            statusLabel.setText("Player O's turn");
        } 
        
        else {
            clickedButton.setLabel("O");
            statusLabel.setText("Player X's turn");
        }
       
        xTurn = !xTurn;

        String winner = checkWinner();
        
        if (winner != null) {
            statusLabel.setText("Player " + winner + " wins!");
            disableButtons();
        } 
        
        else if (isBoardFull()) {
            statusLabel.setText("It's a draw!");
        }
    }

    private String checkWinner() {
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] pattern : winPatterns) {
            String b1 = buttons[pattern[0]].getLabel();
            String b2 = buttons[pattern[1]].getLabel();
            String b3 = buttons[pattern[2]].getLabel();
            if (!b1.equals("") && b1.equals(b2) && b2.equals(b3)) {
                return b1;
            }
        }
        return null;
    }

    private boolean isBoardFull() {
        for (Button button : buttons) {
            if (button.getLabel().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        for (Button button : buttons) {
            button.setLabel("");
            button.setEnabled(true);
        }
        xTurn = true;
        statusLabel.setText("Player X's turn");
    }

    private void disableButtons() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
