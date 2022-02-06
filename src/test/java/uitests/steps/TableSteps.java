package uitests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static uitests.steps.Hooks.driver;
import static uitests.steps.Hooks.webDriverWait;


public class TableSteps {

    @And("user click on table button")
    public void openPlayersTable() {
        driver.findElement(By.cssSelector("[class=\"fa fa-users\"]")).click();
    }

    @Then("players table is displayed")
    public void verifyPlayersTable() {
        (webDriverWait).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"table table-hover table-striped table-bordered table-condensed\"]")));
    }

    @Then("user click sort button and check username order")
    public void checkSortInUserNameColumn() {
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