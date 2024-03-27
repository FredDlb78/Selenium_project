import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form {
    @Test
    public void t001_setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));

        username.click();
        username.sendKeys("Udemy");
        password.click();
        password.sendKeys("Udemy");
    }
}