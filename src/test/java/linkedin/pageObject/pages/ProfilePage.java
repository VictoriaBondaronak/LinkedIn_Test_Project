package linkedin.pageObject.pages;

import framework.BasePage;
import framework.Browser;
import framework.elements.*;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ProfilePage extends BasePage {
    private static final By pageLocator = By.xpath("//h1[@text()='Сообщения']");
    private static final Button hideChats = new Button(xpath("//div[@class='msg-overlay-bubble-header__controls display-flex']/button[2]"));
    private static final String ADD_SECONDARY_LANG_PROFILE_XPATH = "//a[@class='ember-view pv-add-secondary-language-section__button pv-profile-info-section-button__button']";
    private static final String SELECTED_LANG_XPATH = "//option[@value='%s']";
    private static final String LANG_SELECTION_ID = "secondary-language-language";
    private static final String INPUT_FIRSTNAME_ID = "secondary-language-firstname";
    private static final String INPUT_LASTNAME_ID = "secondary-language-lastname";
    private static final String INPUT_TITLE_ID = "secondary-language-headline";
    private static final Button PROFILE_ADD_SUBMIT = new Button(xpath("//button[@class='artdeco-button mlA']"));
    private static final Button LOCALES_PROFILE_BUTTON = new Button(xpath("//li-icon[@type='language-icon']"));
    private static final String DELETE_PROFILE_XPATH = "//li[@id='%s']//button[contains(@class,'pv-update-supported-locales-section__delete-locale-button')]";
    private static final Button DELETE_BUTTON = new Button(xpath("//span[@class='artdeco-button__text' and text()='Удалить']"));
    private String secondaryLang;
    private String secondaryLangText;

    public ProfilePage() {
        super(pageLocator, "'Profile' Page");
    }


    public void addSecondaryLangButtonClick(){
        hideChats.click();
        Button addSecondaryButton = new Button(xpath(ADD_SECONDARY_LANG_PROFILE_XPATH));
        addSecondaryButton.clickAndWait();
    }

    public void chooseLang(String testValue){
        DropDown selectLang = new DropDown(id(LANG_SELECTION_ID));
        selectLang.selectByValue(testValue);
        this.secondaryLang = testValue;
    }

    private void firstnameInput(String value){
        Input firstname = new Input(id(INPUT_FIRSTNAME_ID));
        firstname.sendKeys(value);
    }
    private void lastnameInput(String value){
        Input lastname = new Input(id(INPUT_LASTNAME_ID));
        lastname.sendKeys(value);
    }
    private void titleInput(String value){
        TextBox title = new TextBox(id(INPUT_TITLE_ID));
        title.sendKeys(value);
    }

    public void fillAdditionalProfileForm(String testValue){
        chooseLang(testValue);
        Label selectedLang = new Label(xpath(String.format(SELECTED_LANG_XPATH,testValue)));
        String lang = selectedLang.getText();
        firstnameInput(lang);
        lastnameInput(lang);
        titleInput(lang);
        this.secondaryLangText = lang;
    }

    public void submitAdding(){
        PROFILE_ADD_SUBMIT.clickAndWait();
        PROFILE_ADD_SUBMIT.clickAndWait();
        Browser.reloadPage();

        Button secondLangProfile = new Button(xpath(String.format("//span[@class='artdeco-button__text' and @text()='%s'])", this.secondaryLangText)));
        secondLangProfile.waitForElementsArePresent();
        Assert.assertEquals(this.secondaryLangText, secondLangProfile.getText());
    }

    public void deleteSecondaryLang(){

        if(this.secondaryLang == null) {return;}

        LOCALES_PROFILE_BUTTON.clickAndWait();
        Button deleteProfileButton = new Button(By.xpath(String.format(DELETE_PROFILE_XPATH, this.secondaryLang)));

        deleteProfileButton.clickAndWait();
        DELETE_BUTTON.clickAndWait();
        Assert.assertNull(new Button(xpath(String.format("//span[@class='artdeco-button__text' and @value='%s'])", this.secondaryLang))));
        this.secondaryLang = null;
    }
}
