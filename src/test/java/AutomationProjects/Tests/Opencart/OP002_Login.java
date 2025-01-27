package AutomationProjects.Tests.Opencart;

import AutomationProjects.Opencart.AccountPage;
import AutomationProjects.Opencart.Credentials.Account;
import AutomationProjects.Opencart.Credentials.AccountFactory;
import AutomationProjects.Opencart.HomePage;
import AutomationProjects.Opencart.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.atomic.AtomicReference;

import static AutomationProjects.Opencart.OpencartPage.*;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("OP001 - Signin tests")
@TestMethodOrder(MethodOrderer.MethodName.class)




public class OP002_Login {
    AtomicReference<String> strRef = new AtomicReference<>("");
    Account account = new AccountFactory().classicAccount();


    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
        AccountPage accountPage = new AccountPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.signinPassingCases(account.getFirstName(), account.getLastName(), account.getEmail(),
                account.getPhone(), account.getPassword());
        accountPage.clickOnLogout();
    }

    @Test
    @DisplayName("OP002 - Passing case")
    @Description("Passing case")
    public void Login01() {

        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnLogin()
                .setEmail(account.getEmail())
                .setPassword(account.getPassword())
                .clickOnLogin();
    }

    @Test
    @DisplayName("OP002 - Non passing cases")
    @Description("Non passing case - Wrong email")
    public void Login02() {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnLogin()
                .setEmail("JB007")
                .setPassword(account.getPassword())
                .clickOnLoginThenFailed()
                .retrieveNoMatchErrorMessage(strRef)
                .assertContains("Warning: No match for E-Mail Address and/or Password.", strRef, "Wrong error message for login", LoginPage.class);
    }
    @Test
    @DisplayName("OP003 - Non passing cases")
    @Description("Non passing case - Wrong password")
    public void Login03() {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnLogin()
                .setEmail(account.getEmail())
                .setPassword("bond008")
                .clickOnLoginThenFailed()
                .retrieveNoMatchErrorMessage(strRef)
                .assertContains("Warning: No match for E-Mail Address and/or Password.", strRef, "Wrong error message for login", LoginPage.class);
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
