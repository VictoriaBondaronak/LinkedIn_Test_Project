package framework.elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
@Log4j2
public class Input extends BaseElement {
    public Input(By by) {
        super(by);
    }

    public Input(By by, String name) {
        super(by, name);
    }
    @Override
    protected String getElementType() {
        return "Input:";
    }


    public void sendKeys(String sendKeys) {
        isElementPresent();
        log.info(getElementType() + ":" + by + " - method 'sendKeys' was called");
        getElement().sendKeys(sendKeys);
    }

    public void clear() {
        isElementPresent();
        log.info(getElementType() + ":" + by + " - method 'clear' was called");
        getElement().clear();
    }
}
