package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class AddProfilePhotoTest extends BaseTest {
    @Test
    public void addProfilePhotoTest() throws InterruptedException, URISyntaxException {
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
        FeedPage feedPage = new FeedPage();
        feedPage.openProfileSubmenu();
        feedPage.navigateToProfile();
        ProfilePage profilePage = new ProfilePage();
        profilePage.addProfilePhotoButtonClick();
        profilePage.addPhoto(
                "Добавить фото",
                "Сохранить фото",
                "/profilephoto.jpeg");
    }
}