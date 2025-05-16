package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement usernamePom()
    {
        return driver.findElement(By.id("username"));
    }

    public WebElement PasswordPom()
    {

        return  driver.findElement(By.name("password"));
    }
    public By flashPom()
    {

        return By.id("flash");
    }

    public By logoutPom()
    {

        return By.cssSelector("a[href=\"/logout\"]");
    }

    public void loginsteps(String username , String password)
    {
        //  Login for username

        usernamePom().clear();
        usernamePom().sendKeys(username);

        // Login for Password
        PasswordPom().sendKeys(password);
      //  PasswordPom().sendKeys(Keys.ENTER);

    }


}
