package AutomationProjects.SimpleBookApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class ApiMethods {

    public static void testApiGetResponse(String apiURL, String endpoint, int expectedResponseCode, String expectedResponse, String successMessage, String errorMessage) {
        try {
            URL url = new URL(apiURL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            assertEquals(expectedResponseCode, responseCode, errorMessage);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    responseCode == 200 ? connection.getInputStream() : connection.getErrorStream()
            ));
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

    public static void testApiGetResponseWithParams(String apiURL, String endpoint, int expectedResponseCode, String expectedResponse, String successMessage, String errorMessage, Map<String, String> queryParams) {
        try {
            StringBuilder urlWithParams = new StringBuilder(apiURL + endpoint);
            if (queryParams != null && !queryParams.isEmpty()) {
                urlWithParams.append("?");
                for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                    urlWithParams.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8.toString()))
                            .append("=")
                            .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString()))
                            .append("&");
                }
            }

            URL url = new URL(urlWithParams.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            assertEquals(expectedResponseCode, responseCode, errorMessage);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    responseCode == 200 ? connection.getInputStream() : connection.getErrorStream()
            ));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String actualResponse = response.toString();
            System.out.println(actualResponse);
            assertTrue(actualResponse.contains(expectedResponse), "Le contenu de la réponse est incorrect.");

            System.out.println(successMessage + " Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }

    public static void testApiPostResponse(String apiURL, String endpoint, String requestBody, String authToken, int expectedResponseCode, String expectedStaticResponsePart, String successMessage, String errorMessage) {
        try {
            URL url = new URL(apiURL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", authToken); // Ajouter le token d'authentification

            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            assertEquals(expectedResponseCode, responseCode, errorMessage);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    responseCode == 201 ? connection.getInputStream() : connection.getErrorStream(), "utf-8"
            ));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String actualResponse = response.toString();
            JSONObject jsonResponse = new JSONObject(actualResponse);
            JSONObject jsonExpected = new JSONObject(expectedStaticResponsePart);

            // Check the static part of the response
            assertEquals(jsonExpected.getBoolean("created"), jsonResponse.getBoolean("created"), "Le contenu de la réponse est incorrect pour le champ 'created'.");

            // Check if orderId is present
            assertTrue(jsonResponse.has("orderId"), "Le champ 'orderId' est manquant dans la réponse.");

            System.out.println(successMessage + " Code de réponse de l'API : " + responseCode);

            connection.disconnect();
        } catch (Exception e) {
            fail("Erreur : " + e.getMessage());
        }
    }
}
