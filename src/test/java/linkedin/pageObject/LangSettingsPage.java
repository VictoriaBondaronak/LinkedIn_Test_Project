package linkedin.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.DropDown;
import framework.elements.Label;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.*;

public class LangSettingsPage extends BasePage {
    private static final By pageLocator = By.xpath("//h1");

    private static final Label PAGE = new Label(className("artdeco windows theme--dark-lix"));
    private static final DropDown selectLang = new DropDown( xpath("//select[@class='select-language__language-select']"));
    private static final String SELECTING_OPTION_XPATH = "//option[@value='%s']";


    public LangSettingsPage() {
        super(pageLocator, "'Language settings' Page");
        System.out.println("1");
    }


    public void selectLang() throws InterruptedException {

 //       List<WebElement> options = selectLang.getElements();
//        for (WebElement option:options) {
//            wait(3000);
//            selectLang.selectByValue(option.getAttribute("value"));
//            wait(3000);
//            String selectedLang = option.getAttribute("value").substring(0,1);
//            Assert.assertFalse(PAGE.getAttribute("lang")==selectedLang);
//        }
        System.out.println("2");
        selectLang.selectByText("English (английский)");
        System.out.println("3");
//        Label selectingOption = new Label(xpath(String.format(SELECTING_OPTION_XPATH,lang)));
//        String langText = selectingOption.getText();
//        String selectedLang = "en";
        //Assert.assertFalse(PAGE.getAttribute("lang")==selectedLang);
    }
}
