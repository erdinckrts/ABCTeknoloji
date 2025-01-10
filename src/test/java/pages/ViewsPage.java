package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ViewsPage extends BasePage{
    public ViewsPage(AndroidDriver driver){
        super(driver);
    }

    public By getBtnTabs() {
        return locatorFactory.getLocator("viewsPage", "btn_Tabs");
    }}
