package linkedin.pageObject.pages;

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
    private static final By pageLocator = By.xpath("//li-icon[@type='app-linkedin-bug-color-icon']");

    private static final String CLOSE_BUTTON_XPATH = "//button[@aria-label='%s')";
    private static final String SEARCH_INPUT_XPATH = "//input[contains(@class,'msg-connections-typeahead__search-field')]";
    private static final String SEARCH_RESULT_XPATH = "//button[contains(@class,'display-flex flex-row align-items-center msg-connections-typeahead__search-result')]";
    private static final String INSERT_MESSAGE_XPATH = "//div[@aria-label='Напишите сообщение…']";
    private static final String SEND_MESSAGE_BUTTON_CLASS = "msg-form__send-button artdeco-button artdeco-button--1";

    public MessagingPage() {
        super(pageLocator, "'Messaging' Page");
    }


    public void newMessage(String addresseeName, String addresseeSurname){
        Input searchInput = new Input(xpath(SEARCH_INPUT_XPATH));
        searchInput.click();
        searchInput.sendKeys(addresseeName + " " + addresseeSurname);
        Button searchResult = new Button(xpath(SEARCH_RESULT_XPATH));
        searchResult.clickAndWait();

    }
}