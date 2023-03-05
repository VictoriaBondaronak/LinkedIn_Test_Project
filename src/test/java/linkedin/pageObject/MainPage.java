package linkedin.pageObject;

import framework.BasePage;
import framework.PropertyReader;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class MainPage extends BasePage {
    private  static final Label PAGE_LOCATOR = new Label(xpath("//icon[@data-test-id='nav-logo']"));
    private static final By pageLocator = By.xpath("//icon[@data-test-id='nav-logo']");

    //private static final String LOGIN_BUTTON = "//button[@class='sign-in-form__submit-button']";
    private static final String LOGIN_BUTTON = "//button[@data-id='sign-in-form__submit-btn']";
    private static final String LOGIN_INPUT = "session_key";
    private static final String PASSWORD_INPUT = "session_password";
    //private static final String PASSWORD = new PropertyReader("config.properties").getProperty("password");
    //private static final String LOGIN = new PropertyReader("config.properties").getProperty("login");

    public MainPage() {
        super(pageLocator, "'Main' Page");
    }

    public void input(String login, String password){
        Input username = new Input(id(LOGIN_INPUT));
        username.sendKeys(login);
        Input pass = new Input(id(PASSWORD_INPUT));
        pass.sendKeys(password);
    }

    public void isAlertMessageExist(){
        Assert.assertTrue(new Label(By.xpath("//p[@role='alert' and @for='session_password']")).getText() != null);

    }
    public void submitClick(){
        Button loginButton = new Button(xpath(LOGIN_BUTTON));
        loginButton.clickAndWait();
    }
}
