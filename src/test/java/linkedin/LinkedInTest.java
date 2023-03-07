package linkedin;

import framework.BaseTest;
import framework.Browser;
import framework.PropertyReader;
import framework.elements.Label;
import linkedin.pageObject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class  LinkedInTest extends BaseTest {
    String correctPassword = new PropertyReader("config.properties").getProperty("correctPassword");
    String correctLogin = new PropertyReader("config.properties").getProperty("correctLogin");
    String incorrectPassword = new PropertyReader("config.properties").getProperty("incorrectPassword");
    String incorrectLogin = new PropertyReader("config.properties").getProperty("incorrectLogin");
    String addresseeName = new PropertyReader("config.properties").getProperty("addresseeName");
    String addresseeSurname = new PropertyReader("config.properties").getProperty("addresseeSurname");
    String searchingValue = new PropertyReader("config.properties").getProperty("searchingValue");

    @Test
    public void authorizationWithCorrectDataTest() {
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
    }
    @Test
    public void sendMessageTest() {
        authorizationWithCorrectDataTest();
        FeedPage feedPage = new FeedPage();
        feedPage.navigateToNavMenuItem("messaging");
        MessagingPage messagingPage = new MessagingPage();
        messagingPage.newMessage(addresseeName, addresseeSurname);
    }

    @Test
    public void authorizationWithIncorrectPasswordTest(){
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, incorrectPassword);
        mainPage.isAlertMessageExist();
    }

    @Test
    public void addProfileInOtherLangTest() throws InterruptedException {
        authorizationWithCorrectDataTest();
        FeedPage feedPage = new FeedPage();
        feedPage.openProfileSubmenu();
        feedPage.navigateToProfile();
        ProfilePage profilePage = new ProfilePage();
        profilePage.addSecondaryLangButtonClick();
        profilePage.fillAdditionalProfileForm("en_US");
        profilePage.submitAdding();

        //profilePage.deleteSecondaryLang();
    }

    @Test
    public void changeLangTest() throws InterruptedException {
        authorizationWithCorrectDataTest();
        FeedPage feedPage = new FeedPage();
        feedPage.openProfileSubmenu();
        feedPage.submenuItemClick();
        LangSettingsPage langSettingsPage = new LangSettingsPage();
        langSettingsPage.selectLang("en_US");
    }

    @Test
    public void searchCompanyTest(){
        authorizationWithCorrectDataTest();
        FeedPage feedPage = new FeedPage();
        feedPage.globalSearch(searchingValue);
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.useFilter("Компании");
    }

    @Test
    public void addToFavouritesTest(){
        authorizationWithCorrectDataTest();
        FeedPage feedPage = new FeedPage();
        feedPage.feedButtonClick(1);
        feedPage.chooseFeedSubmenu(0);


    }

}
