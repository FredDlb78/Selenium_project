package AutomationProjects.Tests.Opencart;

import AutomationProjects.Opencart.AccountPage;
import AutomationProjects.Opencart.Credentials.OpencartAccount;
import AutomationProjects.Opencart.HomePage;
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
    static String firstNameMax;
    static String lastNameMax;
    static String emailMax;
    static String phoneMax;
    static String passwordMax;
    static String firstNameMin;
    static String lastNameMin;
    static String emailMin;
    static String phoneMin;
    static String passwordMin;


    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
        OpencartAccount.newAccountMaxCharacter();
        firstNameMax = OpencartAccount.getFirstNameMax();
        lastNameMax = OpencartAccount.getLastNameMax();
        emailMax = OpencartAccount.getEmailMax();
        phoneMax = OpencartAccount.getPhoneMax();
        passwordMax = OpencartAccount.getPasswordMax();
        OpencartAccount.newAccountMinCharacter();
        firstNameMin = OpencartAccount.getFirstNameMin();
        lastNameMin = OpencartAccount.getLastNameMin();
        emailMin = OpencartAccount.getEmailMin();
        phoneMin = OpencartAccount.getPhoneMin();
        passwordMin = OpencartAccount.getPasswordMin();
    }


    @Test
    @DisplayName("OP001 - Passing cases")
    @Description("Passing cases high fields limit")
    public void Signin01() {

        signinPassingCases(firstNameMax, lastNameMax, emailMax, phoneMax, passwordMax);
    }
    @Test
    @DisplayName("OP002 - Passing cases")
    @Description("Passing cases low fields limit")
    public void Signin02() {

        signinPassingCases(firstNameMin, lastNameMin, emailMin, phoneMin, passwordMin);

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
                .checkPrivacyPolicy()
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
                .retrievePasswordConfirmationErrorMessage(strRef)
                .assertContains("Password confirmation does not match password!", strRef, "Wrong error message for password confirmation", RegisterPage.class);
    return new RegisterPage(driver);
    }

    public AccountPage signinPassingCases(String firstName, String lastName, String email, String phone, String password) {

        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnRegister()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .setPassword(password)
                .setPasswordConfirmation(password)
                .selectRadioNewsletter("Yes")
                .checkPrivacyPolicy()
                .clickContinue()
                .clickContinue();
        return new AccountPage(driver);

    }

}
