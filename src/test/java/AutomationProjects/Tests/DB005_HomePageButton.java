package AutomationProjects.Tests;

import AutomationProjects.Demoblaze.PageObjectModel.HomePage;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static AutomationProjects.Demoblaze.PageObjectModel.DemoblazePage.*;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("DB005 - HomePage buttons tests")
@TestMethodOrder(MethodOrderer.MethodName.class)


public class DB005_HomePageButton {

    @BeforeAll
    public static void preconditions() {
        setUp();
    }
    @Test
    @DisplayName("DB005 - HomePage buttons test - HomePage")
    @Description("Cases:"
            + "Passing case")
    public void HomePage() {

        HomePage homePage = new HomePage(driver);



    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
