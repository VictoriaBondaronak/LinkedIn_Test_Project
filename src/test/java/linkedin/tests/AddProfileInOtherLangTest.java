package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class AddProfileInOtherLangTest extends BaseTest {
    @Test
    public void addProfileInOtherLangTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
        FeedPage feedPage = new FeedPage();
        feedPage.openProfileSubmenu();
        feedPage.navigateToProfile();
        ProfilePage profilePage = new ProfilePage();
        profilePage.addSecondaryLangButtonClick();
        profilePage.fillAdditionalProfileForm("en_US");
        profilePage.submitAdding();
    }
}
