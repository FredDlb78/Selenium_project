package resources;

import java.util.Random;

public class Users {
    public static int generateId() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }
    // Génération de l'ID
    int id = generateId();

    // Création du nom d'utilisateur
    String username = "username" + id;
    String password = "Test@1234";
}
