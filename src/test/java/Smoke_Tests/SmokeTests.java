package Smoke_Tests;

import APP.Application;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Assert;
import org.junit.Test;

//Class that hosts the Smoke tests of the Application
public class SmokeTests {


    //Checking if the App starts correctly
    @Test
    public void testStartOfTheApp(){
        FrameFixture frame;
        Application application = GuiActionRunner.execute(Application::new);
        frame = new FrameFixture(application.frame);
        frame.show();

        //Asserting if the frame of the starting page is shown correctly
        Assert.assertTrue("The app does not start properly", frame.isEnabled());

    }

}
