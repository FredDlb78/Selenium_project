package PageObjectModel.Demoblaze;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    @FindBy(xpath = "//a[@onclick='addToCart(1)']")
    private WebElement addToCartButton;
    @FindBy(id = "more-information")
    private WebElement productInformations;


    WebDriver driver;
    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddToCartButton(String errorMessage){
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Attendre jusqu'à 10 secondes
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            Assertions.assertEquals("Product added.", alertText);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assertions.fail("No alert found");
        }

    }
}
