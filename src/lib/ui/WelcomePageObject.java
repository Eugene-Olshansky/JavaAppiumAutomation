package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject
{
    private static final String
    STEP_LEARN_MORE_LINK ="xpath://XCUIElementTypeButton[@name=\"Learn more about Wikipedia\"]",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT= "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://XCUIElementTypeButton[@name=\"Add or edit preferred languages\"]",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "xpath://XCUIElementTypeButton[@name=\"Learn more about data collected\"]",
    NEXT_LINK = "xpath://XCUIElementTypeButton[@name=\"Next\"]",
    GET_STARTED_BUTTON = "xpath://XCUIElementTypeButton[@name=\"Get started\"]",
    SKIP_LINK = "xpath://XCUIElementTypeButton[@name=\"Skip\"]";
    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink ()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Learn more about Wikipedia' link", 10);
    }
    public void clickNextButton ()
    {
        this.waitForElementAndClick(NEXT_LINK,"Cannot find and click 'Next' link", 10);
    }
    public void waitForNewWaysToExploreText ()
    {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore' link", 10);
    }
    public void waitForAddPreferredLanguage ()
    {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Add or edit preferred languages' link", 10);
    }
    public void waitForLearnMoreAboutDataCollected ()
    {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "Cannot find 'Learn more about data collected' link", 10);
    }
    public void clickGetStartedButton ()
    {
        this.waitForElementPresent(GET_STARTED_BUTTON, "Cannot find 'Get started' link", 10);
    }
    public void clickSkipButton ()
    {
        this.waitForElementAndClick(SKIP_LINK,"Cannot find and click 'Skip' link", 10);
    }
}
