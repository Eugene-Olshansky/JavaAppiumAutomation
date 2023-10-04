package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_LINK ="//XCUIElementTypeStaticText[@name=\"Learn more about Wikipedia\"]",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT= "New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "//XCUIElementTypeStaticText[@name=\"Add or edit preferred languages\"]",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "//XCUIElementTypeStaticText[@name=\"Learn more about data collected\"]",
    NEXT_LINK = "//XCUIElementTypeStaticText[@name=\"Next\"]",
    GET_STARTED_BUTTON = "//XCUIElementTypeStaticText[@name=\"Get started\"]";
    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink ()
    {
        this.waitForElementPresent(By.xpath(STEP_LEARN_MORE_LINK), "Cannot find 'Learn more about Wikipedia' link", 10);
    }
    public void clickNextButton ()
    {
        this.waitForElementAndClick(By.xpath(NEXT_LINK),"Cannot find and click 'Next' link", 10);
    }
    public void waitForNewWaysToExploreText ()
    {
        this.waitForElementPresent(By.id(STEP_NEW_WAYS_TO_EXPLORE_TEXT), "Cannot find 'New ways to explore' link", 10);
    }
//    public void clickNextButton ()
//    {
//        this.waitForElementAndClick(By.xpath(NEXT_LINK),"Cannot find and click 'Next' link", 10);
//    }
    public void waitForAddPreferredLanguage ()
    {
        this.waitForElementPresent(By.xpath(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK), "Cannot find 'Add or edit preferred languages' link", 10);
    }
//    public void clickNextButton ()
//    {
//        this.waitForElementAndClick(By.xpath(NEXT_LINK),"Cannot find and click 'Next' link", 10);
//    }
    public void waitForLearnMoreAboutDataCollected ()
    {
        this.waitForElementPresent(By.xpath(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK), "Cannot find 'Learn more about data collected' link", 10);
    }
    public void clickGetStartedButton ()
    {
        this.waitForElementPresent(By.xpath(GET_STARTED_BUTTON), "Cannot find 'Get started' link", 10);
    }
}
