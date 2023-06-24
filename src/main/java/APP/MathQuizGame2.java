package APP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MathQuizGame2 extends JFrame implements ActionListener {

    JLabel titleLabel = new JLabel("");
    JLabel subTitle1Label = new JLabel("===============");
    JLabel subTitle2Label = new JLabel("===============");
    JLabel questionLabel = new JLabel();
    JLabel answerLabel = new JLabel("Answer: ");
    JLabel gameOverLabel = new JLabel();

    JButton playButton = new JButton("PLAY");
    JButton mulButton = new JButton("x");
    JButton addButton = new JButton("+");
    JButton subButton = new JButton("-");
    JButton divButton = new JButton("/");
    JButton restartButton = new JButton("RESTART");
    JButton exitButton = new JButton("EXIT");

    JTextField answerField = new JTextField(10);
    JTextField remarksField = new JTextField(15);
    JTextField rightCounterField = new JTextField(3);
    JTextField wrongCounterField = new JTextField(3);

    Font titleFont = new Font("Tahoma", Font.BOLD, 58);
    Font questionFont = new Font("Tahoma", Font.BOLD, 48);
    Font answerFont = new Font("Tahoma", Font.BOLD, 38);

    Random random = new Random();
    int digit1;
    int digit2;
    int correctAnswer;
    String operator = "";
    int rightCounter = 0;
    int wrongCounter = 0;
    final int LIMIT = 10;

    public MathQuizGame2() {

        setLayout(new FlowLayout());
        add(titleLabel);
        add(subTitle1Label);
        add(questionLabel);
        add(subTitle2Label);
        add(answerLabel);
        add(answerField);
        add(rightCounterField);
        add(mulButton);
        add(addButton);
        add(subButton);
        add(divButton);
        add(wrongCounterField);
        add(remarksField);
        add(playButton);
        add(gameOverLabel);
        add(restartButton);
        add(exitButton);

        restartButton.setVisible(false);
        exitButton.setVisible(false);
        gameOverLabel.setVisible(false);

        rightCounterField.setVisible(false);
        wrongCounterField.setVisible(false);
        questionLabel.setVisible(false);
        subTitle2Label.setVisible(false);
        answerLabel.setVisible(false);
        answerField.setVisible(false);
        mulButton.setVisible(false);
        addButton.setVisible(false);
        subButton.setVisible(false);
        divButton.setVisible(false);
        remarksField.setVisible(false);

        getContentPane().setBackground(Color.darkGray);
        rightCounterField.setForeground(Color.blue);
        wrongCounterField.setForeground(Color.red);
        questionLabel.setForeground(Color.red);
        answerField.setForeground(Color.blue);
        addButton.setForeground(Color.red);
        subButton.setForeground(Color.green);
        mulButton.setForeground(Color.blue);
        divButton.setForeground(Color.yellow);
        gameOverLabel.setForeground(Color.orange);

        mulButton.setBackground(Color.black);
        addButton.setBackground(Color.black);
        subButton.setBackground(Color.black);
        divButton.setBackground(Color.black);
        playButton.setBackground(Color.orange);

        titleLabel.setFont(titleFont);
        subTitle1Label.setFont(questionFont);
        subTitle2Label.setFont(questionFont);
        questionLabel.setFont(questionFont);
        answerLabel.setFont(answerFont);
        answerField.setFont(answerFont);
        remarksField.setFont(answerFont);
        rightCounterField.setFont(answerFont);
        wrongCounterField.setFont(answerFont);
        mulButton.setFont(titleFont);
        addButton.setFont(titleFont);
        subButton.setFont(titleFont);
        divButton.setFont(titleFont);
        playButton.setFont(new Font("Tahoma", Font.BOLD, 100));
        restartButton.setFont(new Font("Tahoma", Font.BOLD, 60));
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 60));
        gameOverLabel.setFont(new Font("Tahoma", Font.BOLD, 95));

        remarksField.setHorizontalAlignment(JTextField.CENTER);
        wrongCounterField.setHorizontalAlignment(JTextField.RIGHT);

        playButton.addActionListener(this);
        answerField.addActionListener(this);
        mulButton.addActionListener(this);
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        divButton.addActionListener(this);
        restartButton.addActionListener(this);
        exitButton.addActionListener(this);

        setTitle("Math Quiz Game: Version 2.0");
        setIconImage(new ImageIcon("clipart.png").getImage());
        setSize(600, 500);
        setLocation(900, 100);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playButton) {
            getContentPane().setBackground(Color.gray);
            playButton.setVisible(false);
            rightCounterField.setVisible(true);
            wrongCounterField.setVisible(true);
            questionLabel.setVisible(true);
            subTitle2Label.setVisible(true);
            answerLabel.setVisible(true);
            answerField.setVisible(false);
            answerField.setEditable(true);
            mulButton.setVisible(true);
            addButton.setVisible(true);
            subButton.setVisible(true);
            divButton.setVisible(true);
            remarksField.setVisible(true);
            answerField.setVisible(true);
            answerField.setEditable(false);
        }
        if (e.getSource() == mulButton) {
            operator = "x";
            questionLabel.setText(setQuestion(operator));
            answerField.setEditable(true);
            questionLabel.setForeground(Color.blue);

        }
        if (e.getSource() == addButton) {
            operator = "+";
            questionLabel.setText(setQuestion(operator));
            answerField.setEditable(true);
            questionLabel.setForeground(Color.red);
        }
        if (e.getSource() == subButton) {
            operator = "-";
            questionLabel.setText(setQuestion(operator));
            answerField.setEditable(true);
            questionLabel.setForeground(Color.green);
        }
        if (e.getSource() == divButton) {
            operator = "/";
            questionLabel.setText(setQuestion(operator));
            answerField.setEditable(true);
            questionLabel.setForeground(Color.yellow);
        }
        if (e.getSource() == restartButton) {
            new MathQuizGame2();
            this.setVisible(false);
        }

        if (e.getSource() == exitButton) {
            System.exit(0);
        }

        if (e.getSource() == answerField) {
            int userAnswer = Integer.parseInt(answerField.getText());
            if (userAnswer == correctAnswer) {
                remarksField.setForeground(Color.blue);
                remarksField.setText(getCorrectResponse());
                answerField.setText("");
                rightCounterField.setText(rightCounter + "");
                questionLabel.setText(setQuestion(operator));
            } else {
                remarksField.setForeground(Color.red);
                remarksField.setText(getWrongResponse());
                answerField.setText("");
                wrongCounterField.setText(wrongCounter + "");

                if (wrongCounter == LIMIT) {
                    getContentPane().setBackground(Color.black);
                    gameOverLabel.setText("GAME OVER");
                    gameOverLabel.setVisible(true);
                    restartButton.setVisible(true);
                    exitButton.setVisible(true);
                    rightCounterField.setVisible(false);
                    wrongCounterField.setVisible(false);
                    questionLabel.setVisible(false);
                    subTitle2Label.setVisible(false);
                    answerLabel.setVisible(false);
                    answerField.setVisible(false);
                    answerField.setEditable(false);
                    mulButton.setVisible(false);
                    addButton.setVisible(false);
                    subButton.setVisible(false);
                    divButton.setVisible(false);
                    remarksField.setVisible(false);
                    answerField.setVisible(false);
                    answerField.setEditable(false);
                }
            }
        }
    }

    public String getCorrectResponse() {
        String response = "";
        rightCounter++;

        switch (random.nextInt(5)) {
            case 0:
                response = "Excellent";
                break;
            case 1:
                response = "Very Good!";
                break;
            case 2:
                response = "Correct!";
                break;
            case 3:
                response = "That's Right!";
                break;
            case 4:
                response = "Awesome!";
                break;
        }
        return response;
    }

    public String getWrongResponse() {
        String response = "";
        wrongCounter++;
        switch (random.nextInt(5)) {
            case 0:
                response = "Wrong!";
                break;
            case 1:
                response = "Sorry, Please Try Again";
                break;
            case 2:
                response = "Dont Give Up!";
                break;
            case 3:
                response = "Try Once More!";
                break;
            case 4:
                response = "Sorry, Incorrect!";
                break;
        }
        return response;
    }

    public int getRandomNumber() {
        return random.nextInt(10);

    }

    public String setQuestion(String operator) {
        digit1 = getRandomNumber();
        digit2 = getRandomNumber();

        switch (operator) {
            case "x":
                correctAnswer = digit1 * digit2;
                break;
            case "+":
                correctAnswer = digit1 + digit2;
                break;
            case "-":
                correctAnswer = digit1 - digit2;
                break;
            case "/":
                if (digit1 == 0) {
                    digit1++;
                    if (digit2 == 0)
                        digit2++;
                } else if (digit2 == 0)
                    digit2++;

                correctAnswer = digit1 / digit2;
                break;
        }
        return "How Much is " + digit1 + operator + digit2 + " ? ";
    }

}