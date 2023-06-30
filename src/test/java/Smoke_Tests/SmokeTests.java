package Smoke_Tests;

import APP.Application;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Test;

public class SmokeTests {


    @Test
    public void testStartOfTheApp(){
        FrameFixture frame;
        Application application = GuiActionRunner.execute(Application::new);

    }

}
