package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{

    static {
        SKIP_ONBOARDING = "xpath://*[contains(@text,'Skip')]";
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_FIELD_WITH_REQUEST = "id:org.wikipedia:id/search_src_text";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@class='android.view.ViewGroup']//*[contains(@text,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']";
        SEARCH_RESULT_LOCATOR = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/results_text']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results']";
    }
    public AndroidSearchPageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
