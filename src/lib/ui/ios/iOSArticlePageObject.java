package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        SAVE_TAB = "id:Saved";
        ARTICLE_BACK_BUTTON = "id:Back";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
