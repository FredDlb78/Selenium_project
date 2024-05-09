package Exercices.SimpleBookApi;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SimpleBookApiGetListOfBooks {

    @Test
    @DisplayName("01_Get Complete List of Books")
    @Description("Retrieve the complete list of books")
    public void testGetCompleteListOfBooks() {
        String apiURL = "https://simple-books-api.glitch.me";

        try {
            URL url = new URL(apiURL + "/books");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            assertEquals(200, responseCode, "Le code de réponse n'est pas 200");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérification du contenu de la réponse
            String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true},{\"id\":2,\"name\":\"Just as I Am\",\"type\":\"non-fiction\",\"available\":false},{\"id\":3,\"name\":\"The Vanishing Half\",\"type\":\"fiction\",\"available\":true},{\"id\":4,\"name\":\"The Midnight Library\",\"type\":\"fiction\",\"available\":true},{\"id\":5,\"name\":\"Untamed\",\"type\":\"non-fiction\",\"available\":true},{\"id\":6,\"name\":\"Viscount Who Loved Me\",\"type\":\"fiction\",\"available\":true}]";
            String actualResponse = response.toString();
            assertEquals(expectedResponse, actualResponse, "Le contenu de la réponse est incorrect.");

            System.out.println("01 - Test réussi. Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("02_Get List of Books with Limit Param")
    @Description("Retrieve a list of books with a limit query parameter")
    public void testGetListOfBooksWithLimitParam() {
        String apiURL = "https://simple-books-api.glitch.me";

        try {
            URL url = new URL(apiURL + "/books?limit=3");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            assertEquals(200, responseCode, "Le code de réponse n'est pas 200");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérification du contenu de la réponse
            String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true},{\"id\":2,\"name\":\"Just as I Am\",\"type\":\"non-fiction\",\"available\":false},{\"id\":3,\"name\":\"The Vanishing Half\",\"type\":\"fiction\",\"available\":true}]";
            String actualResponse = response.toString();
            assertEquals(expectedResponse, actualResponse, "Le contenu de la réponse est incorrect.");

            System.out.println("02 - Test réussi. Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }
    @Test
    @DisplayName("03_Get List of Books with Type Param")
    @Description("Retrieve a list of books with a type query parameter")
    public void testGetListOfBooksWithTypeParam() {
        String apiURL = "https://simple-books-api.glitch.me";

        try {
            URL url = new URL(apiURL + "/books?type=fiction");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            assertEquals(200, responseCode, "Le code de réponse n'est pas 200");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérification du contenu de la réponse
            String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true},{\"id\":3,\"name\":\"The Vanishing Half\",\"type\":\"fiction\",\"available\":true},{\"id\":4,\"name\":\"The Midnight Library\",\"type\":\"fiction\",\"available\":true},{\"id\":6,\"name\":\"Viscount Who Loved Me\",\"type\":\"fiction\",\"available\":true}]";
            String actualResponse = response.toString();
            assertEquals(expectedResponse, actualResponse, "Le contenu de la réponse est incorrect.");

            System.out.println("03 - Test réussi. Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }
    @Test
    @DisplayName("04_Get List of Books with Type & Limit Params")
    @Description("Retrieve a list of books with type & limit query parameters")
    public void testGetListOfBooksWithTypeAndQueryParams() {
        String apiURL = "https://simple-books-api.glitch.me";

        try {
            URL url = new URL(apiURL + "/books?type=fiction&limit=1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            assertEquals(200, responseCode, "Le code de réponse n'est pas 200");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérification du contenu de la réponse
            String expectedResponse = "[{\"id\":1,\"name\":\"The Russian\",\"type\":\"fiction\",\"available\":true}]";
            String actualResponse = response.toString();
            assertEquals(expectedResponse, actualResponse, "Le contenu de la réponse est incorrect.");

            System.out.println("04 - Test réussi. Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }
}
