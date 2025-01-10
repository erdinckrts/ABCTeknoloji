package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ScrollablePage extends BasePage{
    public ScrollablePage(AndroidDriver driver){
        super(driver);
    }

    public By getScrollBarTab() {
        return locatorFactory.getLocator("scrollablePage", "scrollBar_tab");
    }

    public By getTab30Button() {
        return locatorFactory.getLocator("scrollablePage", "btn_Tab_30");
    }

    public By getTab30TextView() {
        return locatorFactory.getLocator("scrollablePage", "btn_Tab_30_Content");
    }
}
