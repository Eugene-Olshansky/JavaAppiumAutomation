package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{
    public static final String
    FOLDER_BY_NAME = "//*[@class='android.view.ViewGroup']//*[contains(@text,'Test automation')]",
    ARTICLE_BY_TITLE = "//*[@text='Appium']";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
    public void openFolderByName (String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(FOLDER_BY_NAME),
                "Cannot find folder by name "+name_of_folder,
                5
        );
    }
    public void swipeArticleToDelete()
    {
        this.swipeElementToLeft(
                By.xpath(ARTICLE_BY_TITLE),
                "Cannot find saved article"
        );
    };
    public void waitForArticleToDisappear()
    {
        this.waitFOrElementNotPresented(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Automation for Apps')]"),
                "Cannot delete saved article",
                5
        );
    };
}
