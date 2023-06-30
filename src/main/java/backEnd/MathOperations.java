package backEnd;

public class MathOperations {

    public double addTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 + operand2;
        return  result;
    }

    public double subTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 - operand2;
        return  result;
    }

    public double multiTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 * operand2;
        return  result;
    }

    public double divideTwoNumbers(double operand1, double operand2) {
        double result;
        result = operand1 / operand2;
        return  result;
    }

    public float scoreInQuiz(float num) {
        float result;
        result = (num /10) * 100;
        return result;
    }
}
