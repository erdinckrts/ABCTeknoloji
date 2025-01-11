package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) throws IOException {super(driver);}

    public By getAppButton() {
        return locatorFactory.getLocator("homePage", "btn_App");
    }
    public By getViewButton() {
        return locatorFactory.getLocator("homePage", "btn_Views");
    }
}
