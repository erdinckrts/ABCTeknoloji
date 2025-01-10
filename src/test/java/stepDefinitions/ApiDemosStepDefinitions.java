package stepDefinitions;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class ApiDemosStepDefinitions {
    WebDriver driver=DriverFactory.getDriver();
    WebDriverWait wait;
    ElementHelper elementHelper;

    public ApiDemosStepDefinitions(AndroidDriver driver) throws IOException, URISyntaxException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);

    }
    public ApiDemosStepDefinitions() throws IOException, URISyntaxException {

    }
    @And("App > Activity > Custom Title menusune gidilir")
    public void appActivityCustomTitleMenusuneGidilir() {
       System.out.println("olduuuuuuuu");
    }

}