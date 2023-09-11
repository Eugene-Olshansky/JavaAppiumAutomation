package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/";

    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:deviceName","emulator-5554");
        capabilities.setCapability("appium:platformVersion","11");
        capabilities.setCapability("appium:appPackage","org.wikipedia");
        capabilities.setCapability("appium:appActivity",".main.MainActivity");
        capabilities.setCapability("appium:automationName","uiautomator2");
        capabilities.setCapability("app","/Users/eugeneolshansky/Projects/JavaAppiumAutomation/JavaAppiumAutomation/apks/Wikipedia_2.7.50449-r-2023-07-31_Apkpure.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);

    }
    @Override
    public void tearDown() throws Exception
    {
        driver.quit(); super.tearDown();
    }

}
