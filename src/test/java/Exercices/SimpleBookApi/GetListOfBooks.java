package Exercices.SimpleBookApi;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetListOfBooks {

    private final String apiURL = "https://simple-books-api.glitch.me";

    @Test
    @DisplayName("01_Get Complete List of Books")
    @Description("Retrieve the complete list of books")
    public void testGetCompleteListOfBooks() {
        String endpoint = "/books";
        String method = "GET";
        int expectedResponseCode = 200;
        String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true},{\"id\":2,\"name\":\"Just as I Am\",\"type\":\"non-fiction\",\"available\":false},{\"id\":3,\"name\":\"The Vanishing Half\",\"type\":\"fiction\",\"available\":true},{\"id\":4,\"name\":\"The Midnight Library\",\"type\":\"fiction\",\"available\":true},{\"id\":5,\"name\":\"Untamed\",\"type\":\"non-fiction\",\"available\":true},{\"id\":6,\"name\":\"Viscount Who Loved Me\",\"type\":\"fiction\",\"available\":true}]";
        String successMessage = "01 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        ApiMethods.testApiGetResponse(apiURL, endpoint, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }

    @Test
    @DisplayName("02_Get List of Books with Limit Param")
    @Description("Retrieve a list of books with a limit query parameter")
    public void testGetListOfBooksWithLimitParam() {
        String endpoint = "/books?limit=3";
        String method = "GET";
        int expectedResponseCode = 200;
        String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true},{\"id\":2,\"name\":\"Just as I Am\",\"type\":\"non-fiction\",\"available\":false},{\"id\":3,\"name\":\"The Vanishing Half\",\"type\":\"fiction\",\"available\":true}]";
        String successMessage = "02 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        ApiMethods.testApiGetResponse(apiURL, endpoint, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }

    @Test
    @DisplayName("03_Get List of Books with Type Param")
    @Description("Retrieve a list of books with a type query parameter")
    public void testGetListOfBooksWithTypeParam() {
        String endpoint = "/books?type=fiction";
        String method = "GET";
        int expectedResponseCode = 200;
        String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true},{\"id\":3,\"name\":\"The Vanishing Half\",\"type\":\"fiction\",\"available\":true},{\"id\":4,\"name\":\"The Midnight Library\",\"type\":\"fiction\",\"available\":true},{\"id\":6,\"name\":\"Viscount Who Loved Me\",\"type\":\"fiction\",\"available\":true}]";
        String successMessage = "03 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        ApiMethods.testApiGetResponse(apiURL, endpoint, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }

    @Test
    @DisplayName("04_Get List of Books with Type & Limit Params")
    @Description("Retrieve a list of books with type & limit query parameters")
    public void testGetListOfBooksWithTypeAndQueryParams() {
        String endpoint = "/books?type=fiction&limit=1";
        String method = "GET";
        int expectedResponseCode = 200;
        String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true}]";
        String successMessage = "04 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        ApiMethods.testApiGetResponse(apiURL, endpoint, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }
}
