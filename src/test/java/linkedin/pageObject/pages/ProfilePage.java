package linkedin.pageObject.pages;

import framework.BasePage;
import framework.Browser;
import framework.elements.*;
import framework.elements.Button;
import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.xml.xpath.XPath;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ProfilePage extends BasePage {
    private static final By pageLocator = By.xpath("//div[@class='profile-background-image profile-background-image--default']");
    private static final Button hideChats = new Button(xpath("//div[@class='msg-overlay-bubble-header__controls display-flex']/button[2]"));
    private static final String ADD_SECONDARY_LANG_PROFILE_XPATH = "//a[@class='ember-view pv-add-secondary-language-section__button pv-profile-info-section-button__button']";
    private static final String ADD_PROFILE_PHOTO_XPATH = "//button[@class='profile-photo-edit__edit-btn']";
    private static final String SELECTED_LANG_XPATH = "//option[@value='%s']";
    private static final String LANG_SELECTION_ID = "secondary-language-language";
    private static final Button PROFILE_ADD_SUBMIT = new Button(xpath("//button[@class='artdeco-button mlA']"));
    private static final Button LOCALES_PROFILE_BUTTON = new Button(xpath("//li-icon[@type='language-icon']"));
    private static final String DELETE_PROFILE_XPATH = "//li[@id='%s']//button[contains(@class,'pv-update-supported-locales-section__delete-locale-button')]";
    private static final Button DELETE_BUTTON = new Button(xpath("//span[@class='artdeco-button__text' and text()='Удалить']"));
    private static final String ADD_JOB_INFO_ID = "overflow-Добавить-сведения-об-опыте-работы";
    private static final String ADD_POSITION_XPATH = "//*[contains(@href,'add-edit/POSITION')]";
    private static final String FORM_FIELD_XPATH = "//input[contains(@id,'%s')]";
    private static final String DESCRIPTION_XPATH = "//textarea[contains(@id,'%s')]";
    private static final String DROPDOWN_XPATH = "//select[contains(@id,'%s')]";
    private static final String TRIGGERED_CONTENT_ELEMENT_XPATH = "//div[contains(@class,'triggered-content')]//*[contains(text(),'%s')]";

    private static final Button SAVE_BUTTON = new Button(xpath("//span[text()='Сохранить']/.."));
    private static final String PHOTO_MENU_BUTTON_XPATH = "//span[text()='%s']";
    private static final Button DISMISS_BUTTON = new Button(xpath("//button[@aria-label='Пропустить']"));
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

    public void addProfilePhotoButtonClick(){
        Button addPhotoButton = new Button(xpath(ADD_PROFILE_PHOTO_XPATH));
        addPhotoButton.clickAndWait();
    }

    public void addPhoto() throws URISyntaxException {
        Button addPhoto = new Button(xpath(String.format(PHOTO_MENU_BUTTON_XPATH,"Добавить фото")));
        addPhoto.clickAndWait();
        Input photoSelection = new Input(By.id("image-selector__file-upload-input"));
        URL resource = Main.class.getResource("/profilephoto.jpeg");
        String absolutePath = Paths.get(resource.toURI()).toString();
        photoSelection.clear();
        photoSelection.sendKeys(absolutePath);
        Button savePhoto = new Button(xpath(String.format(PHOTO_MENU_BUTTON_XPATH,"Сохранить фото")));
        savePhoto.clickAndWait();
    }

    private void formChooseByText(String xpath,String testValue){
        DropDown selection = new DropDown(By.xpath(String.format(DROPDOWN_XPATH,xpath)));
        selection.selectByText(testValue);
        this.secondaryLang = testValue;
    }

    private void formTextFieldInput(String xpath, String value){
        Input textField = new Input(By.xpath(String.format(FORM_FIELD_XPATH,xpath)));
        textField.sendKeys(value);
    }
    private void formTextAreaInput(String xpath, String value){
        TextBox textArea = new TextBox(By.xpath(String.format(DESCRIPTION_XPATH,xpath)));
        textArea.sendKeys(value);
    }

    public void fillAdditionalProfileForm(String testValue){
        formChooseByText("secondary-language",testValue);
        Label selectedLang = new Label(xpath(String.format(SELECTED_LANG_XPATH,testValue)));
        String lang = selectedLang.getText();
        formTextFieldInput("firstname",lang);
        formTextFieldInput("lastname",lang);
        formTextAreaInput("headline",lang);
        this.secondaryLangText = lang;
    }

    public void fillJobInfoForm(){
        formTextFieldInput("title","Manager");
        formTextFieldInput("requiredCompany","Freelance");
        formTextFieldInput("geoPositionLocation","Minsk");
        formTextFieldInput("industryId","Информационные услуги");
        formTextAreaInput("description","Взаимодействие с ключевыми клиентами");
        formChooseByText("employmentStatus","Фриланс");
        formChooseByText("locationType","Удаленная работа");
        formChooseByText("dateRange-start-date","апрель");
        formChooseByText("start-date-year-select","2021");
    }

    private void chooseProposedItem(String xpath){
        Label item = new Label(By.xpath(String.format(TRIGGERED_CONTENT_ELEMENT_XPATH,xpath)));
        item.clickAndWait();
    }

    public void saveJobInfoChanges(){
        SAVE_BUTTON.clickAndWait();
        DISMISS_BUTTON.clickAndWait();
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

    public void addJobInfoClick(){
        Button addJobInfo = new Button(By.id(ADD_JOB_INFO_ID));
        addJobInfo.clickAndWait();
        Button addPosition = new Button(By.xpath(ADD_POSITION_XPATH));
        addPosition.clickAndWait();
    }


}
