package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{
    private static final String
    NAV_TAB_READING_LISTS = "id:org.wikipedia:id/nav_tab_reading_lists";
    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }
    public void clickSaveTab()
    {
        this.waitForElementAndClick(
                NAV_TAB_READING_LISTS,
                "Cannot find Saved tab",
                5
        );
    };
}
