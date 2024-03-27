import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Form {
    @Test
    public void t001_setUp(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
        //username
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        //password
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        //TextArea Comment
        WebElement textArea = driver.findElement(By.cssSelector("textarea[name='comments']"));



        username.click();
        username.sendKeys("Udemy");
        password.click();
        password.sendKeys("Test@1234");
        textArea.click();
        textArea.clear();
        textArea.sendKeys("Ceci est un commentaire");
    }
}