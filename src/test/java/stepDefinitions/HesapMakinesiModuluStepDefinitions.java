package stepDefinitions;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import util.DriverFactory;
import util.ElementHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class HesapMakinesiModuluStepDefinitions {
    WebDriverWait wait;
    ElementHelper elementHelper;
    static WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage =new LoginPage(driver);
    BaseActions baseActions = new BaseActions(driver);

    public HesapMakinesiModuluStepDefinitions(AndroidDriver driver) throws IOException, URISyntaxException {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);

    }
    public HesapMakinesiModuluStepDefinitions() throws IOException, URISyntaxException {

    }
    @And("App > Activity > Custom Title menusune gidilir")
    public void appActivityCustomTitleMenusuneGidilir() {
       System.out.println("olduuuuuuuu");
       baseActions.write(loginPage.getLoginTextBox(),"erdinckrts");
       baseActions.write(loginPage.getPasswordTextBox(),"123qwe123qweC.");
       //baseActions.click(loginPage.getLoginButton());

    }

}