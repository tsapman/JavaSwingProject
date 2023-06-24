package backEnd;
import java.util.Random;

public class QuizGame {
    Random random = new Random();
    public int rightCounter = 0;
    public int wrongCounter = 0;

    public QuizGame() {
    }

    public int getRandomNumber() {
        return random.nextInt(10);

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


}
