package linkedin.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;

public class MessagingPage extends BasePage {
    private static final By pageLocator = By.xpath("//li-icon[@type='app-linkedin-bug-color-icon']");

    private static final String CLOSE_BUTTON_XPATH = "//button[@aria-label='%s')";
    private static final String SEARCH_INPUT_XPATH = "//input[contains(@class,'msg-connections-typeahead__search-field')]";
    private static final String SEARCH_RESULT_XPATH = "//button[contains(@class,'display-flex flex-row align-items-center msg-connections-typeahead__search-result')]";
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