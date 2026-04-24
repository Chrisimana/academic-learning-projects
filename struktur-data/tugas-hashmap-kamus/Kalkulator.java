package Kamus;
import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Kalkulator extends JFrame implements ActionListener {

    private JTextField textField;
    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";

    public Kalkulator() {
        // Initialize the frame

        super("Kalkulator Sederhana");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout());

        // Text field for display
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 10, 10));

        // Button labels
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+",
                "%", "mod", "x²", "x³",
                "√", ".", "<-", ""
        };

        // Add buttons to the panel
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));

            if (label.isEmpty()) {
                button.setEnabled(false);
            } else {
                button.addActionListener(this);
            }
            panel.add(button);
        }
        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            // Handle number input
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            // Clear the text field
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
        } else if (command.equals("<-")) {
            // Backspace functionality
            String currentText = textField.getText();
            if (currentText.length() > 0) {
                textField.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else if (command.equals("=")) {
            // Perform calculation
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num2 != 0 ? num1 / num2 : Double.NaN; // Handle division by zero
                    break;
                case "mod":
                    result = num1 % num2;
                    break;
            }
            textField.setText(Double.toString(result));
            operator = "";
        } else if (command.equals("%")) {
            // Percentage calculation
            num1 = Double.parseDouble(textField.getText());
            result = num1 / 100;
            textField.setText(Double.toString(result));
        } else if (command.equals("x²")) {
            // Square calculation
            num1 = Double.parseDouble(textField.getText());
            result = Math.pow(num1, 2);
            textField.setText(Double.toString(result));
        } else if (command.equals("x³")) {
            // Cube calculation
            num1 = Double.parseDouble(textField.getText());
            result = Math.pow(num1, 3);
            textField.setText(Double.toString(result));
        } else if (command.equals("√")) {
            // Square root calculation
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            textField.setText(Double.toString(result));
        } else {
            if (!textField.getText().isEmpty()){
                num1 = Double.parseDouble(textField.getText());
                operator = command;
                textField.setText("");
            }
        }
    }
    private boolean isScientific(String cmd) {
        return cmd.equals("%") || cmd.equals("x²") || cmd.equals("x³") || cmd.equals("√");
    }
}