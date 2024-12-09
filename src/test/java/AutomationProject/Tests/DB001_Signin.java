package AutomationProject.Tests;

import AutomationProject.Credentials.DemoblazeAccounts;
import AutomationProject.PageObjectModel.HeaderPage;
import AutomationProject.PageObjectModel.DemoblazePage;
import AutomationProject.PageObjectModel.SignupPopup;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("DB001 - Signin tests")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB001_Signin extends DemoblazePage {
    static String username;
    static String password;

    // Cette méthode s'exécute une seule fois avant tous les tests
    @BeforeAll
    public static void testInscription() {
        DemoblazeAccounts.newAccount();
        username = DemoblazeAccounts.getUsername();
        password = DemoblazeAccounts.getPassword();
    }

    // Cette méthode s'exécute avant chaque test
    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
    }

    @Test
    @DisplayName("DB001 - All cases")
    @Description("All cases")
    public void Signin01() {
        HeaderPage headerPage = new HeaderPage(driver);
        SignupPopup signupPopup = new SignupPopup(driver);

        step("Open Sign up popup", () -> headerPage.clickSignupMenu());
        step("Fill in signup informations and submit", () -> {
            signupPopup
                    .setUsername(username)
                    .setPassword(password)
                    .clickSignUpButton()
                    .verifyAlertTextAfterSuccess("Sign up successful.", "Alert message is not correct")
                    .clickHomeMenu();
        });

        step("Open Sign up popup again", () -> headerPage.clickSignupMenu());
        step("Try signing up with the same credentials", () -> {
            signupPopup
                    .setUsername(username)
                    .setPassword(password)
                    .clickSignUpButton()
                    .verifyAlertTextAfterFailed("This user already exist.", "Alert message is not correct");
        });

        step("Try signing up with empty username", () -> {
            signupPopup
                    .setUsername("")
                    .setPassword(password)
                    .clickSignUpButton()
                    .verifyAlertTextAfterFailed("Please fill out Username and Password.",
                            "Alert message is not correct");
        });

        step("Try signing up with empty password", () -> {
            signupPopup
                    .setUsername(username)
                    .setPassword("")
                    .clickSignUpButton()
                    .verifyAlertTextAfterFailed("Please fill out Username and Password.",
                            "Alert message is not correct");
        });
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
