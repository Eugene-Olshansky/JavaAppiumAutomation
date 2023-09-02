import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class FirstTest {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:deviceName","emulator-5554");
        capabilities.setCapability("appium:platformVersion","11");
        capabilities.setCapability("appium:appPackage","org.wikipedia");
        capabilities.setCapability("appium:appActivity",".main.MainActivity");
        capabilities.setCapability("appium:automationName","uiautomator2");
        capabilities.setCapability("app","/Users/eugeneolshansky/Projects/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia_2.7.50449-r-2023-07-31_Apkpure.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);

    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
//    @Test
//    public void firstTest()
//    {
//        waitForElementByXpathAndClick(
//                "//*[contains(@text,'Skip')]",
//                "Cannot find 'Skip' label",
//                5
//        );
//
//        waitForElementByXpathAndClick(
//                "//*[contains(@text,'Search Wikipedia')]",
//                "Cannot find 'Search Wikipedia' input",
//                10
//        );
//
//        waitForElementByXpathAndSendKeys(
//                "//*[contains(@text,'Search Wikipedia')]",
//                "Java",
//                "Cannot find search input",
//                10
//        );
//
//        waitForElementPresentByXpath(
//                "//*[@class='android.view.ViewGroup']//*[contains(@text,'Object-oriented programming language')]",
//                "Cannot Find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//        );
//
//    }

    @Test
    public void testCancelSearch()
    {
        waitForElementByIdAndClick(
                "org.wikipedia:id/fragment_onboarding_skip_button",
                "Cannot find 'Skip' label",
                10
        );
        waitForElementByIdAndClick(
                "org.wikipedia:id/search_container",
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementByXpathAndSendKeys(
                "//*[contains(@text,'Search Wikipedia')]",
                "Java",
                "Cannot find search input",
                10
        );
        waitForElementByIdAndClick(
                "org.wikipedia:id/search_close_btn",
                "Cannot find X to cancel search",
                5
        );
        waitFOrElementNotPresented(
                "org.wikipedia:id/search_close_btn",
                "X is still present on the page",
                5

        );
    }

    private WebElement waitForElementPresentByXpath(String xpath, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait=new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message +"\n");
        By by = By.xpath(xpath);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementPresentByXpath(String xpath, String error_message)
    {
        return waitForElementPresentByXpath(xpath,error_message, 5);
    }
    private WebElement waitForElementByXpathAndClick(String xpath, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentByXpath(xpath,error_message, 5);
        element.click();
        return element;
    }
    private WebElement waitForElementByXpathAndSendKeys(String xpath, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentByXpath(xpath,error_message, 5);
        element.sendKeys(value);
        return element;
    }
    private WebElement waitForElementPresentById(String id, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait=new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message +"\n");
        By by = By.id(id);
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementByIdAndClick(String id, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresentById(id,error_message, 5);
        element.click();
        return element;
    }
    private boolean waitFOrElementNotPresented(String id, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait=new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message+"\n");
        By by=By.id(id);
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }
}