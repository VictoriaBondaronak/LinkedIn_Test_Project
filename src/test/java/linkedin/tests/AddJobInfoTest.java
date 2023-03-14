package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class AddJobInfoTest extends BaseTest {
    @Test
    public void addJobInfoTest() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
        FeedPage feedPage = new FeedPage();
        feedPage.openProfileSubmenu();
        feedPage.navigateToProfile();
        ProfilePage profilePage = new ProfilePage();
        profilePage.addJobInfoClick();
        profilePage.fillJobInfoForm(
                "Manager",
                "Freelance",
                "Minsk",
                "Информационные услуги",
                "Взаимодействие с ключевыми клиентами",
                "Фриланс",
                "Удаленная работа",
                "апрель",
                "2021");
        profilePage.saveJobInfoChanges();
    }
}