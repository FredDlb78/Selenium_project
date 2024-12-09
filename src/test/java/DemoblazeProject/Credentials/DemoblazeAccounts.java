package DemoblazeProject.Credentials;

import java.util.Random;

public class DemoblazeAccounts {
    private static String username;
    private static String password;
    public static String email;
    public static String country;
    public static String city;
    public static String creditCardNumbers;
    public static String creditCardMonth;
    public static String creditCardYear;
    public static String message;



    public static void newAccount() {
        Random random = new Random();
        int id = 100000 + random.nextInt(900000);
        username = "username" + id;
        password = "Test@1234";
        email = "marco.verratti@gmail.com";
        country = "Italia";
        city = "Pescara";
        creditCardNumbers ="1234123412341234";
        creditCardMonth ="04";
        creditCardYear="26";
        message="Salut salut" + id;
    }

    public static void existingAccount() {
        username = "JamesSele";
        password = "Test@1234";
        email = "james.sele@gmail.com";
    }
    public static void notRegisteredAccount() {
        username = "notRegisterUser1234";
        password = "Test@1234";
        email = "notregistereduser@gmail.com";
    }
    public static void wrongPasswordAccount() {
        username = "JamesSele";
        password = "WrongPassword";
        email = "james.sele@gmail.com";
    }
    public static void emptyUsernameAccount() {
        username = "";
        password = "Test@1234";
        email = "james.sele@gmail.com";
    }
    public static void emptyPasswordAccount() {
        username = "JamesSele";
        password = "";
        email = "james.sele@gmail.com";
    }

    public static String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }
    public static String getEmail() {
        return email;
    }
    public static String getCountry() {
        return country;
    }
    public static String getCity() {
        return city;
    }
    public static String getCreditCardNumbers() {
        return creditCardNumbers;
    }
    public static String getCreditCardMonth() {
        return creditCardMonth;
    }
    public static String getCreditCardYear() {
        return creditCardYear;
    }
    public static String getMessage() {
        return message;
    }
}

