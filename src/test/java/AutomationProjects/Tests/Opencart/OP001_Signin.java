package AutomationProjects.Tests.Opencart;

import AutomationProjects.Opencart.AccountPage;
import AutomationProjects.Opencart.Credentials.Account;
import AutomationProjects.Opencart.Credentials.AccountFactory;
import AutomationProjects.Opencart.HomePage;
import AutomationProjects.Opencart.OpencartPage;
import AutomationProjects.Opencart.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.atomic.AtomicReference;

import static AutomationProjects.Opencart.OpencartPage.*;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("OP001 - Signin tests")
@TestMethodOrder(MethodOrderer.MethodName.class)

public class OP001_Signin {
    AtomicReference<String> strRef = new AtomicReference<>("");

    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
    }


    @Test
    @DisplayName("OP001 - Passing cases")
    @Description("Passing cases high fields limit")
    public void Signin01() {
        Account accountMax = new AccountFactory().newAccountMaxCharacter();
        HomePage homePage = new HomePage(driver);
        homePage.signinPassingCases(accountMax.getFirstName(), accountMax.getLastName(), accountMax.getEmail(),
                accountMax.getPhone(), accountMax.getPassword());
    }
    @Test
    @DisplayName("OP002 - Passing cases")
    @Description("Passing cases low fields limit")
    public void Signin02() {
        Account accountMin = new AccountFactory().newAccountMinCharacter();
        HomePage homePage = new HomePage(driver);
        homePage.signinPassingCases(accountMin.getFirstName(), accountMin.getLastName(), accountMin.getEmail(),
                accountMin.getPhone(), accountMin.getPassword());

    }

    @Test
    @DisplayName("OP003 - Non passing cases")
    @Description("Low fields limit -1")
    public void Signin03() {

        signinNonPassingCases("", "", "", "78", "B2°",
                "", "hello"
        );
    }

    @Test
    @DisplayName("OP004 - Non passing cases")
    @Description("High fields limit +1")
    public void Signin04() {

        signinNonPassingCases("abcdefghijklmnopqrstuvwxyz@!6*%é'",
                "abcdefghijklmnopqrstuvwxyz@!6*%é'",
                "", "abcdefghijklmnopqrstuvwxyz@!6*%é'",
                "abcdefghijklmno@!6*%é'",
                "", "abcdefghijklmno@!6*%é'"
        );
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }

    public RegisterPage signinNonPassingCases (String firstName, String lastName, String email, String phone,
                                               String password, String passwordConfirmation, String password2ndTry) {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnRegister()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .setPassword(password)
                .setPasswordConfirmation(passwordConfirmation)
                .selectRadioNewsletter("Yes")
                .clickContinueThenFailed()
                .retrieveFirstNameErrorMessage(strRef)
                .assertContains("First Name must be between 1 and 32 characters!", strRef, "Wrong error message for first name", RegisterPage.class)
                .retrieveLastNameErrorMessage(strRef)
                .assertContains("Last Name must be between 1 and 32 characters!", strRef, "Wrong error meesage for last name", RegisterPage.class)
                .retrieveEmailErrorMessage(strRef)
                .assertContains("E-Mail Address does not appear to be valid!", strRef, "Wrong error message for email", RegisterPage.class)
                .retrieveTelephoneErrorMessage(strRef)
                .assertContains("Telephone must be between 3 and 32 characters!", strRef, "Wrong error message for Telephone", RegisterPage.class)
                .retrievePasswordErrorMessage(strRef)
                .assertContains("Password must be between 4 and 20 characters!", strRef, "Wrong error message for password", RegisterPage.class)
                .setPassword(password2ndTry)
                .clickContinueThenFailed()
                .retrievePrivacyPolicyErrorMessage(strRef)
                .assertContains("Warning: You must agree to the Privacy Policy!", strRef, "Wrong error message for Privacy Policy", RegisterPage.class)
                .retrievePasswordConfirmationErrorMessage(strRef)
                .assertContains("Password confirmation does not match password!", strRef, "Wrong error message for password confirmation", RegisterPage.class);
    return new RegisterPage(driver);
    }



}
