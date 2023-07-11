package backEnd;

//Math operation Class includes basic algebra operations
public class MathOperations {

    //using + operator
    public double addTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 + operand2;
        return  result;
    }

    //using - operator
    public double subTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 - operand2;
        return  result;
    }

    //using * operator
    public double multiTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 * operand2;
        return  result;
    }

    //using / operator
    public double divideTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 / operand2;
        return  result;
    }

    //Custom method for finding the score that the user has achieved in the math Quiz
    public float scoreInQuiz(float num) {
        float result;
        result = (num /10) * 100;
        return result;
    }
}
