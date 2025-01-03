package AutomationProject.Tests;

import AutomationProject.Credentials.DemoblazeAccounts;
import AutomationProject.PageObjectModel.DemoblazePage;
import AutomationProject.PageObjectModel.HeaderPage;
import AutomationProject.PageObjectModel.HomePage;
import AutomationProject.PageObjectModel.LoginPopup;
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

    public DB002_Login() {
        super(driver);
    }

    @BeforeAll
    public static void testInscription() {
        DemoblazeAccounts.newAccount();
        username = DemoblazeAccounts.getUsername();
        password = DemoblazeAccounts.getPassword();
        setUp();
        HomePage homePage = new HomePage(driver);

        homePage
                .clickSignupMenu()
                .setUsername(username)
                .setPassword(password)
                .clickSignUpButton()
                .acceptAndVerifyAlertText("Sign up successful.", "Alert message is not correct", HomePage.class)
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
        HeaderPage headerPage = new HeaderPage();

        headerPage
                .clickLoginMenu()
                //Wrong username
                .setUsername(wrongUsername)
                .setPassword(password)
                .clickLoginButtonThenFailed()
                .acceptAndVerifyAlertText("User does not exist.",
                        "Alert message is not correct", LoginPopup.class)
                //Wrong password
                .setUsername(username)
                .setPassword(wrongPassword)
                .clickLoginButtonThenFailed()
                .acceptAndVerifyAlertText("Wrong password.",
                        "Alert message is not correct", LoginPopup.class)
                //Empty username
                .setUsername("")
                .setPassword(password)
                .clickLoginButtonThenFailed()
                .acceptAndVerifyAlertText("Please fill out Username and Password.",
                        "Alert message is not correct", LoginPopup.class)
                //Empty password
                .setUsername(wrongUsername)
                .setPassword("")
                .clickLoginButtonThenFailed()
                .acceptAndVerifyAlertText("Please fill out Username and Password.",
                        "Alert message is not correct", LoginPopup.class)
                .setUsername(username)
                .setPassword(password)
                .clickLoginButton()
                .retrieveWelcomeUsername(strRef)
                .assertEquals("Welcome " + username, strRef.get(),
                "Welcome username is not correctly displayed", HeaderPage.class);
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
