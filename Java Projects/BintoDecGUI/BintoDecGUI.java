import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BintoDecGUI extends JFrame implements ActionListener {
    private JTextField binaryField;
    private JLabel resultLabel;

    public BintoDecGUI() {
        setTitle("Binary to Decimal Converter");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(2,92,68)); 

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Binary to Decimal Converter");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);

        JLabel binaryInputLabel = new JLabel("Enter Binary Number:");
        binaryInputLabel.setFont(new Font("Comic Sans MS",Font.BOLD,16));
        binaryInputLabel.setForeground(new Color(5, 41, 48));
        binaryField = new JTextField(20);
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        convertButton.setBackground(new Color(17,0,114));

        inputPanel.setBackground(new Color(255,241,223));
        inputPanel.add(binaryInputLabel);
        inputPanel.add(binaryField);
        inputPanel.add(convertButton);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel("Decimal Result: ");
        resultLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        resultLabel.setForeground(Color.BLACK);
        resultLabel.setBackground(new Color(190,69,21));

        resultPanel.setBackground(new Color(190,69,21));
        resultPanel.add(resultLabel);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(Color.decode("#42A5F5")); // Material Blue 300
        add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Convert")) {
            try {
                String binaryInput = binaryField.getText();
                int decimalResult = Integer.parseInt(binaryInput, 2);
                resultLabel.setText("Decimal Result: " + decimalResult);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Decimal Result: Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            BintoDecGUI converter = new BintoDecGUI();
            converter.setVisible(true);
        });
    }
}
