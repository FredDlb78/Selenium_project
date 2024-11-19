package DemoblazeProject.Tests;

import DemoblazeProject.Credentials.DemoblazeAccounts;
import DemoblazeProject.PageObjectModel.HeaderPage;
import DemoblazeProject.PageObjectModel.DemoblazePage;
import io.qameta.allure.Step;
import io.qameta.allure.junit5.AllureJunit5;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;

@ExtendWith(AllureJunit5.class)


@Timeout(60*2)
@DisplayName("DB001 - Signin tests")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB001_Signin extends DemoblazePage {
    static String username;
    static String password;

    @BeforeAll
    public static void testInscription() {
        DemoblazeAccounts.newAccount();
        username = DemoblazeAccounts.getUsername();
        password = DemoblazeAccounts.getPassword();
    }

    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
    }

    @Test
    @DisplayName("DB001T01 - Passing Case")
    @Description("Passing case")
    public void Signin01() {
        HeaderPage headerPage = new HeaderPage(driver);

        HeaderPage step1 = step("Signin with valid informations",
                () ->
        headerPage
                .clickSignupMenu()
                .setUsername(username)
                .setPassword(password)
                .clickSignUpButton()
                .verifyAlertTextAfterSuccess("Sign up successful.", "Alert message is not correct")
                .clickHomeMenu()
        );
    }

    @Test
    @DisplayName("DB001T02 - Non-passing Case - User already registered")
    @Description("Non-passing case - User already exists")
    public void Signin02() {
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage
                .clickSignupMenu()
                .setUsername(username)
                .setPassword(password)
                .clickSignUpButton()
                .verifyAlertTextAfterFailed("This user already exist.", "Alert message is not correct");
    }

    @Test
    @DisplayName("DB001T03 - Non-passing Case - Empty username")
    @Description("Non-passing case - Not filling the username field")
    public void Signin03() {
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage
                .clickSignupMenu()
                .setUsername("")
                .setPassword(password)
                .clickSignUpButton()
                .verifyAlertTextAfterFailed("Please fill out Username and Password.",
                        "Alert message is not correct");
    }

    @Test
    @DisplayName("DB001T03 - Non-passing Case - Empty password")
    @Description("Non-passing case - Not filling the password field")
    public void Signin04() {
        HeaderPage headerPage = new HeaderPage(driver);

        headerPage
                .clickSignupMenu()
                .setUsername(username)
                .setPassword("")
                .clickSignUpButton()
                .verifyAlertTextAfterFailed("Please fill out Username and Password.",
                        "Alert message is not correct");
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
