package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NotificationPage extends BasePage {
    public NotificationPage(AndroidDriver driver){
        super(driver);
    }

    public By getIncomingMessageButton() {
        return locatorFactory.getLocator("notificationPage","btn_IncomingMessage");
    }

    public By getNotifyingServiceControllerButton() {
        return locatorFactory.getLocator("notificationPage","btn_NotifyingServiceController");
    }

    public By getNotifyWithTextButton() {
        return locatorFactory.getLocator("notificationPage","btn_NotifyWithText");
    }

    public By getStatusBarButton() {
        return locatorFactory.getLocator("notificationPage","btn_StatusBar");
    }
}
