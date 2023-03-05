package linkedin.pageObject;

import framework.BasePage;
import framework.PropertyReader;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.testng.Assert;

import static org.openqa.selenium.By.*;

public class MessagingPage extends BasePage {
    private  static final Label PAGE_LOCATOR = new Label(xpath("//h1[text()='Сообщения']"));
    private static final By pageLocator = By.xpath("//h1[text()='Сообщения']");

    private static final String NEW_MESSAGE_ID = "#compose-medium";
    private static final String SEARCH_INPUT_XPATH = "//input[contains(@class,'msg-connections-typeahead__search-field')]";
    private static final String SEARCH_RESULT_XPATH = "//button[contains(@class,'display-flex flex-row align-items-center msg-connections-typeahead__search-result')]";
    private static final String INSERT_MESSAGE_XPATH = "//div[@aria-label='Напишите сообщение…']";
    private static final String SEND_MESSAGE_BUTTON_CLASS = "msg-form__send-button artdeco-button artdeco-button--1";

    public MessagingPage() {
        super(pageLocator, "'Messaging' Page");
    }


    public void newMessage(String addresseeName, String addresseeSurname){
        //Button newMessageButton = new Button(id(NEW_MESSAGE_ID));
        //newMessageButton.clickAndWait();
        Input searchInput = new Input(xpath(SEARCH_INPUT_XPATH));
        searchInput.click();
        searchInput.sendKeys(addresseeName + " " + addresseeSurname);
        Button searchResult = new Button(xpath(SEARCH_RESULT_XPATH));
        searchResult.clickAndWait();
//        Input messageInput = new Input(xpath(INSERT_MESSAGE_XPATH));
//        messageInput.click();
//        messageInput.sendKeys(String.format("Hello %s", addresseeName));
//        Button send = new Button(className(SEND_MESSAGE_BUTTON_CLASS));
//        send.click();

    }
}
