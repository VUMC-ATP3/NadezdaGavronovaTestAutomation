package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameInputField = By.id("user-name");
    private By passwordInputField = By.id("password");
    private By loginButton = By.cssSelector("input#login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");


    public WebElement getErrorMessageTextField(){
        return driver.findElement(errorMessage);
    }

    public void login(String username, String password){
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }


    public WebElement getUsernameField() {
        return driver.findElement((usernameInputField));
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordInputField);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

}
