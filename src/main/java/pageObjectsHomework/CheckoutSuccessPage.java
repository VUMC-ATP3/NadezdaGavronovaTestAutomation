package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }
    private By pageTitle = By.cssSelector("span[class='title']");
    private By checkoutSuccessHeader = By.cssSelector("h2[class='complete-header']");
    private By checkoutSuccessText = By.cssSelector("div[class='complete-text']");
    private By backHomeButton = By.id("back-to-products");

    public WebElement getPageTitle() {
        return driver.findElement(pageTitle);
    }
    public WebElement getCheckoutSuccessHeader() {
        return driver.findElement(checkoutSuccessHeader);
    }
    public WebElement getCheckoutSuccessText() {
        return driver.findElement(checkoutSuccessText);
    }
    public WebElement getBackHomeButton() {
        return driver.findElement(backHomeButton);
    }

}
