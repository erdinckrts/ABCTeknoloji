package pages;

import org.openqa.selenium.WebDriver;
import util.LocatorFactory;

public class BasePage {
    protected static LocatorFactory locatorFactory;

    public BasePage(WebDriver driver) {
        this.locatorFactory = new LocatorFactory(driver);
    }
}
