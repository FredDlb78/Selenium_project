package AutomationProjects.Tests.Opencart;

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

    static String firstName;
    static String lastName;
    static String email;
    static String phone;
    static String password;

    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
        OpencartAccount.newAccount();
        firstName = OpencartAccount.getFirstName();
        lastName = OpencartAccount.getLastName();
        email = OpencartAccount.getEmail();
        phone = OpencartAccount.getPhone();
        password = OpencartAccount.getPassword();
    }


//    @Test
    @DisplayName("OP001 - Passing cases")
    @Description("Passing cases")
    public void Signin01() {

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
    }

    @Test
    @DisplayName("OP002 - Non passing cases")
    @Description("Low fields limit")
    public void Signin02() {

        signinNonPassingCases("", "", "", "78", "B2°",
                "", "hello"
        );
    }

    @Test
    @DisplayName("OP003 - Non passing cases")
    @Description("High fields limit")
    public void Signin03() {

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

    public RegisterPage signinNonPassingCases (String firstNameBis, String lastNameBis, String emailBis, String phoneBis,
                                               String passwordBis, String passwordConfirmationBis, String password2ndTry) {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnRegister()
                .setFirstName(firstNameBis)
                .setLastName(lastNameBis)
                .setEmail(emailBis)
                .setPhone(phoneBis)
                .setPassword(passwordBis)
                .setPasswordConfirmation(passwordConfirmationBis)
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


}
