package exDemoblaze;


import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectModelDemoblaze.HeaderPage;
import pageObjectModelDemoblaze.HomePage;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class DB001_Login {
    static FirefoxDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("DB001_Login")
    @Description("DB_EE001 - Login")

    public void Login01_LoginOk() throws InterruptedException {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        Assertions.assertTrue(objHomePage.getCurrentUrlWeb());
        objHeaderPage.clickSignUpButton();
        //Assertions.assertTrue(objHeaderPage.isTitleCorrect("Sign up"));
        objHeaderPage.setUsernameSignUpPopup("Fredinho78");
        objHeaderPage.setPasswordSignUpPopup("Test@1234");
        objHeaderPage.clickSignupButtonSignupPopup();



    }


    @AfterAll

    public static void tearDown(){
        driver.quit();
    }
}
