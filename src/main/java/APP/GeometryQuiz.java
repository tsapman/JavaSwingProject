package APP;


import backEnd.NameOfTheUser;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//Geometry Quiz tab
class GeometryQuiz extends JFrame implements ActionListener {
    JPanel panel;
    JRadioButton choice1;
    JRadioButton choice2;
    JRadioButton choice3;
    JRadioButton choice4;
    ButtonGroup bg;
    JLabel labelMess;
    JButton buttonNext;
    String[][] qpa;
    String[][] qca;
    int qaId;
    HashMap<Integer, String> map;


    //Geometry Quiz constructor
    GeometryQuiz() {
        initializeData();
        setTitle("GeometryQuiz Program");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(430, 350);
        setLocation(300, 100);
        setResizable(false);
        Container cont = getContentPane();
        cont.setLayout(null);
        cont.setBackground(Color.GRAY);
        bg = new ButtonGroup();
        choice1 = new JRadioButton("Choice1", true);
        choice2 = new JRadioButton("Choice2", false);
        choice3 = new JRadioButton("Choice3", false);
        choice4 = new JRadioButton("Choice4", false);
        bg.add(choice1);
        bg.add(choice2);
        bg.add(choice3);
        bg.add(choice4);
        labelMess = new JLabel("Choose a correct answer");
        labelMess.setForeground(Color.BLUE);
        labelMess.setFont(new Font("Arial", Font.BOLD, 11));
        buttonNext = new JButton("Next");
        buttonNext.setForeground(Color.BLUE);
        buttonNext.addActionListener(this);
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLocation(10, 10);
        panel.setSize(400, 300);
        panel.setLayout(new GridLayout(6, 2));
        panel.add(labelMess);
        panel.add(choice1);
        panel.add(choice2);
        panel.add(choice3);
        panel.add(choice4);
        panel.add(buttonNext);
        cont.add(panel);
        setVisible(true);
        qaId = 0;
        readQa(qaId);
    }

    public void actionPerformed(ActionEvent e) {
        if (buttonNext.getText().equals("Next")) {
            if (qaId < 9) {
                map.put(qaId, getSelection());
                qaId++;
                readQa(qaId);
            }
            else {
                map.put(qaId, getSelection());
                buttonNext.setText("Show answers");
            }
        }
        else if (buttonNext.getText().equals("Show answers")) {
            new Report();
        }
    }

    //Initialize Question and answer data
    public void initializeData() {
        //qpa stores pairs of question and its possible answers
        qpa = new String[10][5];

        qpa[0][0] = "Which is the sin(45)?";
        qpa[0][1] = "1";
        qpa[0][2] = "0";
        qpa[0][3] = "1/√2";
        qpa[0][4] = "0.5";

        qpa[1][0] = "What is the Circle Area?";
        qpa[1][1] = "A=πr^2";
        qpa[1][2] = "A=πr";
        qpa[1][3] = "A=r^2";
        qpa[1][4] = "A=r";

        qpa[2][0] = "The Pythagorean theorem is";
        qpa[2][1] = "c=a^2+b^2";
        qpa[2][2] = "c=a+b";
        qpa[2][3] = "c=a";
        qpa[2][4] = "c^2=a^2+b^2";

        qpa[3][0] = "Triangle with base 3 cm,hypotenuse 5 cm.Find the missing side.";
        qpa[3][1] = "4 cm";
        qpa[3][2] = "6 cm";
        qpa[3][3] = "7 cm";
        qpa[3][4] = "0 cm";

        qpa[4][0] = "sin A = 2 sin 30° cos 30°, then the value of A is";
        qpa[4][1] = "45°";
        qpa[4][2] = "30°";
        qpa[4][3] = "60°";
        qpa[4][4] = "None of the above";

        qpa[5][0] = "_____ angle is less than 90°";
        qpa[5][1] = "obtuse angle";
        qpa[5][2] = "right angle";
        qpa[5][3] = "acute angle";
        qpa[5][4] = "reflex angle";

        qpa[6][0] = "Which of the following two angles are classified as complementary?";
        qpa[6][1] = "65° and 25°";
        qpa[6][2] = "70° and 30°";
        qpa[6][3] = "120° and 60°";
        qpa[6][4] = "50° and 30°";

        qpa[7][0] = "Surface area of a hollow cylinder with, radius and height is measured by";
        qpa[7][1] = "2πrh";
        qpa[7][2] = "πrh";
        qpa[7][3] = "2πr + h";
        qpa[7][4] = "None of These";

        qpa[8][0] = "________ polygon has 10 sides.";
        qpa[8][1] = "decagon";
        qpa[8][2] = "hexagon";
        qpa[8][3] = "quadrilateral";
        qpa[8][4] = "None of These";

        qpa[9][0] = "________ polygon has 8 sides.";
        qpa[9][1] = "decagon";
        qpa[9][2] = "hexagon";
        qpa[9][3] = "octagon";
        qpa[9][4] = "None of These";


        //qca stores pairs of question and its correct answer
        qca = new String[10][2];

        qca[0][0] = "Which is the sin(45)?";
        qca[0][1] = "1/√2";

        qca[1][0] = "What is the Circle Area?";
        qca[1][1] = "A=πr^2";

        qca[2][0] = "The Pythagorean theorem is";
        qca[2][1] = "c^2=a^2+b^2";

        qca[3][0] = "Triangle with base 3 cm,hypotenuse 5 cm.Find the missing side.";
        qca[3][1] = "4 cm";

        qca[4][0] = "sin A = 2 sin 30° cos 30°, then the value of A is";
        qca[4][1] = "60°";

        qca[5][0] = "_____ angle is less than 90°";
        qca[5][1] = "acute angle";

        qca[6][0] = "Which of the following two angles are classified as complementary?";
        qca[6][1] = "65° and 25°";

        qca[7][0] = "Surface area of a hollow cylinder with, radius and height is measured by";
        qca[7][1] = "2πrh";

        qca[8][0] = "________ polygon has 10 sides.";
        qca[8][1] = "decagon";

        qca[9][0] = "________ polygon has 8 sides.";
        qca[9][1] = "octagon";


        //create a map object to store pairs of question and selected answer
        map = new HashMap<>();
    }

