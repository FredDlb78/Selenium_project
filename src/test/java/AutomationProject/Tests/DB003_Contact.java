package AutomationProject.Tests;

import AutomationProject.Credentials.DemoblazeAccounts;
import AutomationProject.PageObjectModel.HeaderPage;
import AutomationProject.PageObjectModel.HomePage;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicReference;

import static AutomationProject.PageObjectModel.DemoblazePage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("DB003 - Contact tests")
@TestMethodOrder(MethodOrderer.MethodName.class)

public class DB003_Contact {


    AtomicReference<String> strRef;

    @BeforeAll
    public static void preconditions() {
        setUp();
    }

    @Test
    @DisplayName("DB003 - All cases")
    @Description("Scénario Passant Contact")
    public void Contact() {
        DemoblazeAccounts.newAccount();
        String name = DemoblazeAccounts.getUsername();
        String email = DemoblazeAccounts.getEmail();
        String message = DemoblazeAccounts.getMessage();

        HeaderPage headerPage = new HeaderPage(driver);

        headerPage
                .clickContactMenu()
                .assertTitleEquals("New message")
                .setContactEmail(email)
                .clickCloseButton() //ajouter un temps de pause
                .clickContactMenu()
                .setContactName(name)
                .clickXButton() //ajouter un temps de pause
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