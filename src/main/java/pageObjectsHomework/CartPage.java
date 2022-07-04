package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage{
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    private By item = By.cssSelector("a#item_4_title_link");
    private By cartPageName = By.cssSelector("span[class='title']");
    private By checkoutButton = By.cssSelector("button#checkout");

    public WebElement getPageName(){
        return driver.findElement(cartPageName);
    }
    public WebElement getItemInCart(){
        return driver.findElement(item);
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }
}
