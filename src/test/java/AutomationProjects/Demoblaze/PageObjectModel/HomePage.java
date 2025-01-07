package AutomationProjects.Demoblaze.PageObjectModel;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//a[@class=\"carousel-control-prev\"]")
    private WebElement leftArrowButton;
    @FindBy(xpath = "//a[@class=\"carousel-control-next\"]")
    private WebElement rightArrowButton;
    @FindBy(id = "prev2")
    private WebElement previousButton;
    @FindBy(id = "next2")
    private WebElement nextButton;
    @FindBy(xpath = "//a[@onclick=\"byCat('phone')\"]")
    private WebElement phoneCateg;
    @FindBy(xpath = "//a[@onclick=\"byCat('notebook')\"]")
    private WebElement laptopsCateg;
    @FindBy(xpath = "//a[@onclick=\"byCat('monitor')\"]")
    private WebElement monitorCateg;

    public ArticlePage clickArticle(String articleName) {
        String xpath = String.format("//a[contains(text(), '%s')]", articleName);
        WebElement article = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        article.click();
        return new ArticlePage(driver);
    }

    @Step("Click on left arrow")
    public HomePage clickleftArrow() {
        leftArrowButton.click();
        return this;
    }
    @Step("Click on right arrow")
    public HomePage clickrightArrow() {
        rightArrowButton.click();
        return this;
    }
    @Step("Click on previous button")
    public HomePage clickPrevious() {
        previousButton.click();
        return this;
    }
    @Step("Click on next button")
    public HomePage clickNext() {
        nextButton.click();
        return this;
    }
    @Step("Click on phones category")
    public HomePage clickPhoneCategory() {
        phoneCateg.click();
        return this;
    }
    @Step("Click on laptops category")
    public HomePage clickLaptopsCategory() {
        laptopsCateg.click();
        return this;
    }
    @Step("Click on monitors category")
    public HomePage clickMonitorsCategory() {
        monitorCateg.click();
        return this;
    }


}
