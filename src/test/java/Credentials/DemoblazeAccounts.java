package Credentials;

import java.util.Random;

public class DemoblazeAccounts {
    private static String username;
    private static String password;

    public static void newAccount() {
        Random random = new Random();
        int id = 100000 + random.nextInt(900000);
        username = "username" + id;
        password = "Test@1234";
    }

    public static void existingAccount() {
        username = "JamesSele";
        password = "Test@1234";
    }
    public static void notRegisteredAccount() {
        username = "notRegisterUser1234";
        password = "Test@1234";
    }
    public static void wrongPasswordAccount() {
        username = "JamesSele";
        password = "WrongPassword";
    }
    public static void emptyUsernameAccount() {
        username = "";
        password = "Test@1234";
    }
    public static void emptyPasswordAccount() {
        username = "JamesSele";
        password = "";
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}

