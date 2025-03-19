package AutomationProjects.Demoblazev2.cucumber.steps;

import AutomationProjects.Demoblazev2.cucumber.pages.HomePageCucumber;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppSteps {
    WebDriver driver;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        System.setProperty("webdriver.chrome.driver", "/Users/freddelabre/chromedriver");
        driver = new ChromeDriver();
        HomePageCucumber homePage = new HomePageCucumber(driver);
        homePage.navigateToHomePage();
    }

}