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

    // Clean up resources
    @After
    public void cleanFrameAfterExecution() {

        frame.cleanUp();
    }
}
