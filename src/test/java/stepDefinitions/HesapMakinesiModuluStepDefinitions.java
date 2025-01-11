package stepDefinitions;
import actions.BaseActions;
import actions.CalcActions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import pages.CalculatorPage;
import pages.LoginPage;
import pages.StagePage;
import util.DriverFactory;


import java.io.IOException;
import java.net.URISyntaxException;


public class HesapMakinesiModuluStepDefinitions {
    static WebDriver driver = DriverFactory.getDriver();

    BaseActions baseActions = new BaseActions(driver);
    CalcActions calcActions = new CalcActions(driver);

    String faizOran;
    String anaPara;
    String clcSonuc;

    public HesapMakinesiModuluStepDefinitions() throws IOException, URISyntaxException {
    }

    @Before//("Calculator Sayfasi Acilir")
    public void catchylabsWebclientSitesineLoginOlunur() {
        baseActions.write(LoginPage.getLoginTextBox(),"erdinckrts");
        baseActions.write(LoginPage.getPasswordTextBox(),"123qwe123qweC.");
        baseActions.click(LoginPage.getLoginButton());
        baseActions.click(StagePage.getOpenCalculatorButton());
    }

    @Given("Yatirim tutari {double} ve faiz oranı %{double} olarak verilir")
    public void yatirimTutariVeFaizOranıOlarakVerilir(double anaPara, double oran) {
        this.faizOran=Double.toString(oran/(double) 100);
        this.anaPara=Double.toString(anaPara);
    }

    @And("Faiz orani yil\\({double}) ile carpilir")
    public void faizOraniYilIleCarpilir(double yil) {
        calcActions.clcHesapla(faizOran,"*", Double.toString(yil));
        this.clcSonuc=calcActions.clcGetSonuc();
    }

    @And("Sonuc bir ile toplanir")
    public void sonucIleToplanir() {
        calcActions.clcAcButonuTıkla();
        calcActions.clcHesapla(clcSonuc,"+","1");
        this.clcSonuc=calcActions.clcGetSonuc();
    }

    @Then("Sonucun {double} geldigi gorulur")
    public void sonucunToplamGeldigiGorulur(double sayi1) {
        baseActions.testCompareDoubles(Double.parseDouble(clcSonuc),sayi1);
    }

    @And("Sonuc yatirim tutari ile carpilir")
    public void sonucYatirimTutariIleCarpilir() {
        calcActions.clcAcButonuTıkla();
        calcActions.clcHesapla(anaPara,"*",clcSonuc);
    }

}
//taskkill /F /IM chromedriver.exe /T