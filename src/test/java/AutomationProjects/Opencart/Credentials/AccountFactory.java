package AutomationProjects.Opencart.Credentials;

import java.util.Random;

public class AccountFactory {

    private final Random random = new Random();

    public Account classicAccount() {
        int id = 100000 + random.nextInt(900000);
        return Account.builder()
                .firstName("firstname" + id)
                .lastName("lastname" + id)
                .email("marco.verratti" + id + "@gmail.com")
                .phone("0102" + id)
                .build();
    }
    public Account newAccountMaxCharacter() {
        int id = 100000 + random.nextInt(900000);
        return Account.builder()
                .firstName("abcdefghijklmnopqrstuvwxyz" + id)
                .lastName("abcdefghijklmnopqrstuvwxyz" + id)
                .email("marco.verratti" + id + "@gmail.com")
                .phone("01234567890123456789012345" + id)
                .password("Test@12345Test@12345")
                .build();
    }
    public Account newAccountMinCharacter() {
        int miniId = random.nextInt(9);
        int id = 1 + random.nextInt(998);
        return Account.builder()
                .firstName(String.valueOf(miniId))
                .lastName(String.valueOf(miniId))
                .email("F" + id + "@gmail.com")
                .phone(String.valueOf(id))
                .password("1" + id)
                .build();
    }
}