package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import util.LocatorFactory;

public class BasePage {
    protected LocatorFactory locatorFactory;

    public BasePage(WebDriver driver) {
        this.locatorFactory = new LocatorFactory(driver);
    }
}
