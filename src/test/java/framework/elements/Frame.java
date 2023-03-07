package framework.elements;

import org.openqa.selenium.By;

public class Frame extends BaseElement{

    public Frame(By by) {
        super(by);
    }

    public Frame(By by, String name) {
        super(by, name);
    }

    @Override
    protected String getElementType() {
        return "Frame:";
    }
}