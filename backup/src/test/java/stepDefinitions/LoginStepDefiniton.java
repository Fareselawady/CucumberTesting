package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefiniton {
    WebDriver driver;

    @Before
    public void open_browser() {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void close_browser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnurl=%2F");
    }

    @When("user enter {string} and {string}")
    public void user_enter_credentials(String email, String password) {
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);

        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    @And("User click on login button")
    public void user_click_on_login_button() throws InterruptedException {
        driver.findElement(By.cssSelector("button.login-button")).click();
        Thread.sleep(2000);
    }

    @Then("User could login successfully and navigate to home page")
    public void user_login_success() {
        boolean isLoggedIn = driver.getCurrentUrl().equals("https://demo.nopcommerce.com/");
        Assert.assertTrue("User should be on homepage", isLoggedIn);
    }

    @Then("User couldn't login successfully")
    public void user_login_failed() {
        String errorText = driver.findElement(By.cssSelector(".message-error")).getText();
        Assert.assertTrue("Expected error message not found", errorText.contains("Login was unsuccessful."));
    }
}