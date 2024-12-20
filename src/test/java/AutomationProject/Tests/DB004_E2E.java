package AutomationProject.Tests;

import AutomationProject.PageObjectModel.HomePage;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Assertions;

import static AutomationProject.PageObjectModel.DemoblazePage.*;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("DB004 - E2E tests")
@TestMethodOrder(MethodOrderer.MethodName.class)


public class DB004_E2E {
    AtomicReference<String> strRef;

    @BeforeAll
    public static void preconditions() {
        setUp();
    }


    @Test
    @DisplayName("DB004 - E2E - Cart")
    @Description("Cases:"
            + "Passing case")
    public void Cart() {

        HomePage homePage = new HomePage(driver);

        homePage.clickArticle("Samsung galaxy s6")
                .retrieveArticleName(strRef)
                .assertEquals("Samsung galaxy s6", strRef, "Wrong article name")
                .clickAddToCartButton()
                .acceptAndVerifyAlertText("Product added", "Alert text is wrong")
                .clickCartMenu()
                .clickPlaceOrder()
                .setName("Dif")
                .setCountry("CSP")
                .setCity("France")
                .setCard("007")
                .setMonth("May")
                .setYear("2025")
                .clickPurchase()
                .clickOk();

    }
}
