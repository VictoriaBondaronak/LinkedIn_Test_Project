package linkedin.pageObject.pages;

import framework.BasePage;
import framework.Browser;
import framework.elements.DropDown;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.testng.Assert;
import static org.openqa.selenium.By.*;

public class LangSettingsPage extends BasePage {
    private static final By PAGE_LOCATOR = By.xpath("//h1");
    private static final Label PAGE = new Label(By.xpath("//html"));
    private static final DropDown SELECT_LANG = new DropDown( xpath("//select[@class='select-language__language-select']"));
    private static final String SELECTING_OPTION_XPATH = "//option[@value='%s']";


    public LangSettingsPage() {
        super(PAGE_LOCATOR, "'Language settings' Page");
        System.out.println("1");
    }

    public void switchToLangFrame(){
        Browser.switchToFrame(0);
    }

    public void selectLang(String lang) throws InterruptedException {
        switchToLangFrame();
        SELECT_LANG.click();
        Label selectingOption = new Label(xpath(String.format(SELECTING_OPTION_XPATH,lang)));
        String langText = selectingOption.getText();
        SELECT_LANG.selectByValue(lang);
        String selectedLang = lang.substring(0,1);
        Assert.assertFalse(PAGE.getAttribute("lang")==selectedLang);
    }
}