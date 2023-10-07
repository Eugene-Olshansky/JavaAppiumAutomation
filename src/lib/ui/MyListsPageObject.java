package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{
    public static final String
    FOLDER_BY_NAME = "xpath://*[@class='android.view.ViewGroup']//*[contains(@text,'Test automation')]",
    ARTICLE_BY_TITLE = "xpath://*[@text='Appium']",
    ARTICLE_BY_SUBTITLE = "xpath://*[@class='android.view.ViewGroup']//*[contains(@text,'Automation for Apps')]";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
    public void openFolderByName (String name_of_folder)
    {
        this.waitForElementAndClick(
                FOLDER_BY_NAME,
                "Cannot find folder by name "+name_of_folder,
                5
        );
    }
    public void swipeArticleToDelete()
    {
        this.swipeElementToLeft(
                ARTICLE_BY_TITLE,
                "Cannot find saved article"
        );
    };
    public void waitForArticleToDisappear()
    {
        this.waitFOrElementNotPresented(
                ARTICLE_BY_SUBTITLE,
                "Cannot delete saved article",
                5
        );
    };
}
