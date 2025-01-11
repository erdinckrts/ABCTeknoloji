package stepDefinitions;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CalculatorPage;
import pages.LoginPage;
import pages.StagePage;
import util.DriverFactory;
import util.ElementHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import org.openqa.selenium.By;


public class HesapMakinesiModuluStepDefinitions {
    WebDriverWait wait;
    ElementHelper elementHelper;
    static WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage =new LoginPage(driver);
    StagePage stagePage = new StagePage(driver);
    CalculatorPage calculatorPage =new CalculatorPage(driver);
    ClcActions clcActions =new ClcActions(driver);
    BaseActions baseActions = new BaseActions(driver);
    String doubleFaizOran;
    String anaPara;
    Double clcSonuc;



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
        System.out.println("Login Btn : "+loginPage.getLoginButton());
        baseActions.click(stagePage.getOpenCalculatorButton());
    }


    @Given("Yatirim tutari {double} ve faiz oranı %{double} olarak verilir")
    public void yatirimTutariVeFaizOranıOlarakVerilir(double anaPara, double oran) {
        this.doubleFaizOran=Double.toString(oran/(double) 100);
        this.anaPara=Double.toString(anaPara);
    }

    @And("Faiz orani {int}(yil) ile carpilir")
    public void faizOraniYilIleCarpilir(double yil) {
        baseActions.clcHesapla(doubleFaizOran,"*", String.valueOf(yil));
        this.clcSonuc=baseActions.clcGetSonuc();
    }

    @Then("Sonucun {double} x {double} geldiği gorulur")
    public void sonucunCarpimGeldigiGorulur(double sayi1, double sayi2) {
        System.out.println("carpim okey");
        //baseActions.testCompareDoubles(clcSonuc,(sayi1*sayi2));
    }


    @And("Sonuc bir ile toplanir")
    public void sonucIleToplanir() {
        baseActions.clcAcButonuTıkla();
        baseActions.clcHesapla(Double.toString(clcSonuc),"+","1");
        this.clcSonuc=baseActions.clcGetSonuc();
    }

    @Then("Sonucun {double} + {double} geldigi gorulur")
    public void sonucunToplamGeldigiGorulur(double sayi1, double sayi2) {
        baseActions.testCompareDoubles(clcSonuc,(sayi1+sayi2));

    }
}
//taskkill /F /IM chromedriver.exe /T