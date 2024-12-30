package AutomationProject.Tests;

import AutomationProject.PageObjectModel.ArticlePage;
import AutomationProject.PageObjectModel.HomePage;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicReference;

import static AutomationProject.PageObjectModel.DemoblazePage.*;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("DB004 - E2E tests")
@TestMethodOrder(MethodOrderer.MethodName.class)


public class DB004_E2E {
AtomicReference<String> strRef = new AtomicReference<>("");

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
                .assertEquals("Samsung galaxy s6", strRef.get(), "Wrong article name", ArticlePage.class)
                .retrieveArticlePrice(strRef)
                .assertEquals("$360 *includes tax", strRef.get(), "Wrong article price", ArticlePage.class)
                .retrieveArticleDescription(strRef)
                .assertEquals("Product description\n" +
                        "The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM." +
                        " The phone packs 32GB of internal storage cannot be expanded.",
                        strRef.get(), "Wrong article Description", ArticlePage.class)
                .checkImageIsDisplayed("galaxy_s6")
                .clickAddToCartButton()
                .acceptAndVerifyAlertText("Product added", "Alert text is wrong", HomePage.class)
                .clickHomeMenu()
                .clickArticle("Nokia lumia 1520")
                .retrieveArticleName(strRef)
                .assertEquals("Nokia lumia 1520", strRef.get(), "Wrong article name", ArticlePage.class)
                .retrieveArticlePrice(strRef)
                .assertEquals("$820 *includes tax", strRef.get(), "Wrong article price", ArticlePage.class)
                .retrieveArticleDescription(strRef)
                .assertEquals("Product description\n" +
                                "The Nokia Lumia 1520 is powered by 2.2GHz quad-core Qualcomm Snapdragon 800 processor" +
                                " and it comes with 2GB of RAM.",
                        strRef.get(), "Wrong article Description", ArticlePage.class)
                .checkImageIsDisplayed("Lumia_1520")
                .clickAddToCartButton()
                .acceptAndVerifyAlertText("Product added", "Alert text is wrong", HomePage.class)
                .clickCartMenu()
                .clickPlaceOrder()
                .setName("Fred")
                .setCountry("Paname")
                .setCity("Fronce")
                .setCard("007")
                .setMonth("May")
                .setYear("2025")
                .clickPurchase()
                .clickOk();

    }
    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
