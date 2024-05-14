package Exercices.SimpleBookApi;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleBookApiGetSingleBook {

    private final String apiURL = "https://simple-books-api.glitch.me";

    @Test
    @DisplayName("01 Passing case / Get a single book by id")
    @Description("Retrieve a single book by id")
    public void testGetSingleBookById_01() {
        String bookId = "1";
        int expectedResponseCode = 200;
        String expectedResponse = "{\"id\":1,\"name\":\"The Russian\",\"author\":" +
                "\"James Patterson and James O. Born\",\"isbn\":\"1780899475\",\"type\":" +
                "\"fiction\",\"price\":12.98,\"current-stock\":12,\"available\":true}";
        String successMessage = "01 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        SimpleBooksApi_ApiMethods.testGetSingleBookById(apiURL, bookId, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }
    @Test
    @DisplayName("02 Non-passing case / Get a single book with an inexistant id")
    @Description("Retrieve a single book with an inexistant id")
    public void testGetSingleBookById_02() {
        String bookId = "10";
        int expectedResponseCode = 404;
        String expectedResponse = "{\"error\":\"No book with id 10\"}";
        String successMessage = "02 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 404";

        SimpleBooksApi_ApiMethods.testGetSingleBookById(apiURL, bookId, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }
}


