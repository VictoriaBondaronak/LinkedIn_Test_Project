package linkedin.pageObject;

import framework.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage {
    private static final By pageLocator = By.xpath("//svg[@class='mercado-match']");
    private static final String FILTER_ITEM = "//li[@class='search-reusables__primary-filter']/button[text()='%s']";


    public SearchResultsPage() {
        super(pageLocator, "'Search results' Page");
    }

    public void useFilter(String filterValue){
        Button filterButton = new Button(By.xpath(String.format(FILTER_ITEM, filterValue)));
        filterButton.click();
    }

    public void areTheResultsRight(){

    }





}
