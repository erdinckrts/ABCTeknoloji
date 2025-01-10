package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.io.IOException;

public class ActivityPage extends BasePage{
    public ActivityPage(AndroidDriver driver) throws IOException {super(driver);}

    public By getCustomTitleButton() {
        return locatorFactory.getLocator("activityPage", "btn_CustomTitle");
    }
}
