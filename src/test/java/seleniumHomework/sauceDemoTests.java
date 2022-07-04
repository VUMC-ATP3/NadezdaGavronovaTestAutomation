package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjectsHomework.*;

import java.time.Duration;

public class sauceDemoTests {
    WebDriver driver;
    private final String SWAGLABS_URL = "https://www.saucedemo.com/";

    @Test
    public void testSuccessLogin(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
    }

    @Test
    public void testSuccessAddToCart(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getPageName().getText(), "YOUR CART");
        Assert.assertEquals(cartPage.getItemInCart().getText(), "Sauce Labs Backpack");
    }

    @Test
    public void testCheckoutData(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputCheckoutData("Nadežda", "Gavronova", "LV-1012");
        checkoutPage.getContinueButton().click();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getCheckoutItemQuantity().getText(), "1");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutItemName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutPaymentInformation().getText(), "SauceCard #31337");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutShippingInformation().getText(), "FREE PONY EXPRESS DELIVERY!");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutItemTotal().getText(), "Item total: $29.99");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutTax().getText(), "Tax: $2.40");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutTotal().getText(), "Total: $32.39");
    }
    @Test
    public void testCheckoutSuccess(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputCheckoutData("Nadežda", "Gavronova", "LV-1012");
        checkoutPage.getContinueButton().click();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageTitle().getText(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getCheckoutSuccessHeader().getText(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(checkoutSuccessPage.getCheckoutSuccessText().getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        checkoutSuccessPage.getBackHomeButton().click();
    }

    @Test
    public void testCheckoutFieldsObligatory(){
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
        checkoutPage.getErrorMessage().isDisplayed();

        checkoutPage.getErrorCloseButton().click();
        checkoutPage.inputCheckoutData("", "Gavronova", "LV-1012");
        checkoutPage.getContinueButton().click();
        checkoutPage.getErrorMessage().isDisplayed();
        checkoutPage.getErrorCloseButton().click();

        checkoutPage.clearInputFields();
        checkoutPage.inputCheckoutData("Nadežda", "", "LV-1012");
        checkoutPage.getContinueButton().click();
        checkoutPage.getErrorMessage().isDisplayed();

        checkoutPage.getContinueButton().click();
        checkoutPage.clearInputFields();
        checkoutPage.inputCheckoutData("Nadežda", "Gavronova", "");
         checkoutPage.getContinueButton().click();
        checkoutPage.getErrorMessage().isDisplayed();
    }

    @Test
    public void testErrorMessageWithoutFirstname() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputCheckoutData("", "Gavronova", "LV-1012");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");
    }

    @Test
    public void testErrorMessageWithoutLastname() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputCheckoutData("Nadežda", "", "LV-1012");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Last Name is required");
    }

    @Test
    public void testErrorMessageWithoutZipCode() {
        driver.get(SWAGLABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputCheckoutData("Nadežda", "Gavronova", "");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Postal Code is required");
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.quit();
    }
}
