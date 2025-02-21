package AutomationProjects.Tests;

import AutomationProjects.SimpleBookApi.ApiMethods;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GetSingleBook {

    private final String apiURL = "https://simple-books-api.glitch.me";
    private final String lacosteURL = "https://apilayer.com/marketplace";

    @Test
    @DisplayName("01 Passing case / Get a single book by id")
    @Description("Retrieve a single book by id")
    public void testGetSingleBookById_01() {
        String endpoint = "/books/1";
        int expectedResponseCode = 200;
        String expectedResponse = "{\"id\":1,\"name\":\"The Russian\",\"author\":" +
                "\"James Patterson and James O. Born\",\"isbn\":\"1780899475\",\"type\":" +
                "\"fiction\",\"price\":12.98,\"current-stock\":12,\"available\":true}";
        String successMessage = "01 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        ApiMethods.testApiGetResponse(apiURL, endpoint, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }

    @Test
    @DisplayName("02 Non-passing case / Get a single book with an inexistent id")
    @Description("Retrieve a single book with an inexistent id")
    public void testGetSingleBookById_02() {
        String endpoint = "/books/10";
        int expectedResponseCode = 404;
        String expectedResponse = "{\"error\":\"No book with id 10\"}";
        String successMessage = "02 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 404";

        ApiMethods.testApiGetResponse(apiURL, endpoint, expectedResponseCode, expectedResponse, successMessage, errorMessage);
    }

    @Test
    @DisplayName("Exerice Lacoste")
    @Description("Lacoste")
    public void testGetSingleBookById_03() {
        String endpoint = "/google_search-api";
        int expectedResponseCode = 200;
        Map<String, String> queryParams = Map.of(
                "apiKey", "JU1wkiJF4u73ytzXEMfp5qv6L5lSj3zz",
                "q", "LACOSTE"
        );
        String expectedResponse = "<!DOCTYPE html><html lang=\"en\"><head>    <title>Google Search Results API - APILayer</title>  <meta charset=\"utf-8\" />  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">  <meta name=\"description\" content=\"Scrapes Google Search engine result pages (SERPs) and obtains a bunch of organic and paid results along with ads, related links and more.\" />  <meta name=\"keywords\" content=\"API Marketplace, Best APIs, APILayer, API, AI APIs, Content APIs, Finance APIs, Stock APIs, Web Tools APIs, Calendar APIs, Currency APIs, Data APIs, Files APIs, Finance APIs, Food APIs, Geo APIs, Images APIs, Jobs APIs, News APIs, Scraping APIs, Security APIs, Social Media APIs, Sports APIs\">  <link rel=\"shortcut icon\" href=\"/assets/favicon.ico\" />  <meta name=\"google-signin-client_id\" content=\"918427652626-8890ujna0olmp3mpuoms502b2uul2vug.apps.googleusercontent.com\">  <meta name=\"twitter:card\" content=\"summary_large_image\" /><meta name=\"twitter:site\" content=\"@apilayer\" /><meta name=\"twitter:creator\" content=\"@apilayer\" /><meta property=\"og:url\" content=\"https://apilayer.com/marketplace/google_search-api\" /><meta property=\"og:title\" content=\"Google Search Results API\" /><meta property=\"og:description\" content=\"Scrapes Google Search engine result pages (SERPs) and extracts results in JSON ";
        String successMessage = "02 - Test réussi.";
        String errorMessage = "Le code de réponse n'est pas 200";

        ApiMethods.testApiGetResponseWithParams(lacosteURL, endpoint, expectedResponseCode, expectedResponse, successMessage, errorMessage, queryParams);
    }
}


