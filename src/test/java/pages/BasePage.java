package pages;

import io.appium.java_client.android.AndroidDriver;
import util.LocatorFactory;

public class BasePage {
    protected LocatorFactory locatorFactory;

    public BasePage(AndroidDriver driver) {
        this.locatorFactory = new LocatorFactory(driver);
    }
}
