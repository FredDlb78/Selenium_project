package AutomationProjects.Tests;

import AutomationProjects.Demoblaze.Credentials.DemoblazeAccounts;
import AutomationProjects.Demoblaze.PageObjectModel.DemoblazePage;
import AutomationProjects.Demoblaze.PageObjectModel.HomePage;
import AutomationProjects.Demoblaze.PageObjectModel.SignupPopup;
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

    public DB001_Signin() {
        super(driver);
    }

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
        HomePage homePage = new HomePage(driver);
        SignupPopup signupPopup = new SignupPopup(driver);

        step("Open Sign up popup", () -> homePage.clickSignupMenu());
        step("Fill in signup informations and submit", () -> {
            signupPopup
                    .setUsername(username)
                    .setPassword(password)
                    .clickSignUpButton()
                    .acceptAndVerifyAlertText("Sign up successful.", "Alert message is not correct", HomePage.class)
                    .clickHomeMenu();
        });

        step("Open Sign up popup again", () -> homePage.clickSignupMenu());
        step("Try signing up with the same credentials", () -> {
            signupPopup
                    .setUsername(username)
                    .setPassword(password)
                    .clickSignUpButton()
                    .acceptAndVerifyAlertText("This user already exist.", "Alert message is not correct", SignupPopup.class);
                    //To do: Vérifier le titre de la popup
        });

        step("Try signing up with empty username", () -> {
            signupPopup
                    .setUsername("")
                    .setPassword(password)
                    .clickSignUpButton()
                    .acceptAndVerifyAlertText("Please fill out Username and Password.",
                            "Alert message is not correct", SignupPopup.class);
            //To do: Vérifier le titre de la popup
        });

        step("Try signing up with empty password", () -> {
            signupPopup
                    .setUsername(username)
                    .setPassword("")
                    .clickSignUpButton()
                    .acceptAndVerifyAlertText("Please fill out Username and Password.",
                            "Alert message is not correct", SignupPopup.class);
        });
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
