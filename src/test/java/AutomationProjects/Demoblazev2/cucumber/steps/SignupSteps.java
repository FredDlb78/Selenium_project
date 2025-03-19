package AutomationProjects.Demoblazev2.cucumber.steps;

import AutomationProjects.Demoblazev2.cucumber.pages.HeaderPageCucumber;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SignupSteps {
    WebDriver driver;

    @When("I click on signup menu")
    public void iClickOnSignupMenu() {
        HeaderPageCucumber headerPageCucumber = new HeaderPageCucumber(driver);
        headerPageCucumber.clickSignupMenu();
    }

}