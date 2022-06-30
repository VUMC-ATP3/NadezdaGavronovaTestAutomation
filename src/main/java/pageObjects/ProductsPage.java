package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    public WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pageTitle = By.cssSelector("span[class='title']");

    public WebElement getPageTitle(){
        return driver.findElement(pageTitle);
    }



}
