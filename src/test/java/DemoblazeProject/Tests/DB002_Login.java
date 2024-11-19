package DemoblazeProject.Tests;

import DemoblazeProject.Credentials.DemoblazeAccounts;
import DemoblazeProject.PageObjectModel.DemoblazePage;
import DemoblazeProject.PageObjectModel.HeaderPage;
import org.junit.jupiter.api.*;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                .clickSignUpMenu()
                .setUsername(username)
                .setPassword(password)
                .clickSignupButton()
                .verifyAlertTextAfterSuccess("Sign up successful.", "Alert message is not correct")
                .clickHomeMenu();
    }

    @Test
    @DisplayName("Login")
    public void Login() {
        strRef = new AtomicReference<>();
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage
                .clickLoginMenu()
                //Wrong username
                .setUsername(wrongUsername)
                .setPassword(password)
                .clickLoginButtonThenFailed()
                .verifyAlertTextAfterFailed("User does not exist.",
                        "Alert message is not correct")
                //Wrong password
                .setUsername(username)
                .setPassword(wrongPassword)
                .clickLoginButtonThenFailed()
                .verifyAlertTextAfterFailed("Wrong password.",
                        "Alert message is not correct")
                //Empty username
                .setUsername("")
                .setPassword(password)
                .clickLoginButtonThenFailed()
                .verifyAlertTextAfterFailed("Please fill out Username and Password.",
                        "Alert message is not correct")
                //Empty password
                .setUsername(wrongUsername)
                .setPassword("")
                .clickLoginButtonThenFailed()
                .verifyAlertTextAfterFailed("Please fill out Username and Password.",
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
