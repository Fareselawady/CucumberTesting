package stepDefinitions;
import Pages.LoginPage;
import Pages.ResetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class ResetStepDefinition {
    WebDriver driver = null;
    ResetPage resetPage = new ResetPage(driver);

    @Given("user navigates to login page")
    public void user_navigates_to_the_login_page() {
        System.getProperty("C:\\Users\\Lenovo\\MAVEN\\MavenSeleniumCucumber\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/login");
        resetPage = new ResetPage(driver);
    }


    @When("user click on forgetPassword")
    public void userClicksOnForgetPassword() {

        resetPage.goToForgotPasswordPage();
    }

    @Then("user navigate to forgetPage and enter his email {string}")
    public void userNavigatesToForgetPageAndEntersEmail(String email) {
        resetPage.enterEmail(email);
    }

    @Then("user click on Recovery Button")
    public void userClicksOnRecoveryButton() {
        resetPage.clickRecoveryButton();
    }

    @Then("password will be reset")
    public void passwordWillBeReset() {
        String expectedResult = "Email with instructions has been sent to you.";
        String actualResult = resetPage.getContentText();
        assertTrue("Assertion failed.", actualResult.contains(expectedResult));
        driver.quit();
    }
}