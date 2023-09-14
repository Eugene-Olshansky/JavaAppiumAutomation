package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{
    private static final String

            TITLE = "//*[contains(@text, 'Appium')]",
            FOOTER_ELEMENT = "//*[@text='View article in browser']",
            SUBTITLE ="pcs-edit-section-title-description",
    SAVE_TAB = "//android.widget.TextView[@content-desc='Save']",
    ADD_TO_LIST_LABEL = "org.wikipedia:id/snackbar_action",
    MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "//*[@text='OK']",
    ARTICLE_BACK_BUTTON = "//*[@content-desc='Navigate up']",
    ARTICLE_LIST_BACK_BUTTON = "//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@content-desc,'Navigate up')]";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForSubtitleElement()
    {
        return this.waitForElementPresent(By.xpath(SUBTITLE),"Cannot find Subtitle description", 15);
    }
    public String getArticleSubtitle()
    {
        WebElement subtitle_element = waitForSubtitleElement();
        return subtitle_element.getAttribute("text");

    }
    public void waitForTitleElement()
    {
        this.waitForElementPresent(By.xpath(TITLE), "Cannot find title", 5);
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                By.xpath(FOOTER_ELEMENT),
                "Cannot find the end of the article",
                20
        );
    }
    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                By.xpath(SAVE_TAB),
                "Cannot find Save tab",
                5

        );
        this.waitForElementAndClick(
                By.id(ADD_TO_LIST_LABEL),
                "Cannot find Add to list confirmation label",
                5

        );
        this.waitForElementAndSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );
        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot click OK button",
                5
        );
    }
    public void closeArticle()
    {
        this.waitForElementAndClick(
                By.xpath(ARTICLE_BACK_BUTTON),
                "Cannot click Back button",
                5
        );
        this.waitForElementAndClick(
                By.xpath(ARTICLE_LIST_BACK_BUTTON),
                "Cannot click Back button on the Article list page",
                5
        );
    }
}
