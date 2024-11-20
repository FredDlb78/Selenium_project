package DemoblazeProject.Tests;

import DemoblazeProject.Credentials.DemoblazeAccounts;
import DemoblazeProject.PageObjectModel.DemoblazePage;
import DemoblazeProject.PageObjectModel.HeaderPage;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("DB002 - Login tests")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB002_Login extends DemoblazePage {

    static String username;
    static String password;
    String wrongUsername = "wrongUsername123456789";
    String wrongPassword = "wrongPassword123456789";
    AtomicReference<String> strRef;

    @BeforeAll
    public static void testInscription() {
        DemoblazeAccounts.newAccount();
        username = DemoblazeAccounts.getUsername();
        password = DemoblazeAccounts.getPassword();
        setUp();
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage
                .clickSignupMenu()
                .setUsername(username)
                .setPassword(password)
                .clickSignUpButton()
                .verifyAlertTextAfterSuccess("Sign up successful.", "Alert message is not correct")
                .clickHomeMenu();
    }

    @Test
    @DisplayName("DB002 - All cases")
    @Description("Cases:" +
            "- Wrong username" +
            "- Wrong password" +
            "- Empty username" +
            "- Empty password" +
            "- Passing case")
    public void Login() {
        strRef = new AtomicReference<>();
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage
                .clickLoginMenu()
                //Wrong username
                .setUsername(wrongUsername)
                .setPassword(password)
                .clickLoginButtonThenFailed()
                .verifyAlertTextThenFailed("User does not exist.",
                        "Alert message is not correct")
                //Wrong password
                .setUsername(username)
                .setPassword(wrongPassword)
                .clickLoginButtonThenFailed()
                .verifyAlertTextThenFailed("Wrong password.",
                        "Alert message is not correct")
                //Empty username
                .setUsername("")
                .setPassword(password)
                .clickLoginButtonThenFailed()
                .verifyAlertTextThenFailed("Please fill out Username and Password.",
                        "Alert message is not correct")
                //Empty password
                .setUsername(wrongUsername)
                .setPassword("")
                .clickLoginButtonThenFailed()
                .verifyAlertTextThenFailed("Please fill out Username and Password.",
                        "Alert message is not correct")
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton()
                .retrieveWelcomeUsername(strRef);
        assertEquals("Welcome " + username, strRef.get(),
                "Welcome username is not correctly displayed");
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
