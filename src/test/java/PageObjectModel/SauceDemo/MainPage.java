package PageObjectModel.SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    //Initialisation des pages Factory
    @FindBy(css = "input[name='username']")
            private WebElement usernameInput;

    WebDriver driver;
    // Constructeur de notre Page Object
    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement password(){
        return driver.findElement(By.cssSelector("input[name='password']"));
    }
    public WebElement textArea(){
        return driver.findElement(By.cssSelector("textarea[name='comments']"));
    }
    public WebElement filename(){
        return driver.findElement(By.cssSelector("input[name='filename']"));
    }
    public WebElement checkbox(String cb){
        return driver.findElement(By.cssSelector(String.format("input[value='%s']", cb)));
    }
    public WebElement radio(String rd){
        return driver.findElement(By.xpath(String.format("//input[@value='%s']", rd)));
    }
    public WebElement msv(String msv){
        return driver.findElement(By.cssSelector(String.format("option[value='%s']", msv)));
    }
    public WebElement dropdown2(){
        return driver.findElement(By.cssSelector("option[value='dd2']"));
    }
    public WebElement submit(){
        return driver.findElement(By.cssSelector("input[value='submit']"));


    }
    public void setUsername(String username){
        usernameInput.sendKeys(username);
    }
    public void fillPassword(String password){
        password().sendKeys(password);
    }
    public void clearTextArea(){
        textArea().clear();
    }
    public void fillTextArea(String textArea){
        textArea().sendKeys(textArea);
    }
    public void uploadFilename(String filename){
        filename().sendKeys(filename);
    }
    public void clickCheckbox(String cb){
        checkbox(cb).click();
    }
    public void clickRadio(String rd){

        radio(rd).click();
    }
    public void selectMsv(String msv){
        msv(msv).click();
    }
    public void clickDropdown2(){
        dropdown2().click();
    }
    public void clickSubmit(){
        submit().click();
    }


}
