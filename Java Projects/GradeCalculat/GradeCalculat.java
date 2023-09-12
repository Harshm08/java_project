import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculat extends JFrame {
    JLabel[] subjectLabels;
    JTextField[] marksFields;
    JButton calculateButton;
    JTextArea resultArea;

    public GradeCalculat() {

        JFrame frame = new JFrame();
        frame.setBackground(new Color(7, 97, 101));
        JLabel titleLabel = new JLabel("Enter Students Marks under 100");
        titleLabel.setBackground(new Color(7, 97, 101));
        add(titleLabel, BorderLayout.CENTER);

        setTitle("Grade Calculator");
        setSize(400, 350);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        int numSubjects = 5; // You can change this according to your needs
        subjectLabels = new JLabel[numSubjects];
        marksFields = new JTextField[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            subjectLabels[i] = new JLabel("Subject " + (i + 1) + " Marks:");
            marksFields[i] = new JTextField();
            add(subjectLabels[i]);
            add(marksFields[i]);
        }

        calculateButton = new JButton("Calculate");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(188, 165, 217));

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndDisplayResults();
            }
        });

        add(calculateButton);
        add(resultArea);
        add(titleLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void calculateAndDisplayResults() {
        int totalMarks = 0;
        int numSubjects = marksFields.length;

        for (int i = 0; i < numSubjects; i++) {
            int marks = Integer.parseInt(marksFields[i].getText());
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / (numSubjects * 100);
        String grade = calculateGrade(averagePercentage);

        String resultText = "Total Marks: " + totalMarks + "\n"
                + "Average Percentage: " + (averagePercentage * 100) + "%\n"
                + "Grade: " + grade;

        resultArea.setText(resultText);
    }

    private String calculateGrade(double averagePercentage) {

        // GradeCalculatorApp gd = new GradeCalculatorApp();

        if (averagePercentage >= 0.9) {
            return "A";
        } else if (averagePercentage >= 0.75) {
            return "B";
        } else if (averagePercentage >= 0.66) {
            return "C";
        } else if (averagePercentage >= 0.48) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeCalculat();
            }
        });
    }
}
