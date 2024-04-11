import java.util.List;

public class User {
    String login;
    String password;
    List<String> messages;

    public User(String login, String password,List<String> messages) {
        this.login = login;
        this.password = password;
        this.messages = messages;
    }
    public void historyMessages() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public String getPassword() {
        return password;
    }


}
