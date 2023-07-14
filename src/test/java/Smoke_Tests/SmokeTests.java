package Smoke_Tests;

import APP.Application;
import backEnd.NameOfTheUser;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.junit.After;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.assertTrue;

//Class that hosts the Smoke tests of the Application
public class SmokeTests {
    FrameFixture frame;
    NameOfTheUser nameOfTheUser = NameOfTheUser.getInstance();

    //Checking if the App starts correctly
    @Test
    public void testStartOfTheApp(){

        Application application = GuiActionRunner.execute(Application::new);
        frame = new FrameFixture(application.frame);
        frame.show();

        //Asserting if the frame of the starting page is shown correctly
        assertTrue("The app does not start properly", frame.isEnabled());

    }

    @Test
    public void checkButtonInStartingFrame(){

        Application application = GuiActionRunner.execute(Application::new);
        frame = new FrameFixture(application.frame);
        frame.show();

        // Check the presence and behavior of a button
        JButtonFixture buttonFixture = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in starting page
                return "Enter".equals(button.getText());
            }
        });

        //check that the Enter button is on the screen
        assertTrue("The button Enter  does not appearing", buttonFixture.isEnabled());

        buttonFixture.click();
    }

    //Check the content of Choice menu
    @Test
    public void checkTheContentOfTheMenuOfChoicesPart1(){
        Application application = GuiActionRunner.execute(Application::new);
        frame = new FrameFixture(application.frame);
        frame.show();

        // Check the presence and behavior of a button
        JButtonFixture buttonFixture = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in starting page
                return "Enter".equals(button.getText());

            }
        });

        buttonFixture.click();
        JButtonFixture buttonAlgebraTheory = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in Choice Menu
                return "Algebra - Theory".equals(button.getText());

            }
        });
        assertTrue("the Algebra Theory Button is not displayed",buttonAlgebraTheory.isEnabled());

        JButtonFixture buttonGeometryTheory = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in Choice Menu
                return "Geometry - Theory".equals(button.getText());

            }
        });
        assertTrue("the Geometry Theory Button is not displayed",buttonGeometryTheory.isEnabled());

        JButtonFixture buttonAlgebraExercises = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of button in Choice Menu
                return "Algebra - Calculator".equals(button.getText());

            }
        });
        assertTrue("the Algebra - Exercises Button is not displayed",buttonAlgebraExercises.isEnabled());
    }

    //Check the content of Choice menu
    @Test
    public void checkTheContentOfTheMenuOfChoicesPart2(){
        Application application = GuiActionRunner.execute(Application::new);
        frame = new FrameFixture(application.frame);
        frame.show();

        // Check the presence and behavior of a button
        JButtonFixture buttonFixture = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in starting page
                return "Enter".equals(button.getText());
            }
        });

        buttonFixture.click();

        JButtonFixture buttonAlgebraTheory = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {
                // the text of  button in Choice Menu
                return "Algebra - Theory".equals(button.getText());
            }
        });
        assertTrue("the Algebra Theory Button is not displayed",buttonAlgebraTheory.isEnabled());

        JButtonFixture buttonGeometryExercises = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in Choice Menu
                return "Geometry - Exercises".equals(button.getText());

            }
        });
        assertTrue("the Geometry - Exercises Button is not displayed",buttonGeometryExercises.isEnabled());

        JButtonFixture buttonMathQuiz = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of button in Choice Menu
                return "Math Quiz".equals(button.getText());

            }
        });
        assertTrue("the Math Quiz Button is not displayed",buttonMathQuiz.isEnabled());

        JButtonFixture buttonAboutUs = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of button in Choice Menu
                return "About Us".equals(button.getText());

            }
        });
        assertTrue("the About Us Button is not displayed",buttonAboutUs.isEnabled());
    }

    //Check if the user can enter at the Algebra Theory tab
    @Test
    public void checkIfTheUserCanEnterAtTheAlgebraTheoryTab(){
        Application application = GuiActionRunner.execute(Application::new);
        frame = new FrameFixture(application.frame);
        frame.show();

        // Check the presence and behavior of a button
        JButtonFixture buttonFixture = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in starting page
                return "Enter".equals(button.getText());
            }
        });

        buttonFixture.click();

        JButtonFixture buttonAlgebraTheory = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {

                // the text of  button in Choice Menu
                return "Algebra - Theory".equals(button.getText());
            }
        });

        buttonAlgebraTheory.click();

        JButtonFixture buttonBackAlgebraTab = frame.button(new GenericTypeMatcher<>(JButton.class) {
            protected boolean isMatching(JButton button) {
                // the text of button in Choice Menu
                return "Back".equals(button.getText());

            }
        });

        //If the Jbutton Back is displayed then we are on the Algebra Theory tab
        assertTrue("The Algebra Theory section is NOT displayed properly",buttonBackAlgebraTab.isEnabled());
    }

    // Clean up resources
    @After
    public void cleanFrameAfterExecution() {

        frame.cleanUp();
    }
}
