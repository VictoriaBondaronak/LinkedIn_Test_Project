package linkedin.pageObject.pages;

import framework.BasePage;
import framework.Browser;
import framework.PropertyReader;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static framework.DriverFactory.driver;
import static org.openqa.selenium.By.*;

public class FeedPage extends BasePage {
    private static final By pageLocator = By.xpath("//div[@class='feed-identity-module__actor-meta break-words']");

    private static final String NAV_MENU_ITEM = "//a[@class='app-aware-link  global-nav__primary-link' and contains(@href,'%s')]";
    private static final String FEED_BUTTON = "//div[@class='scaffold-finite-scroll__content']/div[%s]//button[contains(@class,'feed-shared-control-menu__trigger')]";
    private static final String FEED_SUBMENU = "//div[@class='scaffold-finite-scroll__content']/div[%d]//div[@class='artdeco-dropdown__content-inner']";
    private static final Button NEW_PUBLICATION_BUTTON = new Button(By.xpath("//span[text()='Новая публикация']/../.."));
    private static final String NEW_PUBLICATION_MENU_BUTTON_XPATH = "//ul[@class='artdeco-carousel__slider ember-view']/li[%s]";
    private static final String NEW_PUBLICATION_MENU_TYPE_XPATH = "//p[text()='%s']/../..";
    private static final String CHOOSING_IMAGE = "//ul[@class='team-moments-celebration-image-chooser__theme-list']/li[%s]";
    private static final String PUBLICATION_BUTTON_XPATH = "//span[text()='%s']";
    private int FEED_ITEM_INDEX;
    Button PROFILE_MENU_BUTTON = new Button(xpath("//button[contains(@class,'global-nav__primary-link-me-menu-trigger')]"));

    Input GLOBAL_SEARCH = new Input(className("search-global-typeahead__input"));



    public FeedPage() {
        super(pageLocator, "'Feed' Page");
    }


    public void navigateToNavMenuItem(String hrefText){
        Label item = new Label(xpath(String.format(NAV_MENU_ITEM, hrefText)));
        item.clickAndWait();
    }

    public void navigateToProfile(){
        Button seeProfileButton = new Button(xpath("//header[@class='p2']//a[text()='См. профиль']"));
        seeProfileButton.clickAndWait();
    }

    public void openProfileSubmenu() throws InterruptedException {
        PROFILE_MENU_BUTTON.clickAndWait();
        Thread.sleep(2000);
    }

    public void submenuItemClick(){
        Button profileSubmenuItem = new Button(xpath("//a[contains(@href,'language')]"));
        profileSubmenuItem.clickAndWait();
    }

    public void globalSearch(String searchingValue){
        GLOBAL_SEARCH.click();
        GLOBAL_SEARCH.sendKeys(searchingValue);
        GLOBAL_SEARCH.sendKeys(String.valueOf(Keys.ENTER));
    }

    public void feedButtonClick(int index){
        Button feedButton = new Button(xpath(String.format(FEED_BUTTON, index)));
        feedButton.clickAndWait();
        this.FEED_ITEM_INDEX = index;
    }

    public void chooseFeedSubmenu(int submenuItemIndex){
        Label submenu = new Label(xpath(String.format(FEED_SUBMENU,FEED_ITEM_INDEX)));
        List<WebElement> elements = submenu.getElements();
        elements.get(submenuItemIndex).click();
    }

    public void newPublicationButtonClick(){
        NEW_PUBLICATION_BUTTON.clickAndWait();
    }
    public void clickOnItem(String xpath, String value){
        Button item = new Button(By.xpath(String.format(xpath,value)));
        item.clickAndWait();
    }

    public void addNewPublicationInfo(){
        clickOnItem(NEW_PUBLICATION_MENU_BUTTON_XPATH,"4");
        clickOnItem(NEW_PUBLICATION_MENU_BUTTON_XPATH,"4");
        clickOnItem(NEW_PUBLICATION_MENU_TYPE_XPATH,"Новая должность");
        clickOnItem(CHOOSING_IMAGE,"1");
        clickOnItem(PUBLICATION_BUTTON_XPATH,"Далее");
        clickOnItem(PUBLICATION_BUTTON_XPATH,"Публикация");
    }
}
