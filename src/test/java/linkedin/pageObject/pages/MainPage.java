package linkedin.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class MainPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//icon[@data-test-id='nav-logo']");
    private static final String LOGIN_BUTTON = "//button[@data-id='sign-in-form__submit-btn']";
    private static final String LOGIN_INPUT = "session_key";
    private static final String PASSWORD_INPUT = "session_password";
    private static final String ALERT_MESSAGE_XPATH = "//p[@role='alert' and @for='session_password']";

    public MainPage() {
        super(PAGE_LOCATOR, "'Main' Page");
    }

    public void input(String login, String password){
        Input username = new Input(id(LOGIN_INPUT));
        username.sendKeys(login);
        Input pass = new Input(id(PASSWORD_INPUT));
        pass.sendKeys(password);
    }

    public void isAlertMessageExist(){
        Assert.assertTrue(new Label(By.xpath(ALERT_MESSAGE_XPATH)).getText() != null);

    }
    public void submitClick(){
        Button loginButton = new Button(xpath(LOGIN_BUTTON));
        loginButton.clickAndWait();
    }
}