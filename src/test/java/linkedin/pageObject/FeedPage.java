package linkedin.pageObject;

import framework.BasePage;
import framework.PropertyReader;
import framework.elements.Button;
import framework.elements.Input;
import framework.elements.Label;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static org.openqa.selenium.By.*;

public class FeedPage extends BasePage {
    //private  static final Label PAGE_LOCATOR = new Label(xpath("//svg[@class='mercado-match']"));
    private static final By pageLocator = By.xpath("//div[@class='feed-identity-module__actor-meta break-words']");

    private static final String NAV_MENU_ITEM = "//a[@class='app-aware-link  global-nav__primary-link' and contains(@href,'%s')]";
    private static final String FEED_BUTTON = "//div[@class='scaffold-finite-scroll__content']/div[1]//button[contains(@class,'feed-shared-control-menu__trigger')]";
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
        PROFILE_MENU_BUTTON.clickAndWait();
        Button profileSubmenuItem = new Button(xpath("//header[@class='p2']//a[text()='См. профиль']"));
        profileSubmenuItem.clickAndWait();

    }

    public void navigateToLangSettings(){
        System.out.println("4");
        PROFILE_MENU_BUTTON.clickAndWait();
        System.out.println("5");
        Button profileSubmenuItem = new Button(xpath("//a[contains(@href,'language')]"));
        System.out.println("6");
        profileSubmenuItem.clickAndWait();
        System.out.println("7");

    }

    public void globalSearch(String searchingValue){
        GLOBAL_SEARCH.click();
        GLOBAL_SEARCH.sendKeys(searchingValue);
        GLOBAL_SEARCH.sendKeys(String.valueOf(Keys.ENTER));
    }
}
