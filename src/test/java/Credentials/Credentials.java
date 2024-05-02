package Credentials;

import java.util.Random;

public class Credentials {
    private static String username;
    private static String password;

    public static void generateIdAndCredentials() {
        Random random = new Random();
        int id = 100000 + random.nextInt(900000);
        username = "username" + id;
        password = "Test@1234";
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
