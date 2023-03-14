package linkedin.tests;

import framework.BaseTest;
import framework.PropertyReader;
import linkedin.pageObject.pages.*;
import org.testng.annotations.Test;

public class SendMessageTest extends BaseTest {
    @Test
    public void sendMessageTest() {
        MainPage mainPage = new MainPage();
        mainPage.input(correctLogin, correctPassword);
        mainPage.submitClick();
        FeedPage feedPage = new FeedPage();
        feedPage.navigateToNavMenuItem("messaging");
        MessagingPage messagingPage = new MessagingPage();
        messagingPage.newMessage(addresseeName, addresseeSurname);
    }
}