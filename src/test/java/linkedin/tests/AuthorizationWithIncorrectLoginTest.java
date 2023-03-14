package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class AuthorizationWithIncorrectLoginTest extends BaseTest {
    @Test
    public void authorizationWithIncorrectLoginTest(){
        MainPage mainPage = new MainPage();
        mainPage.input(incorrectLogin, correctPassword);
        mainPage.isAlertMessageExist();
    }
}
