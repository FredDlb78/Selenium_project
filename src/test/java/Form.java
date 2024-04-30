import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModelSauceDemo.MainPage;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Form {
    static FirefoxDriver driver;
    static WebDriverWait wait; // Déplacez la déclaration ici pour rendre wait accessible dans toute la classe

    @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialisez wait ici
    }

    @Test
    public void t001_setUp() {
        MainPage objMainPage = new MainPage(driver);

        // Remplissage du formulaire
        objMainPage.setUsername("Udemy");
        objMainPage.fillPassword("Test@1234");
        objMainPage.clearTextArea();
        objMainPage.fillTextArea("Ceci est un commentaire");
        objMainPage.uploadFilename("C:\\Users\\frede\\IdeaProjects\\Selenium_project\\target\\images\\image.avif");
        objMainPage.clickCheckbox("cb2");
        objMainPage.clickCheckbox("cb3");
        objMainPage.clickRadio("rd1");
        objMainPage.selectMsv("ms1");
        objMainPage.selectMsv("ms4");
        objMainPage.clickDropdown2();
        objMainPage.clickSubmit();
    }
@Test
        public void t002_checkFields(){
        // Vérifications
        WebElement chkUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("_valueusername")));
        assertEquals("Udemy", chkUsername.getText());

        WebElement chkPassword = driver.findElement(By.id("_valuepassword"));
        assertEquals("Test@1234", chkPassword.getText());

        WebElement chkComments = driver.findElement(By.id("_valuecomments"));
        assertEquals("Ceci est un commentaire", chkComments.getText());

        WebElement chkFile = driver.findElement(By.id("_valuefilename"));
        assertEquals("image.avif", chkFile.getText());

        WebElement chkCheckbox = driver.findElement(By.id("_valuecheckboxes0"));
        assertEquals("cb2", chkCheckbox.getText());
        assertNotEquals("cb3", chkCheckbox.getText());

        WebElement chkRadio = driver.findElement(By.id("_valueradioval"));
        assertEquals("rd1", chkRadio.getText());

        WebElement chkMultipleSelect = driver.findElement(By.id("_valuemultipleselect0"));
        assertEquals("ms1", chkMultipleSelect.getText());

        WebElement chkDropdown = driver.findElement(By.id("_valuedropdown"));
        assertEquals("dd2", chkDropdown.getText());

    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}