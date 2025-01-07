package AutomationProjects.Tests;

import AutomationProjects.Demoblaze.Credentials.DemoblazeAccounts;
import AutomationProjects.Demoblaze.PageObjectModel.ContactPopup;
import AutomationProjects.Demoblaze.PageObjectModel.HomePage;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicReference;

import static AutomationProjects.Demoblaze.PageObjectModel.DemoblazePage.*;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("DB003 - Contact tests")
@TestMethodOrder(MethodOrderer.MethodName.class)

public class DB003_Contact {


    AtomicReference<String> strRef = new AtomicReference<>("");

    @BeforeAll
    public static void preconditions() {
        setUp();
    }

    @Test
    @DisplayName("DB003 - All cases")
    @Description("Scénario Passant Contact")
    public void Contact() throws InterruptedException {
        DemoblazeAccounts.newAccount();
        String name = DemoblazeAccounts.getUsername();
        String email = DemoblazeAccounts.getEmail();
        String message = DemoblazeAccounts.getMessage();

        HomePage homePage = new HomePage(driver);

        homePage
                .clickContactMenu()
                .retrieveTitle(strRef)
                .assertEquals("New message", strRef.get(), "Wrong title", ContactPopup.class)
                .setContactEmail(email)
                .clickCloseButton()
                .clickContactMenu()
                .setContactName(name)
                .clickXButton()
                .clickContactMenu()
                .setContactMessage(message)
                .clickSendMessageButton()
                .acceptAndVerifyAlertText("Thanks for the message!!", "Wrong alert message"
                , HomePage.class);
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
