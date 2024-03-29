import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Form {
    @Test
    public void t001_setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();

        // Ajouter une attente explicite
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Remplissage du formulaire
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement textArea = driver.findElement(By.cssSelector("textarea[name='comments']"));
        WebElement filename = driver.findElement(By.cssSelector("input[name='filename']"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[value='cb2']"));
        WebElement checkbox3 = driver.findElement(By.cssSelector("input[value='cb3']"));
        WebElement radio1 = driver.findElement(By.xpath("//input[@value='rd1']"));
        WebElement msv1 = driver.findElement(By.cssSelector("option[value='ms1']"));
        WebElement msv4 = driver.findElement(By.cssSelector("option[value='ms4']"));
        WebElement dropdown2 = driver.findElement(By.cssSelector("option[value='dd2']"));
        WebElement submit = driver.findElement(By.cssSelector("input[value='submit']"));

        username.sendKeys("Udemy");
        password.sendKeys("Test@1234");
        textArea.clear();
        textArea.sendKeys("Ceci est un commentaire");
        filename.sendKeys("C:\\Users\\frede\\IdeaProjects\\Selenium_project\\target\\images\\image.avif");
        checkbox2.click();
        checkbox3.click();
        radio1.click();
        msv1.click();
        // Maintenir la touche CTRL pour sélectionner plusieurs options dans un menu déroulant multiple
        msv4.click();
        dropdown2.click();
        submit.click();

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

        driver.quit();
    }
}