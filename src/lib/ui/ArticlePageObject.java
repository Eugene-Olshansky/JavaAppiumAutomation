package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
            TITLE,
            FOOTER_ELEMENT ,
            SUBTITLE ,
            SAVE_TAB ,
            ADD_TO_LIST_LABEL ,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON ,
            ARTICLE_BACK_BUTTON ,
            ARTICLE_LIST_BACK_BUTTON;

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
        if (Platform.getInstance().isAndroid()){
            return subtitle_element.getAttribute("text");
        } else {
            return subtitle_element.getAttribute("name");
        }


    }
    public void waitForTitleElement()
    {
        this.waitForElementPresent(TITLE, "Cannot find title", 5);
    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40
            );
        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40);
        }

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
