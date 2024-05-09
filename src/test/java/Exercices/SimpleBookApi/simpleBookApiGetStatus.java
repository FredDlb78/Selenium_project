package Exercices.SimpleBookApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class SimpleBookApiGetStatus {

    public static void main(String[] args) {
        String apiURL = "https://simple-books-api.glitch.me";

        try {
            URL url = new URL(apiURL + "/status");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            int expectedCode = 200;
            if (responseCode != expectedCode) {
                throw new RuntimeException("Le code de réponse n'est pas 200. Code: " + responseCode);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Vérification du contenu de la réponse
            String expectedResponse = "{\"status\":\"OK\"}";
            String actualResponse = response.toString();
            if (!actualResponse.equals(expectedResponse)) {
                throw new RuntimeException("Le contenu de la réponse est différent de celui attendu.");
            }

            System.out.println("Test réussi. Statut de l'API : " + response.toString());

            connection.disconnect();
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}