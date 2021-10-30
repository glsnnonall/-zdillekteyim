package steps;

import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.net.MalformedURLException;

public class ozdilekSteps extends BasePage {



    @Step("Open The App")
    public void openTheApp() throws InterruptedException, MalformedURLException {
        initializeTest2();
    }

    @Step("Click Alışverişe Başla Button")
    public void clickAlisVerisButton() throws InterruptedException, MalformedURLException {
        click(By.id("tv_startShoppingStore"));
    }
    @Step("Control Alışveriş Page")
    public void controlAlisVerisPage() {
        Assert.assertTrue(isElementExist(By.cssSelector("edtSearch"),10));
    }

    @Step("Click Kategori Button")
    public void clickKategoriButton() throws InterruptedException {
        click(By.id("nav_categories"));
    }

    @Step("Control Kategori Page")
    public void controlKategoriPage() {
        boolean flag = isElementExist(By.cssSelector("categoryTabContainer"),10);
        Assert.assertTrue(flag);
    }

    @Step("Menuden Kadina click")
    public void menuWomenClick() throws InterruptedException {
        click(By.cssSelector("TextView"),"Kadın");
    }


    @Step("Pantolon Kategorisi açılır")
    public void pantolonKategorisiOpen() throws InterruptedException {
        click(By.cssSelector("TextView"),"Pantolon");
    }
    
}
