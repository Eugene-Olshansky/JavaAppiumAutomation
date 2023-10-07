package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{
    private static final String

            TITLE = "xpath://*[contains(@text, 'Appium')]",
            FOOTER_ELEMENT = "xpath://*[@text='View article in browser']",
            SUBTITLE ="id:pcs-edit-section-title-description",
            SAVE_TAB = "xpath://android.widget.TextView[@content-desc='Save']",
            ADD_TO_LIST_LABEL = "id:org.wikipedia:id/snackbar_action",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            ARTICLE_BACK_BUTTON = "xpath://*[@content-desc='Navigate up']",
            ARTICLE_LIST_BACK_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@content-desc,'Navigate up')]";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForSubtitleElement()
    {
        return this.waitForElementPresent(SUBTITLE,"Cannot find Subtitle description", 15);
    }
    public String getArticleSubtitle()
    {
        WebElement subtitle_element = waitForSubtitleElement();
        return subtitle_element.getAttribute("text");

    }
    public void waitForTitleElement()
    {
        this.waitForElementPresent(TITLE, "Cannot find title", 5);
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of the article",
                20
        );
    }
    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_TAB,
                "Cannot find Save tab",
                5

        );
        this.waitForElementAndClick(
                ADD_TO_LIST_LABEL,
                "Cannot find Add to list confirmation label",
                5

        );
        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into article folder input",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot click OK button",
                5
        );
    }
    public void closeArticle()
    {
        this.waitForElementAndClick(
                ARTICLE_BACK_BUTTON,
                "Cannot click Back button",
                5
        );
        this.waitForElementAndClick(
                ARTICLE_LIST_BACK_BUTTON,
                "Cannot click Back button on the Article list page",
                5
        );
    }
}
