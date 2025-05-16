package stepDefinitions;

import Pages.RegisterPage;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterStepDefinition {
    WebDriver driver;
    RegisterPage registerPage;

    @Given("User go to register page")
    public void user_go_to_register_page() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        registerPage = new RegisterPage(driver);
    }

    @When("User select the type of gender")
    public void user_select_gender() {
        registerPage.selectGender();
    }

    @And("User enter the first and last name")
    public void user_enter_names() {
        registerPage.enterFirstAndLastName("Fares", "Mohamed");
    }

    @And("User enter the email")
    public void user_enter_email() {
        String email = "fares" + System.currentTimeMillis() + "@mail.com";
        registerPage.enterEmail(email);
    }

    @And("User enter the company name")
    public void user_enter_company() {
        registerPage.enterCompany("Mawlana's");
    }

    @And("User enter and confirm the password")
    public void user_enter_passwords() {
        registerPage.enterPassword("Fares@123");
    }

    @And("User click on register button")
    public void user_click_register() throws InterruptedException {
        registerPage.clickRegister();
        Thread.sleep(2000); // ممكن تستبدلها بـ explicit wait
    }

    @Then("success message is displayed")
    public void success_message_displayed() {
        String actualMessage = registerPage.getSuccessMessage();
        Assert.assertTrue("Registration Success Message Not Displayed!", actualMessage.contains("Your registration completed"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
