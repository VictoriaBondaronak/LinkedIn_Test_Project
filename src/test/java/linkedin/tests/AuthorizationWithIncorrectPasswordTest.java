package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class AuthorizationWithIncorrectPasswordTest extends BaseTest {
    @Test
    public void authorizationWithIncorrectPasswordTest(){
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, incorrectPassword);
        mainPage.isAlertMessageExist();
    }
}
