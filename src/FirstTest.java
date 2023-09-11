import io.appium.java_client.TouchAction;
import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class FirstTest extends CoreTestCase {


    @Test
    public void testSearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find 'Skip' label",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                10
        );

        waitForElementPresent(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Object-oriented programming language')]"),
                "Cannot Find 'Object-oriented programming language' topic searching by 'Java'",
                15
        );

    }

    @Test
    public void testCancelSearch()
    {
        waitForElementAndClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Cannot find 'Skip' label",
                10
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find search input",
                10
        );
        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find search field",
                10

        );

//        waitForElementAndClick(
//                By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X to cancel search",
//                5
//        );
        waitFOrElementNotPresented(
                By.id("org.wikipedia:id/search_close_btn"),
                "X is still present on the page",
                5

        );
    }

    @Test
    public void testCompareArticleTitle()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find 'Skip' label",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Object-oriented programming language')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );
        WebElement subtitle_element= waitForElementPresent(
                By.id("pcs-edit-section-title-description"),
                "Cannot find Subtitle description",
                15
        );

        String article_subtitle = subtitle_element.getAttribute("text");

        Assert.assertEquals(
                "We see unexpected subtitle",
                "Object-oriented programming language",
                article_subtitle
        );
    }

    @Test
    public void testSwipeArticle()
    {
        waitForElementAndClick(
                        By.xpath("//*[contains(@text,'Skip')]"),
                        "Cannot find 'Skip' label",
                        5
                );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Appium",
                "Cannot find search input",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Automation for Apps')]"),
                "Cannot find 'Automation for Apps' article description",
                10
        );
        waitForElementPresent(
                By.xpath("//*[contains(@text, 'Appium')]"),
                "Cannot find Title",
                15
        );
        swipeUpToFindElement(
                By.xpath("//*[@text='View article in browser']"),
                "Cannot find the end of the article",
                20
        );
    }

    @Test
    public void testSaveFirstArticleToMyList()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find 'Skip' label",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Appium",
                "Cannot find search input",
                10
        );

        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Automation for Apps')]"),
                "Cannot find 'Automation for Apps' article description",
                10
        );
        waitForElementPresent(
                By.xpath("//*[contains(@text, 'Appium')]"),
                "Cannot find Title",
                15
        );
        waitForElementAndClick(
                By.xpath("//android.widget.TextView[@content-desc='Save']"),
                "Cannot find Save tab",
                5

        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find Add to list confirmation label",
                5

        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Test automation",
                "Cannot put text into article folder input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot click OK button",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@content-desc='Navigate up']"),
                "Cannot click Back button",
                5
        );
        waitForElementAndClick(
//                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                By.xpath("//*[@resource-id='org.wikipedia:id/search_toolbar']//*[contains(@content-desc,'Navigate up')]"),
                "Cannot click Back button on the Article list page",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/nav_tab_reading_lists"),
                "Cannot find Saved tab",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Test automation')]"),
                "Cannot find 'Test automation' saved list",
                10
        );
//        waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'Automation for Apps')]"),
//                "Cannot find saved article"
//        );

        swipeElementToLeft(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[contains(@text,'Automation for Apps')]"),
//                By.id("org.wikipedia:id/page_list_item_container"),
//                By.xpath("//*[@resource-id='org.wikipedia:id/reading_list_swipe_refresh']/*[contains(@text,'Automation for Apps')]"),
                By.xpath("//*[@text='Appium']"),
                "Cannot find saved article"
        );
        waitFOrElementNotPresented(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Automation for Apps')]"),
                "Cannot delete saved article",
                5
        );
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find 'Skip' label",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );

        String search_line = "Linkin Park discography";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot find search input",
                10
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@class='android.view.ViewGroup']";
        waitForElementPresent(
                By.xpath(search_result_locator),
                "Cannot find anything by the request"+ search_line,
                15
        );

        int amount_of_search_results = getAmountOfElements(
                By.xpath(search_result_locator)
        );

        Assert.assertTrue(
                "We found too few results!",
                amount_of_search_results > 0
        );

    }
    @Test
    public void testAmountOfEmptySearch()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find 'Skip' label",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );

        String search_line = "ghvhbj";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot find search input",
                10
        );
        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/results_text']";
        String empty_result_label = "//*[@text='No results']";

        waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty results label by the request "+search_line,
                15
        );

        assertElementNotPresent(
                By.xpath(search_result_locator),
                "we've found some result by request " + search_line
        );
    }

    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find 'Skip' label",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                10
        );

        String search_line = "Java";
        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                search_line,
                "Cannot find search input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@class='android.view.ViewGroup']//*[contains(@text,'Object-oriented programming language')]"),
                "Cannot find 'Object-oriented programming language' topic searching by " + search_line,
                15
        );
        String title_before_rotation = waitForElementAndGetAttribute(
                By.xpath("//*[@class='android.view.View']//*[contains(@text,'Java (programming language)')]"),
//                By.id("pcs-edit-section-title-description"),
                "text",
                "Cannot find subtitle of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndGetAttribute(
                By.xpath("//*[@class='android.view.View']//*[contains(@text,'Java (programming language)')]"),
//                By.id("pcs-edit-section-title-description"),
                "text",
                "Cannot find subtitle of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait=new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message +"\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by,error_message, 5);
    }
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by,error_message, 5);
        element.click();
        return element;
    }
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by,error_message, 5);
        element.sendKeys(value);
        return element;
    }

    private boolean waitFOrElementNotPresented(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait=new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message+"\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear (By by, String error_message, long timeoutInSeconds)
    {
        WebElement element= waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width /2;
        int start_y = (int) (size.height * 0.5);
        int end_y = (int) (size.height * 0.2);
        action
                .press(x, start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release()
                .perform();
    }
    protected void swipeUpQuick()
    {
        swipeUp(200);
    }
    protected void swipeUpToFindElement(By by, String error_message, int max_swipes)
    {
        int already_swiped = 0;
        while (driver.findElements(by).size()==0){

            if (already_swiped > max_swipes){
                waitForElementPresent(by, "Cannot find element by swiping up. \n"+ error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;
        }
    }
//

    protected void swipeElementToLeft(By by, String error_message) {
        RemoteWebElement carousel = (RemoteWebElement) waitForElementPresent(
                by,
                error_message,
                10);
        driver.executeScript("gesture: swipe", Map.of("elementId", carousel.getId(), "percentage", 50, "direction", "left"));
    }
    private int getAmountOfElements(By by){
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent (By by, String error_message)
    {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAndGetAttribute(By by,String attribute, String error_message, long timeOutInSeconds)
    {
        WebElement element= waitForElementPresent(by, error_message, timeOutInSeconds);
        return element.getAttribute(attribute);
    }
}