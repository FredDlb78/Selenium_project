package AutomationProject.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends HeaderPage {
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public ArticlePage clickArticle(String articleName) {
        String xpath = String.format("//a[contains(text(), '%s')]", articleName);
        WebElement article = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        article.click();
        return new ArticlePage(driver);
    }
}
