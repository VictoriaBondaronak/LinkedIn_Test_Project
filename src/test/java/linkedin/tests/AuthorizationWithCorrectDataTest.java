package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

public class AuthorizationWithCorrectDataTest extends BaseTest {
    @Test
    public void authorizationWithCorrectDataTest() {
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
    }
}