import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp extends JFrame {
    private JTextField inputField;
    private JComboBox<String> unitComboBox;
    private JLabel resultLabel;

    public TemperatureConverterApp() {
        setTitle("Temperature Converter");
        setSize(350, 390);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));

        inputField = new JTextField();
        panel.add(inputField);

        unitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        panel.add(unitComboBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setSize(50,80);
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
        panel.add(convertButton);

        resultLabel = new JLabel();
        panel.add(resultLabel);

        add(panel);
    }

    private void convertTemperature() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String selectedUnit = unitComboBox.getSelectedItem().toString();
            double result;

            if (selectedUnit.equals("Celsius")) {
                result = (inputValue * 9 / 5) + 32;
                resultLabel.setText("Result: " + result + " °F");
            } else {
                result = (inputValue - 32) * 5 / 9;
                resultLabel.setText("Result: " + result + " °C");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TemperatureConverterApp app = new TemperatureConverterApp();
            app.setVisible(true);
        });
    }
}