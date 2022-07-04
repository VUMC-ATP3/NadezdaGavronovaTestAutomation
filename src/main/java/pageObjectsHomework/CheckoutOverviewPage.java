package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    private By checkoutItemQuantity = By.cssSelector("div[class='cart_quantity']");
    private By checkoutItemName = By.cssSelector("div[class='inventory_item_name']");
    private By checkoutPaymentInformation = By.cssSelector("#checkout_summary_container > div > div.summary_info > div:nth-child(2)");
    private By checkoutShippingInformation = By.cssSelector("#checkout_summary_container > div > div.summary_info > div:nth-child(4)");
    private By checkoutItemTotal = By.cssSelector("div[class='summary_subtotal_label']");
    private By checkoutTax = By.cssSelector("div[class='summary_tax_label']");
    private By checkoutTotal = By.cssSelector("div[class='summary_total_label']");
    private By finishButton = By.id("finish");

    public WebElement getCheckoutItemQuantity() {
        return driver.findElement(checkoutItemQuantity);
    }
    public WebElement getCheckoutItemName() {
        return driver.findElement(checkoutItemName);
    }
    public WebElement getCheckoutPaymentInformation() {
        return driver.findElement(checkoutPaymentInformation);
    }
    public WebElement getCheckoutShippingInformation() {
        return driver.findElement(checkoutShippingInformation);
    }
    public WebElement getCheckoutItemTotal() {
        return driver.findElement(checkoutItemTotal);
    }
    public WebElement getCheckoutTax() {
        return driver.findElement(checkoutTax);
    }
    public WebElement getCheckoutTotal() {
        return driver.findElement(checkoutTotal);
    }
    public WebElement getFinishButton() {
        return driver.findElement(finishButton);
    }
}
