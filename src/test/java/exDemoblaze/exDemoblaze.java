package exDemoblaze;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjectModelDemoblaze.HeaderPage;
import pageObjectModelDemoblaze.HomePage;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class exDemoblaze {
    static FirefoxDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
    }

    @Test

    public void t001_test() throws InterruptedException {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);


        objHomePage.clickSamsungGalaxyS6();



    }


    @AfterAll

    public static void tearDown(){
        driver.quit();
    }
}
