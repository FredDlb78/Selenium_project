package PageObjectModel.SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //Page Factory
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "login-button")
    private WebElement submitLogin;
    WebDriver driver;
    //Constructeur
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Object
    public void setLoginAsUser (){
        usernameInput.click();
        usernameInput.sendKeys("standard_user");
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");
        submitLogin.click();
    }

}
