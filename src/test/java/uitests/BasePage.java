package uitests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }


    public void login(String login, String password) {
        WebElement element = (webDriverWait)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("UserLogin_username")));
        element.sendKeys(login);
        driver.findElement(By.id("UserLogin_password")).sendKeys(password);
        driver.findElement(By.cssSelector("[value=\"Sign in\"]")).click();
        (webDriverWait).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"Casino\"]")));

    }

    public void openPlayersTable() {
        driver.findElement(By.cssSelector("[class=\"fa fa-users\"]")).click();
        (webDriverWait).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"table table-hover table-striped table-bordered table-condensed\"]")));
    }

    public void sortPlayersTableByUsername() {
        for (int i = 0; i < 2; i++) {
            List<WebElement> usernames = driver.findElements(By.xpath("//td/a[contains(@href,'user')][not(@class=\"btn btn-primary btn-xs\")]"));
            ArrayList<String> userNamesString = new ArrayList<>();
            for (WebElement username : usernames) {
                userNamesString.add(username.getText());
            }
            ArrayList<String> sortedUserNamesString = new ArrayList<>(userNamesString);
            Collections.sort(sortedUserNamesString);
            if (!userNamesString.equals(sortedUserNamesString)) {
                driver.findElement(By.cssSelector("[class=\"sort-link\"]")).click();
                (webDriverWait).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"sort-link asc\"]")));
            }
        }
    }
}
