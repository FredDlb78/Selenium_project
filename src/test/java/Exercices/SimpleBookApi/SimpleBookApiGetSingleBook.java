package Exercices.SimpleBookApi;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleBookApiGetSingleBook {

    private final String apiURL = "https://simple-books-api.glitch.me";

    @Test
    @DisplayName("01_Get a single book by id")
    @Description("Retrieve a single book by id")
    public void testGetSingleBookById() {
        String bookId = "1"; // Assurez-vous d'utiliser un ID réel ici
        int expectedResponseCode = 200;
        String expectedResponse = "{\"id\":1,\"name\":\"The Russian\",\"author\":" +
                "\"James Patterson and James O. Born\",\"isbn\":\"1780899475\",\"type\":" +
                "\"fiction\",\"price\":12.98,\"current-stock\":12,\"available\":true}";
        String successMessage = "01 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        SimpleBooksApi_ApiMethods.testGetSingleBookById(apiURL, bookId, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }
}


