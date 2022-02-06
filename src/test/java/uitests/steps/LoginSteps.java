package uitests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static uitests.steps.Hooks.*;


public class LoginSteps {


    @Given("user is on login page")
    public void verifyLoginPage() {
        element = (webDriverWait)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("UserLogin_username")));
    }

    @When("user enters username and password")
    public void setUsernameAndPassword() {
        element.sendKeys(login);
        driver.findElement(By.id("UserLogin_password")).sendKeys(password);

    }

    @And("click on login button")
    public void clickOnLoginButton() {
        driver.findElement(By.cssSelector("[value=\"Sign in\"]")).click();
    }

    @Then("user is navigated to admin page")
    public void verifyAdminPage() {
        (webDriverWait).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"Casino\"]")));
    }


}
