package stepDefinitions;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CalculatorPage;
import pages.LoginPage;
import pages.StagePage;
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
    StagePage stagePage = new StagePage(driver);
    CalculatorPage calculatorPage =new CalculatorPage(driver);
    ClcActions clcActions =new ClcActions(driver);
    BaseActions baseActions = new BaseActions(driver);
    String faizOran;
    String anaPara;
    String clcSonuc;


    public HesapMakinesiModuluStepDefinitions(AndroidDriver driver) throws IOException, URISyntaxException {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public HesapMakinesiModuluStepDefinitions() throws IOException, URISyntaxException {
    }

    @Given("Calculator Sayfasi Acilir")
    public void catchylabsWebclientSitesineLoginOlunur() {
        baseActions.write(loginPage.getLoginTextBox(),"erdinckrts");
        baseActions.write(loginPage.getPasswordTextBox(),"123qwe123qweC.");
        baseActions.click(loginPage.getLoginButton());
        baseActions.click(stagePage.getOpenCalculatorButton());
    }


    @Given("Yatirim tutari {double} ve faiz oranı %{double} olarak verilir")
    public void yatirimTutariVeFaizOranıOlarakVerilir(double anaPara, double oran) {
        this.faizOran=Double.toString(oran/(double) 100);
        this.anaPara=Double.toString(anaPara);
    }


    @And("Faiz orani yil\\({double}) ile carpilir")
    public void faizOraniYilIleCarpilir(double yil) {
        baseActions.clcHesapla(faizOran,"*", Double.toString(yil));
        this.clcSonuc=baseActions.clcGetSonuc();
    }

    @And("Sonuc bir ile toplanir")
    public void sonucIleToplanir() {
        baseActions.clcAcButonuTıkla();
        baseActions.clcHesapla(clcSonuc,"+","1");
        this.clcSonuc=baseActions.clcGetSonuc();
    }

    @Then("Sonucun {double} geldigi gorulur")
    public void sonucunToplamGeldigiGorulur(double sayi1) {
        baseActions.testCompareDoubles(Double.parseDouble(clcSonuc),sayi1);
    }

    @And("Sonuc yatirim tutari ile carpilir")
    public void sonucYatirimTutariIleCarpilir() {
        baseActions.clcAcButonuTıkla();
        baseActions.clcHesapla(anaPara,"*",clcSonuc);
    }


}
//taskkill /F /IM chromedriver.exe /T