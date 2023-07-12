package APP;

import backEnd.MathOperations;

import javax.swing.*;
import java.awt.*;

//class for creating the Calculator
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
    MathOperations mathOperations = new MathOperations();

    //Constructor for ArithmeticPanel class
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

        //Adding ActionListener to each JButton
        addButton.addActionListener(e -> performOperation(Operation.ADD));

        subtractButton.addActionListener(e -> performOperation(Operation.SUBTRACT));

        multiplyButton.addActionListener(e -> performOperation(Operation.MULTIPLY));

        divideButton.addActionListener(e -> performOperation(Operation.DIVIDE));

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    //Facilitating the math operations for the calculator
    private void performOperation(Operation operation) {
        String operand1Text = operand1Field.getText();
        String operand2Text = operand2Field.getText();

        try {
            double operand1 = Double.parseDouble(operand1Text);
            double operand2 = Double.parseDouble(operand2Text);
            double result = 0;

            switch (operation) {
                case ADD:
                    //calling the method addTwoNumbers from mathOperations class
                    result = mathOperations.addTwoNumbers(operand1,operand2);
                    break;
                case SUBTRACT:
                    //calling the method subTwoNumbers from mathOperations class
                    result = mathOperations.subTwoNumbers(operand1,operand2);
                    break;
                case MULTIPLY:
                    //calling the method multiTwoNumbers from mathOperations class
                    result = mathOperations.multiTwoNumbers(operand1,operand2);
                    break;
                case DIVIDE:
                    //calling the method divideTwoNumbers from mathOperations class
                    result = mathOperations.divideTwoNumbers(operand1,operand2);
                    break;
            }

            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    //basic calculator functionalities
    private enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }


}