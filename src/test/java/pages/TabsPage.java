package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TabsPage extends BasePage{
    public TabsPage(AndroidDriver driver){super(driver);}


    public By getBtnScrollable() {
        return locatorFactory.getLocator("tabsPage", "btn_Scrollable");
    }}
