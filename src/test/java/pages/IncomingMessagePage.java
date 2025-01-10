package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import util.LocatorFactory;

public class IncomingMessagePage extends BasePage{
    public IncomingMessagePage(AndroidDriver driver){
        super(driver);
    }

    public By getShowNotificationButton() {
        return LocatorFactory.getLocator("incomingMessagePage", "btn_Notify_App");
    }
    public By getAlertBoxButton() {
        return LocatorFactory.getLocator("incomingMessagePage", "btn_Notify_Interstitial");
    }

}
