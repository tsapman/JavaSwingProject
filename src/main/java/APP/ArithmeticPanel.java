package APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ArithmeticPanel extends JPanel {
    private JTextField operand1Field;
    private JTextField operand2Field;
    private JLabel resultLabel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JPanel inputPanel;
    private JPanel buttonPanel;


    public ArithmeticPanel() {
        setLayout(new BorderLayout(10, 10));

        inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        operand1Field = new JTextField(10);
        operand2Field = new JTextField(10);
        resultLabel = new JLabel("Result:");

        inputPanel.add(new JLabel("Operand 1:"));
        inputPanel.add(operand1Field);
        inputPanel.add(new JLabel("Operand 2:"));
        inputPanel.add(operand2Field);
        inputPanel.add(resultLabel);

        buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.ADD);
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.SUBTRACT);
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.MULTIPLY);
            }
        });

        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation(Operation.DIVIDE);
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void performOperation(Operation operation) {
        String operand1Text = operand1Field.getText();
        String operand2Text = operand2Field.getText();

        try {
            double operand1 = Double.parseDouble(operand1Text);
            double operand2 = Double.parseDouble(operand2Text);
            double result = 0;

            switch (operation) {
                case ADD:
                    result = operand1 + operand2;
                    break;
                case SUBTRACT:
                    result = operand1 - operand2;
                    break;
                case MULTIPLY:
                    result = operand1 * operand2;
                    break;
                case DIVIDE:
                    result = operand1 / operand2;
                    break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    private enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    public JPanel getInputLabel(){
        return inputPanel;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }
}