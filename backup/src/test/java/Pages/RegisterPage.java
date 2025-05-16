package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    @FindBy(id = "gender-male")
    WebElement genderMale;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Company")
    WebElement company;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(className = "result")
    WebElement resultMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectGender() {
        genderMale.click();
    }

    public void enterFirstAndLastName(String fName, String lName) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void enterCompany(String companyName) {
        company.sendKeys(companyName);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public String getSuccessMessage() {
        return resultMessage.getText();
    }
}
