import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeWindow extends JFrame {

    private final JButton[][] buttons = new JButton[3][3];
    private char currentPlayer = 'X';

    public TicTacToeWindow() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new ButtonListener());
                add(buttons[i][j]);
            }
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToeWindow();
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setText(String.valueOf(currentPlayer));
            button.setEnabled(false);
            checkWin();
            checkDraw();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private void checkWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) && buttons[i][1].getText().equals(String.valueOf(currentPlayer)) && buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) && buttons[1][i].getText().equals(String.valueOf(currentPlayer)) && buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                resetGame();
                return;
            }
        }

        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) && buttons[1][1].getText().equals(String.valueOf(currentPlayer)) && buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            resetGame();
            return;
        }
        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) && buttons[1][1].getText().equals(String.valueOf(currentPlayer)) && buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
            resetGame();
            return;
        }
    }

    private void checkDraw() {
        for (int i = 0; i < 3; i++) {
            System.out.println("\n");
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "It's a draw!");

        resetGame();
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }
}
