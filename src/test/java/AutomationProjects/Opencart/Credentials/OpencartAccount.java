package AutomationProjects.Opencart.Credentials;

import java.util.Random;

public class OpencartAccount {
    private static String firstName;
    private static String lastName;
    public static String email;
    public static String phone;
    public static String password;
    private static String firstNameMax;
    private static String lastNameMax;
    public static String emailMax;
    public static String phoneMax;
    public static String passwordMax;
    private static String firstNameMin;
    private static String lastNameMin;
    public static String emailMin;
    public static String phoneMin;
    public static String passwordMin;


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
    public static OpencartAccount newAccountMaxCharacter() {
        Random random = new Random();
        int id = 100000 + random.nextInt(900000);
        firstNameMax = "abcdefghijklmnopqrstuvwxyz" + id;
        lastNameMax = "abcdefghijklmnopqrstuvwxyz" + id;
        emailMax = "marco.verratti" + id + "@gmail.com";
        phoneMax = "01234567890123456789012345" + id;
        passwordMax = "Test@12345Test@12345";
        return null;
    }
    public static OpencartAccount newAccountMinCharacter() {
        Random random = new Random();
        int id = 0 + random.nextInt(9);
        firstNameMin = "" + id;
        lastNameMin = "" + id;
        emailMin = "F" + id + "@gmail.com";
        phoneMin = "78" + id;
        passwordMin = "972" + id;
        return null;
    }

    public static String getFirstName() {return firstName;}
    public static String getLastName() {return lastName;}
    public static String getEmail() {return email;}
    public static String getPhone() {return phone;}
    public static String getPassword() {return password;}
    public static String getFirstNameMax() {return firstNameMax;}
    public static String getLastNameMax() {return lastNameMax;}
    public static String getEmailMax() {return emailMax;}
    public static String getPhoneMax() {return phoneMax;}
    public static String getPasswordMax() {return passwordMax;}
    public static String getFirstNameMin() {return firstNameMin;}
    public static String getLastNameMin() {return lastNameMin;}
    public static String getEmailMin() {return emailMin;}
    public static String getPhoneMin() {return phoneMin;}
    public static String getPasswordMin() {return passwordMin;}
}

