package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class SearchCompanyTest extends BaseTest {
    @Test
    public void searchCompanyTest(){
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
        FeedPage feedPage = new FeedPage();
        feedPage.globalSearch(searchingValue);
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.useFilter("Компании");
    }
}