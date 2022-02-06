package uitests.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Hooks {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static WebElement element;
    public static String url = "http://test-app.d6.dev.devcaz.com/admin/login";
    public static String login = "admin1";
    public static String password = "[9k<k8^z!+$$GkuP";

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Before
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url);
    }

}