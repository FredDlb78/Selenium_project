package DemoblazeProject.Tests;

import DemoblazeProject.Credentials.DemoblazeAccounts;
import DemoblazeProject.PageObjectModel.HeaderPage;
import DemoblazeProject.PageObjectModel.DemoblazePage;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;

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
    @DisplayName("Signin01")
    @Description("Passing case")
    public void Signin01() {
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
    @DisplayName("Signin02")
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
    @DisplayName("Signin03")
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
    @DisplayName("Signin04")
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
