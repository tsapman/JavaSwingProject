package Unit_Tests;


import backEnd.MathOperations;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Class for Unit Testing Math operations that the app contains
public class TestingMathMethods {
    MathOperations mathOperations = new MathOperations();
    double e = 0.000001d;


    //unit test for checking Add functionality
    @Test
    public void testAddition(){

        assertEquals(8,mathOperations.addTwoNumbers(4.0,4.0), e);
    }

    //unit test for checking Subtraction
    @Test
    public void testSubtraction(){

        assertEquals(-22,mathOperations.subTwoNumbers(142.56,164.56), e);
    }

    //unit test for checking Multiplication
    @Test
    public void testMultiplication(){

        assertEquals(1200,mathOperations.multiTwoNumbers(-300,-4), e);
    }

    //unit test for checking Division
    @Test
    public void testDivision(){

        assertEquals(2,mathOperations.divideTwoNumbers(-300,-150), e);
    }


}
