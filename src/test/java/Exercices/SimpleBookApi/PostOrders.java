package Exercices.SimpleBookApi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

class PostOrder {

    private final String apiURL = "https://simple-books-api.glitch.me";

//    @Test
//    public void testCreateOrder() {
//        String endpoint = "/orders";
//        String requestBody = "{" +
//                " \"bookId\": 4," +
//                " \"customerName\": \"Fred\"" +
//                " }";
//        int expectedResponseCode = 201;
//        String expectedStaticResponsePart = "{\"created\":true}";
//        String successMessage = "01 - Order creation test passed.";
//        String errorMessage = "Failed to create order, response code is not 201";
//        String authToken = "Bearer 8e98dffd19b4e5fc2d7e30e08aad1896fdf90b39a94d138f80e41bf357e04d64";
//
//        try {
//            ApiMethods.testApiPostResponse(apiURL, endpoint, requestBody, authToken,
//                    expectedResponseCode, expectedStaticResponsePart, successMessage, errorMessage);
//        } catch (Exception e) {
//            fail("Erreur : " + e.getMessage());
//        }
//    }
}
