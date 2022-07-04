package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By zipCodeInputField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    private By errorCloseButton = By.cssSelector("button[class='error-button']");
    private By form = By.cssSelector("#checkout_info_container > div > form");

    public void inputCheckoutData(String firstName, String lastName, String zipCode ){
        getFirstNameInputField().sendKeys(firstName);
        getLastNameInputField().sendKeys(lastName);
        getZipCodeInputField().sendKeys(zipCode);
    }

    public void clearInputFields(){
        // (i) Ar clear() - ir problēma notīrīt input laukus - notīra, bet ievadot jaunas vērtības aizpilda ar iepriekšējām vērtībām + jaunām !!!
        getFirstNameInputField().sendKeys(Keys.CONTROL + "A");
        getFirstNameInputField().sendKeys(Keys.BACK_SPACE);
        getLastNameInputField().sendKeys(Keys.CONTROL + "A");
        getLastNameInputField().sendKeys(Keys.BACK_SPACE);
        getZipCodeInputField().sendKeys(Keys.CONTROL + "A");
        getZipCodeInputField().sendKeys(Keys.BACK_SPACE);
    }

    public WebElement getFirstNameInputField() {
        return driver.findElement(firstNameInputField);
    }

    public WebElement getLastNameInputField() {
        return driver.findElement(lastNameInputField);
    }

    public WebElement getZipCodeInputField() {
        return driver.findElement(zipCodeInputField);
    }
    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }
    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }
    public WebElement getErrorCloseButton() {
        return driver.findElement(errorCloseButton);
    }
    public WebElement getForm() {
        return driver.findElement(form);
    }

}