    public String getSelection() {
        String selectedChoice = null;
        Enumeration<AbstractButton> buttons = bg.getElements();
        while (buttons.hasMoreElements()) {
            JRadioButton temp = (JRadioButton) buttons.nextElement();
            if (temp.isSelected()) {
                selectedChoice = temp.getText();
            }
        }
        return (selectedChoice);
    }

    public void readQa(int qid) {
        labelMess.setText("  " + qpa[qid][0]);
        choice1.setText(qpa[qid][1]);
        choice2.setText(qpa[qid][2]);
        choice3.setText(qpa[qid][3]);
        choice4.setText(qpa[qid][4]);
        choice1.setSelected(true);
    }

    public void reset() {
        qaId = 0;
        map.clear();
        readQa(qaId);
        buttonNext.setText("Next");
    }

    public int calCorrectAnswer() {
        int qNum = 10;
        int count = 0;
        for (int qid = 0; qid < qNum; qid++) {
            if (qca[qid][1].equals(map.get(qid))) {
                count++;
            }
        }
        return count;
    }

    public class Report extends JFrame {
        Report() {
            setTitle("Answers");
            setSize(850, 550);
            setBackground(Color.WHITE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                    reset();
                }
            });
            Draw d = new Draw();
            add(d);
            setVisible(true);
        }

        class Draw extends Canvas {
            public void paint(Graphics g) {
                int qNum = 10;
                int x = 10;
                int y = 20;
                for (int i = 0; i < qNum; i++) {
                    //print the 1st column
                    g.setColor(Color.BLUE);
                    g.setFont(new Font("Arial", Font.BOLD, 12));
                    g.drawString(i + 1 + ". " + qca[i][0], x, y);
                    y += 30;
                    g.setFont(new Font("Arial", Font.PLAIN, 12));
                    g.drawString("      Correct answer:" + qca[i][1], x, y);
                    y += 30;
                    g.drawString("      Your answer:" + map.get(i), x, y);
                    y += 30;
                    //print the 2nd column
                    if (y > 400) {
                        y = 20;
                        x = 450;
                    }
                }
                //show number of correct answers
                float num = calCorrectAnswer();
                float result = (num /10) * 100;
                NameOfTheUser  nameOfTheUser= NameOfTheUser.getInstance();

                String re =nameOfTheUser.getUserName()+" your score is: " + result +"%";
                g.setColor(Color.BLUE);
                g.setFont(new Font("Arial", Font.BOLD, 14));
                g.drawString(re, 300, 500);
            }
        }
    }
}