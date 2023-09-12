import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGameSwing extends JFrame {

     int targetNumber;
     int attemptsLeft;
     int roundsWon;

    
     JLabel feedbackLabel;
     JTextField guessTextField;
     JButton submitButton;
     JButton playAgainButton;

    public GuessingGameSwing() {
 
       JFrame frame = new JFrame();


       setTitle("NumberGuessing Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        feedbackLabel = new JLabel("----------Guess the number between 1 and 100----------");
        add(feedbackLabel);

        guessTextField = new JTextField(10);
        setBackground(Color.green);
        add(guessTextField);
        //setSize(700,1200);


        submitButton = new JButton("Submit Number");
        add(submitButton);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setEnabled(false);
        playAgainButton.setSize(400, 300);
        add(playAgainButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userGuess = Integer.parseInt(guessTextField.getText());
                checkGuess(userGuess);
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewRound();
            }
        });

        startNewRound();
        pack();
        setLocationRelativeTo(null);
    }

    private void startNewRound() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        attemptsLeft = 10;

        feedbackLabel.setText("----------Guess the number between One to Hundrad----------");
        
        guessTextField.setText("");
        submitButton.setEnabled(true);
        playAgainButton.setEnabled(false);
    }

    private void checkGuess(int guess) {
        attemptsLeft--;

        if (guess == targetNumber) {
            feedbackLabel.setText("Congratulations! you wins Game");
            roundsWon++;
            submitButton.setEnabled(false);
            playAgainButton.setEnabled(true);
        } else if (guess < targetNumber) {
            feedbackLabel.setText("Too low! Attempts left: " + attemptsLeft);
        } else {
            feedbackLabel.setText("Too high! Attempts left: " + attemptsLeft);
        }

        if (attemptsLeft == 0) {
            feedbackLabel.setText("Empty attempts. Genrate number is: " + targetNumber);
            submitButton.setEnabled(false);
            playAgainButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuessingGameSwing game = new GuessingGameSwing();
            game.setVisible(true);
        });
    }
}
