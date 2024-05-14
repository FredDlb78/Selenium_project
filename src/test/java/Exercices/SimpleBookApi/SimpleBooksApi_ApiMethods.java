package Exercices.SimpleBookApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SimpleBooksApi_ApiMethods {

    public static void testApiResponse(String apiURL, String endpoint, String method, int expectedResponseCode, String expectedResponse, String successMessage, String errorMessage) {
        try {
            URL url = new URL(apiURL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);

            int responseCode = connection.getResponseCode();
            assertEquals(expectedResponseCode, responseCode, errorMessage);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérification du contenu de la réponse
            String actualResponse = response.toString();
            assertEquals(expectedResponse, actualResponse, "Le contenu de la réponse est incorrect.");

            System.out.println(successMessage + " Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }
    public static void testGetSingleBookById(String apiURL, String bookId, int expectedResponseCode, String expectedResponse, String successMessage, String errorMessage) {
        try {
            URL url = new URL(apiURL + "/books/" + bookId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            assertEquals(expectedResponseCode, responseCode, errorMessage);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérification du contenu de la réponse
            String actualResponse = response.toString();
            assertEquals(expectedResponse, actualResponse, "Le contenu de la réponse est incorrect.");

            System.out.println(successMessage + " Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }
}
