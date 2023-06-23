package APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingAppExample {
    private JFrame frame;
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton submitButton;

    private String name;

    public SwingAppExample() {
        frame = new JFrame("Swing App Example");
        frame.setPreferredSize(new Dimension(400, 200)); // Set the preferred size of the frame
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Increase the font size and style
        nameField = new JTextField(20);
        submitButton = new JButton("Submit");

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = nameField.getText();
                showChoicesPanel();
            }
        });

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void showChoicesPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();

        JLabel greetingLabel = new JLabel("Hello, " + name + "!");
        greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel choicesLabel = new JLabel("Select an option:");
        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2 rows, 2 columns with spacing

        JButton algebraTheoryButton = new JButton("Algebra - Theory");
        JButton algebraExercisesButton = new JButton("Algebra - Exercises");
        JButton geometryTheoryButton = new JButton("Geometry - Theory");
        JButton geometryExercisesButton = new JButton("Geometry - Exercises");

        choicesPanel.add(algebraTheoryButton);
        choicesPanel.add(algebraExercisesButton);
        choicesPanel.add(geometryTheoryButton);
        choicesPanel.add(geometryExercisesButton);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(greetingLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(choicesLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(choicesPanel);

        algebraTheoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("Algebra - Theory");
            }
        });

        algebraExercisesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("Algebra - Exercises");
            }
        });

        geometryTheoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("Geometry - Theory");
            }
        });

        geometryExercisesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel("Geometry - Exercises");
            }
        });

        frame.pack();
        frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
    }

    private void showPanel(String choice) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();

        JLabel choiceLabel = new JLabel(choice);
        choiceLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JButton backButton = new JButton("Back");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(choiceLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showChoicesPanel();
            }
        });

        frame.pack();
        frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
    }

    public static void main(String[] args) {
        SwingAppExample app = new SwingAppExample();
    }
}