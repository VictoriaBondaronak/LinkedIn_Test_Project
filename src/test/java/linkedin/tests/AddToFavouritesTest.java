package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class AddToFavouritesTest extends BaseTest {
    @Test
    public void addToFavouritesTest(){
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
        FeedPage feedPage = new FeedPage();
        feedPage.feedButtonClick(1);
        feedPage.chooseFeedSubmenu(0);
    }
}