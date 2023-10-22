package tests;

import lib.CoreTestCase;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    public void testPassThroughWelcome()
    {
        if (this.Platform.isAndroid()){
            return;
        }
        WelcomePageObject WelcomePage = new WelcomePageObject(driver);

        WelcomePage.waitForLearnMoreLink();
//        WelcomePage.clickSkipButton();
        WelcomePage.clickNextButton();

        WelcomePage.waitForNewWaysToExploreText();
        WelcomePage.clickNextButton();

        WelcomePage.waitForAddPreferredLanguage();
        WelcomePage.clickNextButton();

        WelcomePage.waitForLearnMoreAboutDataCollected();
        WelcomePage.clickGetStartedButton();
    }
}
