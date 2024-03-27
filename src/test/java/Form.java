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
        //Filename
        WebElement filename = driver.findElement(By.cssSelector("input[name='filename']"));
        //Checkboxes
        WebElement checkbox1 = driver.findElement(By.cssSelector("input[value='cb1']"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("input[value='cb2']"));
        WebElement checkbox3 = driver.findElement(By.cssSelector("input[value='cb3']"));
        //Radio buttons
        WebElement radio1 =driver.findElement(By.xpath("//input[@value='rd1']"));
        WebElement radio2 =driver.findElement(By.xpath("//input[@value='rd2']"));
        WebElement radio3 =driver.findElement(By.xpath("//input[@value='rd3']"));
        //Multiple Select Values
        WebElement msv1 =driver.findElement(By.cssSelector("option[value='ms1']"));
        WebElement msv2 =driver.findElement(By.cssSelector("option[value='ms2']"));
        WebElement msv3 =driver.findElement(By.cssSelector("option[value='ms3']"));
        WebElement msv4 =driver.findElement(By.cssSelector("option[value='ms4']"));
        //Dropdown
        WebElement dropdown1 =driver.findElement(By.cssSelector("option[value='dd1']"));
        WebElement dropdown2 =driver.findElement(By.cssSelector("option[value='dd2']"));
        WebElement dropdown3 =driver.findElement(By.cssSelector("option[value='dd3']"));
        WebElement dropdown4 =driver.findElement(By.cssSelector("option[value='dd4']"));
        WebElement dropdown5 =driver.findElement(By.cssSelector("option[value='dd5']"));
        WebElement dropdown6 =driver.findElement(By.cssSelector("option[value='dd6']"));
        //Submit
        WebElement submit = driver.findElement(By.cssSelector("input[value='submit']"));


        username.click();
        username.sendKeys("Udemy");
        password.click();
        password.sendKeys("Test@1234");
        textArea.click();
        textArea.clear();
        textArea.sendKeys("Ceci est un commentaire");
        filename.sendKeys("C:\\Users\\frede\\IdeaProjects\\Selenium_project\\target\\images\\bateau-lac-montagnes-arriere-plan_865967-5725.avif");
        checkbox2.click();
        checkbox3.click();
        radio1.click();
        msv1.click();
        msv4.click();
        dropdown2.click();
        submit.click();
    }
}