package linkedin.pageObject.pages;

import framework.BasePage;
import framework.Browser;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.elements.Frame;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.*;

public class LangSettingsPage extends BasePage {
    private static final By pageLocator = By.xpath("//h1");
    private static final DropDown selectLang = new DropDown( xpath("//select[@class='select-language__language-select']"));
    private static final String SELECTING_OPTION_XPATH = "//option[@value='%s']";


    public LangSettingsPage() {
        super(pageLocator, "'Language settings' Page");
        System.out.println("1");
    }

    public void switchToLangFrame(){
        Browser.switchToFrame(0);
    }

    public void selectLang(String lang) throws InterruptedException {
        switchToLangFrame();
//       List<WebElement> options = selectLang.getElements();
//        for (WebElement option:options) {
//            wait(3000);
//      selectLang.click();
//           selectLang.selectByValue(option.getAttribute("value"));
//           wait(3000);
//           String selectedLang = option.getAttribute("value").substring(0,1);
//           Assert.assertFalse(PAGE.getAttribute("lang")==selectedLang);
//      }

        selectLang.click();
        Label selectingOption = new Label(xpath(String.format(SELECTING_OPTION_XPATH,lang)));
        String langText = selectingOption.getText();
        selectLang.selectByValue(lang);

        System.out.println(langText);
        String selectedLang = "en";
        //Assert.assertFalse(PAGE.getAttribute("lang")==selectedLang);
    }
}
