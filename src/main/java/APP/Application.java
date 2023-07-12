package APP;

import backEnd.NameOfTheUser;
import backEnd.Theory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

// Application class includes main method
public class Application implements ActionListener {

    public JFrame frame;
    private JPanel panel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton submitButton;
    HyperlinkAlgebra hyperlinkAlgebra = new HyperlinkAlgebra();
    HyperLinkGeometry hyperLinkGeometry = new HyperLinkGeometry();
    private ArithmeticPanel arithmeticPanel;
    MathQuiz mathQuiz;
    GeometryQuiz geometryQuiz;

    private String name;
    Theory theory = new Theory();

    //Constructor for the App class
    public Application() {
        NameOfTheUser nameOfTheUser = NameOfTheUser.getInstance();
        frame = new JFrame("Swing App Example");
        frame.setPreferredSize(new Dimension(800, 600)); // Set the preferred size of the frame
        frame.setResizable(false);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel titleOfApp = new JLabel("Welcome to Become a Math Legend App!!");

        //Asks the user to input his/her name amd saves that name
        nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Increase the font size and style
        nameField = new JTextField(10);
        submitButton = new JButton("Enter");

        //Sets the font of the text and the foreground
        Font answerFont = new Font("Arial", Font.BOLD, 24);
        Font titleFont = new Font("Arial",Font.BOLD,34);
        nameField.setFont(answerFont);
        titleOfApp.setFont(titleFont);
        titleOfApp.setForeground(Color.BLUE);

        //setting the components of the starting page of the app
        panel.setBackground(Color.ORANGE);
        panel.add(titleOfApp);
        panel.add(Box.createVerticalStrut(200));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(submitButton);

        //Putting Action listener to the Enter button, when the user pushes enter it triggers the actionListener
        submitButton.addActionListener(e -> {
            name = nameField.getText();

            //initializing the username with the Singleton pattern
            nameOfTheUser.setUserName(name);
            showChoicesPanel();
        });

        nameField.addActionListener(e -> {
            name = nameField.getText();

            //initializing the username with the Singleton pattern
            nameOfTheUser.setUserName(name);
            showChoicesPanel();
        });

        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    //method to show the choices to the user in the main menu
    private void showChoicesPanel() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setBackground(Color.white);
        NameOfTheUser  nameOfTheUser= NameOfTheUser.getInstance();

        JLabel greetingLabel = new JLabel("Hello, " + nameOfTheUser.getUserName() + "!");
        greetingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel choicesLabel = new JLabel("Select an option:");
        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(3, 2, 10, 10)); // 2 rows, 2 columns with spacing

        //Initializing the JButtons for representing the available options that the user has
        JButton algebraTheoryButton = new JButton("Algebra - Theory");
        JButton algebraCalculatorButton = new JButton("Algebra - Calculator");
        JButton geometryTheoryButton = new JButton("Geometry - Theory");
        JButton geometryExercisesButton = new JButton("Geometry - Exercises");
        JButton mathQuizButton = new JButton("Math Quiz");
        JButton aboutUsButton = new JButton("About Us");

        //Adding the choices to the panel
        choicesPanel.add(algebraTheoryButton);
        choicesPanel.add(algebraCalculatorButton);
        choicesPanel.add(geometryTheoryButton);
        choicesPanel.add(geometryExercisesButton);
        choicesPanel.add(mathQuizButton);
        choicesPanel.add(aboutUsButton);

        //Setting up the Jpanel
        panel.setBackground(Color.ORANGE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(greetingLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(choicesLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(choicesPanel);



        //First choice cans be accessed by clicking on the button
        algebraTheoryButton.addActionListener(e ->
                showPanel("Algebra - Theory", theory.AlgebraTheory()));

        //Second choice cans be accessed by clicking on the button
        algebraCalculatorButton.addActionListener(e -> {
            arithmeticPanel = new ArithmeticPanel();
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
            panel.setBackground(Color.white);
            panel.add(arithmeticPanel);
            JButton backButton = new JButton("Back");
            panel.add(Box.createVerticalStrut(20));
            panel.add(backButton);

            //Using Lambda function to facilitate the click at the Enter button
            backButton.addActionListener(e1 -> showChoicesPanel());
        });

        /*
        Using Lambda function to facilitate the click
        Third choice can be accessed by clicking on the button
        */
        geometryTheoryButton.addActionListener(e ->
                showPanel("Geometry - Theory",theory.geometryTheory()));

        /*
        Using Lambda function to facilitate the click
        Fourth choice can be accessed by clicking on the button
        */
        geometryExercisesButton.addActionListener(e ->
                geometryQuiz = new GeometryQuiz()
                );
        /*
        Using Lambda function to facilitate the click
        Fifth choice can be accessed by clicking on the button
        */
        mathQuizButton.addActionListener(e ->
                mathQuiz = new MathQuiz());

        /*
        Using Lambda function to facilitate the click
        6th choice "About us" can be accessed by clicking on the button
        By clicking this button a tab of the browser pops up and redirects the user to my gitHub page
        */
        aboutUsButton.addActionListener(e ->
        {
            try {
                Desktop.getDesktop().browse(new URL("https://github.com/tsapman").toURI());
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        });

        frame.pack();
        frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
    }

    //Method that facilitates the creation of the Algebra Theory and Geometry Theory Tabs
    private void showPanel(String choice, String additionalString) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setBackground(Color.white);

        JLabel choiceLabel = new JLabel(choice);
        choiceLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel additionalLabel = new JLabel(additionalString);

        // Set the font for the additionalLabel
        additionalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel algebraLink = hyperlinkAlgebra.algebraLink();
        JLabel geometryLink = hyperLinkGeometry.geometryLink();
        JButton backButton = new JButton("Back");

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(choiceLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(additionalLabel);
        panel.add(Box.createVerticalStrut(20));
        if (choice.equals("Algebra - Theory") ){
            panel.add(algebraLink);
        }
        if (choice.equals("Geometry - Theory")) {
            panel.add(geometryLink);
        }
        panel.setBackground(Color.ORANGE);
        panel.add(Box.createVerticalStrut(20));
        panel.add(backButton);

        backButton.addActionListener(e -> showChoicesPanel());

        frame.pack();
        frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
    }

    //Main method of the project
    public static void main(String[] args) {

        Application app = new Application();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}