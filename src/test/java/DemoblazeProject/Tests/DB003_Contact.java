package DemoblazeProject.Tests;

import DemoblazeProject.Credentials.DemoblazeAccounts;
import DemoblazeProject.PageObjectModel.ContactPopup;
import DemoblazeProject.PageObjectModel.DemoblazePage;
import DemoblazeProject.PageObjectModel.HeaderPage;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicReference;

import static DemoblazeProject.PageObjectModel.DemoblazePage.*;
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
    @Description("")
    public void Contact() {
        String name = DemoblazeAccounts.getUsername();
        String email = DemoblazeAccounts.getEmail();
        String message = DemoblazeAccounts.getMessage();
        strRef = new AtomicReference<>();
        HeaderPage headerPage = new HeaderPage(driver);
        ContactPopup contactPopup = new ContactPopup(driver);

        headerPage
                .clickContactMenu()
            //    .retrieveTitle(strRef)
                .setContactEmail(email)
                .setContactName(name)
                .setContactMessage(message)
                .clickSendMessageButton();
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
