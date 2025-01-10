package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NotificationBarPage extends BasePage{
    public NotificationBarPage(AndroidDriver driver){
        super(driver);
    }

    public By getShortTextButton() {
        return locatorFactory.getLocator("notificationBarPage", "btn_short_text");
    }

    public By getDetailText() {
        return locatorFactory.getLocator("notificationBarPage", "txt_detail");
    }
}
