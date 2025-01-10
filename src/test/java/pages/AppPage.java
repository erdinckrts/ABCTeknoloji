package pages;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;

public class AppPage extends BasePage{
    public AppPage(AndroidDriver driver) throws IOException {super(driver);}

    public By getActionBarButton() {
        return locatorFactory.getLocator("appPage", "btn_ActionBar");
    }

    public By getActivityButton() {
        return locatorFactory.getLocator("appPage", "btn_Activity");
    }

    public By getAlarmButton() {
        return locatorFactory.getLocator("appPage", "btn_Alarm");
    }

    public By getAlertDialogsButton() {
        return locatorFactory.getLocator("appPage", "btn_AlertDialogs");
    }

    public By getDeviceAdminButton() {
        return locatorFactory.getLocator("appPage", "btn_DeviceAdmin");
    }

    public By getFragmentButton() {
        return locatorFactory.getLocator("appPage", "btn_Fragment");
    }

    public By getLauncherShortcutsButton() {
        return locatorFactory.getLocator("appPage", "btn_LauncherShortcuts");
    }

    public By getLoaderButton() {
        return locatorFactory.getLocator("appPage", "btn_Loader");
    }

    public By getMenuButton() {
        return locatorFactory.getLocator("appPage", "btn_Menu");
    }

    public By getNotificationButton() {
        return locatorFactory.getLocator("appPage", "btn_Notification");
    }

    public By getSearchButton() {
        return locatorFactory.getLocator("appPage", "btn_Search");
    }

    public By getServiceButton() {
        return locatorFactory.getLocator("appPage", "btn_Service");
    }

    public By getTextToSpeechButton() {
        return locatorFactory.getLocator("appPage", "btn_TextToSpeech");
    }

    public By getVoiceRecognitionButton() {
        return locatorFactory.getLocator("appPage", "btn_VoiceRecognition");
    }
}
