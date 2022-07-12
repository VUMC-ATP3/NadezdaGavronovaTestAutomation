package classRoomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AcodemyShop.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AcodemyShopTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
//        EdgeOptions options = new EdgeOptions();
        driver = new RemoteWebDriver(new URL("https://oauth-nadezhda.gavronova-038fc:6babb604-f57b-433f-ab98-ae444b0d7f39@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), options);
//       driver = new RemoteWebDriver(new URL("http://192.168.48.190:4444"), options);
 //       driver = new WebDriver(
//                new URL("https://oauth-nadezhda.gavronova-038fc:6babb604-f57b-433f-ab98-ae444b0d7f39@ondemand.eu-central-1.saucelabs.com:443/wd/hub")
//        );


        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void testSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");

        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 2 results");
        Thread.sleep(5000);

        mainPage.searchProduct("T-shirt");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 3 results");
        Thread.sleep(5000);

        mainPage.searchProduct("Hoodie");
        Assert.assertEquals(mainPage.getSearchResults().size(), 3);
        Thread.sleep(5000);

        //pieklustam sarakstam un iterejam cauri elementiem iekša
        List<WebElement> results =  mainPage.getSearchResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("##########################");
            System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
        }

   //     @Test
  //      public void testEmptySearch()  {
   //         driver.get("http://shop.acodemy.lv/");
   //         MainPage mainPage = new MainPage(driver);
   //         mainPage.searchProduct("JurisJuris");
   //         Assert.assertEquals(mainPage.getNoSearchResultText(),MainPage.NO_SEARCH_RESULTS);
   //     }


    }

    @Test
    public void testSwitchTabs() throws InterruptedException{
        driver.get("http://shop.acodemy.lv/");
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles()); // dabījam visus tabus
        driver.switchTo().window(tabs.get(1)); //pārslēdzamies uz 2.
        System.out.println(driver.getTitle());
        driver.switchTo().window(tabs.get(0)); //pārslēdzamies uz 1.
        System.out.println(driver.getTitle());
        driver.close(); //aizveram 1. tabu
        driver.switchTo().window(tabs.get(1)); //pārslēdzamies uz 2.
        //or
        //tabs = new ArrayList<> (driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
    }

    @Test
    public void testJavascript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
     //   ((JavascriptExecutor) driver).executeScript("alert('JURIS JURIS')");

        //uzskrolē tā lai norādītais elements būtu redzams
        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);
    }

    @Test
    public void mouseActionsTest() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        Actions actions = new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();  //example of element hover
        Thread.sleep(3000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(3000);
    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform(); //turam CTRL un sūtam K
        Thread.sleep(5000);
    }




    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
