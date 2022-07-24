package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjectsHomework.*;

import java.time.Duration;

public class SauceDemoStepDefinitionsHomework {
    WebDriver driver;
    pageObjectsHomework.LoginPage loginPage;

    @Before("@browser")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After("@browser")
    public void tearDown(){
        driver.close();
    }

    @Given("user is navigated to page {string}")
    public void userIsNavigatedTo(String url) {
        driver.get(url);
    }

    @Then("user sees title of page {string}")
    public void userSeesPageTitle(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle);
    }
    @When("user enters login {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.getUsernameField().sendKeys((username));
        loginPage.getPasswordField().sendKeys(password);

    }
    @And("user clicks button to login")
    public void userClicksLoginButton() {
        loginPage.getLoginButton().click();
    }

    @Then("user is successfully logged in page")
    public void userIsSuccessfullyLoggedIn() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
    }

    @When("user adds item to cart")
    public void userAddsItemToCart() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addToCart();
    }
    @When("user clicks cart button")
    public void userClicksCartButton() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openCart();
    }
    @Then("user sees name of page {string}")
    public void userSeesNameOfPage(String pageName) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getPageName().getText(), "YOUR CART");
    }
    @And("user sees item {string}")
    public void userSeesItem(String itemTitle) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getItemInCart().getText(), itemTitle);
    }

    @When("user clicks checkout button")
    public void userClicksCheckoutButton() {
        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
    }
    @When("user enter name {string} and lastname {string} and zip {string}")
    public void userEnterNameLastnameZip(String name, String lastname, String zip) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.inputCheckoutData(name, lastname, zip);

    }
    @And("user clicks continue button")
    public void userClicksContinueButton() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getContinueButton().click();
    }
    @Then("checkout data is correct")
    public void checkoutDataIsCorrect() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        Assert.assertEquals(checkoutOverviewPage.getCheckoutItemQuantity().getText(), "1");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutItemName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutPaymentInformation().getText(), "SauceCard #31337");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutShippingInformation().getText(), "FREE PONY EXPRESS DELIVERY!");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutItemTotal().getText(), "Item total: $29.99");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutTax().getText(), "Tax: $2.40");
        Assert.assertEquals(checkoutOverviewPage.getCheckoutTotal().getText(), "Total: $32.39");
    }


    @When("user clicks finish button")
    public void userClicksFinishButton() {
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.getFinishButton().click();
    }
    @Then("order is created successfully")
    public void orderIsCreatedSuccessfully() {
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageTitle().getText(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getCheckoutSuccessHeader().getText(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(checkoutSuccessPage.getCheckoutSuccessText().getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        checkoutSuccessPage.getBackHomeButton().click();
    }

    @Then("user sees error {string}")
    public void userSeesErrorMessage(String errorMessage) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), errorMessage);
    }
}
