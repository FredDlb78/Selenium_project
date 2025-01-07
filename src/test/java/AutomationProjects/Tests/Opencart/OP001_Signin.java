package AutomationProjects.Tests.Opencart;

import AutomationProjects.Opencart.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static AutomationProjects.Opencart.OpencartPage.*;

@ExtendWith(AllureJunit5.class)
@Timeout(60 * 2)
@DisplayName("OP001 - Signin tests")
@TestMethodOrder(MethodOrderer.MethodName.class)

public class OP001_Signin {
    @BeforeEach
    public void setUpBeforeEach() {
        setUp();
    }

    @Test
    @DisplayName("OP001 - All cases")
    @Description("All cases")
    public void Signin01() {
        HomePage homePage = new HomePage(driver);

        homePage.clickOnMyAccount()
                .clickOnRegister()
                .setFirstName("James")
                .setLastName("Bidon")
                .setEmail("Bond007@gmail.com")
                .setPhone("007007007")
                .setPassword("Sisibg78")
                .setPasswordConfirmation("Sisibg78")
                .selectRadioNewsletter("Yes")
                .checkPrivacyPolicy()
                .clickContinue()
                .clickContinue();
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }
}
