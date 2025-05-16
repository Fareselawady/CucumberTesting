package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
    //the same as what in stepDefinitions

    WebDriver driver;

    @FindBy(linkText = "Log in")
    public WebElement loginLink;

    @FindBy(linkText = "Forgot password?")
    public WebElement forgotPasswordLink;

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(className = "content")
    public WebElement contentText;

    public ResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void goToForgotPasswordPage() {
        forgotPasswordLink.sendKeys(Keys.ENTER);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickRecoveryButton() {
        emailField.sendKeys(Keys.ENTER);
    }

    public String getContentText() {
        return contentText.getText();
    }


}