package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public void initializeTest2() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel 4 XL API 27");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "1.1.2");
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("appPackage", "com.ozdilek.ozdilekteyim");
        cap.setCapability("appActivity", "com.ozdilek.ozdilekteyim.MainActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        wait = new WebDriverWait(driver, 20);
    }



    protected void sendKeys(By by, String text) throws InterruptedException {
        WebElement element = null;
        try {
            WebElement we = driver.findElement(by);
            we.clear();
            we.sendKeys(text);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    protected void untilElementAppear(By by) {

        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy (by));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected void click(By by, int... index) throws InterruptedException {
        MobileElement element;
        try {
            element = driver.findElement(by);
            element.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void click(By by,String name) throws InterruptedException {
        List<MobileElement> element;
        try {
            element = driver.findElements(by);
            for (int i=0 ; i<element.size() ;i++){
                if (element.get(i).getText() == name){
                    element.get(i).click();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean isElementExist(By by, int timeSeconds) {

        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
        boolean isExist = driver.findElements(by).size() > 0;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return isExist;
    }


    }