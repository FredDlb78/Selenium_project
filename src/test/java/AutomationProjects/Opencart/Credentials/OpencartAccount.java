package AutomationProjects.Opencart.Credentials;

import java.util.Random;

public class OpencartAccount {
    private static String firstName;
    private static String lastName;
    public static String email;
    public static String phone;
    public static String password;


    public static OpencartAccount newAccount() {
        Random random = new Random();
        int id = 100000 + random.nextInt(900000);
        firstName = "firstname" + id;
        lastName = "lastname" + id;
        email = "marco.verratti" + id + "@gmail.com";
        phone = "0102" + id;
        password = "Test@1234";
        return null;
    }

    public static String getFirstName() {return firstName;}
    public static String getLastName() {return lastName;}
    public static String getEmail() {return email;}
    public static String getPhone() {return phone;}
    public static String getPassword() {return password;}
}

