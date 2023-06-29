package backEnd;

// Using Singleton design pattern to access to the username from every class in the project
public class NameOfTheUser {
    private static NameOfTheUser instance =null;
    private String userName;

    public NameOfTheUser() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static NameOfTheUser getInstance() {
        if (instance == null) {
            instance = new NameOfTheUser();
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}