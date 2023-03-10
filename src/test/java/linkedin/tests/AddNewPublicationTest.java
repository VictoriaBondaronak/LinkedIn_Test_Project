package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

public class AddNewPublicationTest extends BaseTest {
    @Test
    public void addNewPublicationTest(){
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
        FeedPage feedPage = new FeedPage();
        feedPage.newPublicationButtonClick();
        feedPage.newPubMoreButtonClick();
        feedPage.celebrationButtonClick();
        feedPage.addNewPublicationInfo(
                "Новая должность",
                "1",
                "Далее",
                "Публикация");
    }
}
