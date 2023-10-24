package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "xpath://*[contains(@text, 'Appium')]";
        FOOTER_ELEMENT = "xpath://*[@text='View article in browser']";
        SUBTITLE = "id:pcs-edit-section-title-description";
        SAVE_TAB = "xpath://android.widget.TextView[@content-desc='Save']";
        ADD_TO_LIST_LABEL = "id:org.wikipedia:id/snackbar_action";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        ARTICLE_BACK_BUTTON = "xpath://*[@content-desc='Navigate up']";
        ARTICLE_LIST_BACK_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@content-desc,'Navigate up')]";
    }

    public AndroidArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
