package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTitleTest {
    public WebDriver chromeBrowser;

    @Test
    //Test www.elko.lv
    public void testTitleElko(){
        chromeBrowser.navigate().to("https://www.elko.lv/");
        Assert.assertEquals(chromeBrowser.getTitle(), "ELKO Latvija");
    }

    @Test
    //Test https://latvija.lv/
    public void testTitleLatvija(){
        chromeBrowser.navigate().to("https://latvija.lv/");
        Assert.assertEquals(chromeBrowser.getTitle(),"Latvijas valsts portāls");
    }

    @BeforeMethod
    public void openNewBrowser(){
        this.chromeBrowser = new ChromeDriver();
    }
    @AfterMethod
    public void closeBrowser(){
        chromeBrowser.quit();
    }

}
