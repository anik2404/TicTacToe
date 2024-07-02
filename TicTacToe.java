import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToe extends JFrame {

    private JButton[][] buttons = new JButton[3][3];
    private boolean isXTurn = true;

    public TicTacToe() {
        super("Tic Tac Toe");
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.addActionListener(new ButtonListener());
                add(button);
                buttons[i][j] = button;
            }
        }
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                if (isXTurn) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
                isXTurn = !isXTurn;
                checkForWin();
            }
        }
    }

    private void checkForWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Player " + buttons[i][0].getText() + " wins!");
                System.exit(0);
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Player " + buttons[0][i].getText() + " wins!");
                System.exit(0);
            }
        }
        // Check diagonals
        if ((buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().isEmpty()) ||
                (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Player " + buttons[1][1].getText() + " wins!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}