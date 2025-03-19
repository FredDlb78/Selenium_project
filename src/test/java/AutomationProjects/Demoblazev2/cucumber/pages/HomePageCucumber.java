package AutomationProjects.Demoblazev2.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageCucumber extends HeaderPageCucumber {
    private WebDriverWait wait;

    public HomePageCucumber(WebDriver driver) {
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

    public void navigateToHomePage() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
    }
}
