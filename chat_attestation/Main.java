import java.io.*;
import java.util.*;
import java.text.*;

public class Main {
    public static List<User> users;
    public static ArrayList<String> msg;
    static StringWriter writer;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        users = new ArrayList<>();
        msg = new ArrayList<>();
        BufferedWriter writer = new BufferedWriter(new FileWriter("Chat.txt"));
        commands();
    }

    private static void commands() throws IOException {
        System.out.println("Введите цифру, соответствующую команде" +
                "\n0 - Зарегистрировать нового пользователя" +
                "\n1 - Отправить сообщение в чат" +
                "\n2 - Удалить пользователя" +
                "\n3 - Cooбщения пользователя" +
                "\n4 - Посмотреть историю чата"+
                "\n5 - Выйти");
        switch (reader.readLine()) {
            case ("0"):
                registerLogin();
                commands();
            case ("1"):
                sendMessage();
                commands();
            case ("2"):
                deleteUser();
                commands();
            case ("3"):
                showUserHistory();
                commands();
            case ("4"):
                showChatHistory();
                commands();
            case ("5"):
                System.exit(0);
            default: commands();
        }

    }

    private static void showChatHistory() {
        for (int i = 0; i<msg.size();i++ ){
            System.out.println(msg.get(i));
        }
    }

    private static void showUserHistory() throws IOException {
        System.out.println("Введите логин пользователя для просмотра сообщений");
        String login =reader.readLine();
        if (isLoginExists(login)) {
            users.get(numUser(login)).historyMessages();
        }else {
            System.out.println("Логин не существует");
        }
    }

    private static boolean isPasswordTrue(String login, String readLine) {
        boolean b = false;
        for (User user : users) {
            if (user.login.equalsIgnoreCase(login)) {
                if (user.getPassword().equalsIgnoreCase(readLine)) {
                    b = true;
                }
            }
        }
        return b;
    }

    private static void deleteUser() throws IOException {
        System.out.println("Введите логин пользователя для удаления");
        String login = reader.readLine();
        if (isLoginExists(login)){
            System.out.println("Введите пароль для удаления");
            if (isPasswordTrue(login,reader.readLine())){
                if (numUser(login)!=-1){
                users.remove(numUser(login));
                    System.out.println("Пользователь"+login+"удален");
                }else {
                    System.out.println("Ошибка");
                }
            }else {
                System.out.println("Неверный пароль");
            }
        }else {
            System.out.println("Логин не существует");
        }
    }

    private static int numUser(String login) {
        for (User user : users) {
            if (user.login.equalsIgnoreCase(login)) {
                return users.indexOf(user);
            }
        }
        return -1;
    }

    private static void sendMessage() throws IOException {
        System.out.println("Введите логин");
        String login = (reader.readLine());
        if (isLoginExists(login)) {
            System.out.println("Введите сообщение");
            String message = reader.readLine();
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat(" dd.MM.yyyy HH:mm");
            String text = login+formatForDateNow.format(dateNow)+": "+message;
            System.out.println(text);
            users.get(numUser(login)).messages.add(text);
            msg.add(text);
        }else {
            System.out.println("Логин не существует");
        }

    }

    private static void registerLogin() throws IOException {
        System.out.println("Введите имя пользователя");
        String login =reader.readLine();
        if (isLoginExists(login)){
            System.out.println("Это имя уже используется");
            commands();
        }else {
            System.out.println("Введите пароль");
            String password = reader.readLine();
            User user = new User(login,password,new ArrayList<>());
            users.add(user);
        }
    }

    private static boolean isLoginExists(String login) {
        boolean b = false;
        if (users.size()>0){
            for (User user : users) {
                if (user.login.equalsIgnoreCase(login)) {
                    b = true;
                }
            }
        }
        return b;
    }

}