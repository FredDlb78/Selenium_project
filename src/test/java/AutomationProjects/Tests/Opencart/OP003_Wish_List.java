package AutomationProjects.Tests.Opencart;


import AutomationProjects.Opencart.ArticlePage;
import AutomationProjects.Opencart.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicReference;

import static AutomationProjects.Demoblaze.PageObjectModel.DemoblazePage.tearDown;
import static AutomationProjects.Opencart.OpencartPage.driver;
import static AutomationProjects.Opencart.OpencartPage.setUp;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("OP003 - Wish List tests")
@TestMethodOrder(MethodOrderer.MethodName.class)


public class OP003_Wish_List {
    AtomicReference<String> strRef = new AtomicReference<>("");

    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
    }

    @Test
    @DisplayName("OP003 - Passing cases")
    @Description("Article added to Wish List")
    public void WishList01() {

        HomePage homePage = new HomePage(driver);

        homePage.clickArticle("MacBook")
                .getArticleName("MacBook", strRef)
                .assertContains("MacBook", strRef.get(), "Wrong article name", ArticlePage.class)
                .getArticlePrice(strRef)
                .assertContains("$602.00", strRef, "Wrong Price", ArticlePage.class);

    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }

}
