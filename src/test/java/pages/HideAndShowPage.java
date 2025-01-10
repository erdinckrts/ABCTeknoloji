package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HideAndShowPage extends BasePage{
    public HideAndShowPage(AndroidDriver driver){super(driver);}

    public By getBtnHideFrag1() {
        return locatorFactory.getLocator("hideAndShowPage", "btn_Hide_Frag1");
    }

    public By getBtnHideFrag2() {
        return locatorFactory.getLocator("hideAndShowPage", "btn_Hide_Frag2");
    }

    public By getTextFragment1() {
        return locatorFactory.getLocator("hideAndShowPage", "text_Fragment_1");
    }

    public By getTextFragment2() {
        return locatorFactory.getLocator("hideAndShowPage", "text_Fragment_2");
    }


}
