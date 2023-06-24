package backEnd;

import APP.SwingAppExample;

public class UserData {

    public UserData() {
    }

    public String userNameFormated(String name) {
        String nameFormated = "<html>\n" +
                "<head>\n" +
                "    <title> </title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p><div style=\"text-align: center;\">Hello "+name+"</p>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return  nameFormated;
    }
}
