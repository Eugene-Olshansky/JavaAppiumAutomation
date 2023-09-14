package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
   private static final String
           SKIP_ONBOARDING = "//*[contains(@text,'Skip')]",
           SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
           SEARCH_INPUT = "//*[contains(@text,'Search Wikipedia')]",
           SEARCH_FIELD_WITH_REQUEST = "org.wikipedia:id/search_src_text",
           SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
           SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@class='android.view.ViewGroup']//*[contains(@text,'{SUBSTRING}')]",
           SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']",
           SEARCH_RESULT_LOCATOR = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/results_text']",
           SEARCH_EMPTY_RESULT_ELEMENT = "//*[@text='No results']";
    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*TEMPLATES METHODS */

    public void skipOnboarding()
    {
        this.waitForElementAndClick(By.xpath(SKIP_ONBOARDING), "Cannot find 'Skip' label", 5);
    }

    public void initSearchInput()
    {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }
    public void waitForSearchInputToPresentAndClear()
    {
        this.waitForElementAndClear(By.id(SEARCH_FIELD_WITH_REQUEST),"Cannot find search field with request", 5);
    }
    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }
    public void waitForCancelButtonToDisappear()
    {
        this.waitFOrElementNotPresented(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath),"Cannot find search result with substring "+ substring);

    }
    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath),"Cannot find and click search result with substring "+ substring, 10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT_ELEMENT), "Cannot find Empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.xpath(SEARCH_RESULT_LOCATOR), "We supposed not to find any results");
    }
}
