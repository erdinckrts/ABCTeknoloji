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
import util.ConfigReader;
import util.DriverFactory;


import java.io.IOException;
import java.net.URISyntaxException;


public class HesapMakinesiModuluStepDefinitions {
    static WebDriver driver = DriverFactory.getterDriver();
    static String catchylabsUsername = ConfigReader.initialize_Properties().getProperty("catchylabsUsername");
    static String catchylabsPassword = ConfigReader.initialize_Properties().getProperty("catchylabsPassword");


    BaseActions baseActions = new BaseActions(driver);
    CalcActions calcActions = new CalcActions(driver);

    String faizOran;
    String anaPara;
    String clcSonuc;

    String gelir;
    String gider;
    String tasarruf;

    public HesapMakinesiModuluStepDefinitions() throws IOException, URISyntaxException {
    }

    @Given("Calculator Sayfasi Acilir")
    public void catchylabsWebclientSitesineLoginOlunur() {
        //baseActions.clickElementIfPresent(CalculatorPage.getBackButton());
        //baseActions.clickElementIfPresent(StagePage.getLogoutButton());

        baseActions.write(LoginPage.getLoginTextBox(),catchylabsUsername);
        baseActions.write(LoginPage.getPasswordTextBox(),catchylabsPassword);
        baseActions.click(LoginPage.getLoginButton());
        baseActions.click(StagePage.getOpenCalculatorButton());
    }
    @Given("Open Calculator butonuna tiklanir")
    public void openCalculatorButonunaTiklanir() {
        baseActions.click(StagePage.getOpenCalculatorButton());
    }

    @Given("Yatirim tutari {double} ve faiz orani yuzde {double} olarak verilir")
    public void yatirimTutariVeFaizOraniYuzdeOlarakVerilir(double anaPara, double oran) {
        this.faizOran=Double.toString(oran/(double) 100);
        this.anaPara=calcActions.doubleToString(anaPara);
    }

    @And("Faiz orani yil\\({double}) ile carpilir")
    public void faizOraniYilIleCarpilir(double yil) {
        calcActions.clcHesapla(faizOran,"*", calcActions.doubleToString(yil));
        this.clcSonuc=calcActions.clcGetSonuc();
    }

    @And("Sonuc bir ile toplanir")
    public void sonucIleToplanir() {
        calcActions.clcAcButonuTıkla();
        calcActions.clcHesapla(clcSonuc,"+","1");
        this.clcSonuc=calcActions.clcGetSonuc();
    }

    @And("Sonuc yatirim tutari ile carpilir")
    public void sonucYatirimTutariIleCarpilir() {
        calcActions.clcAcButonuTıkla();
        calcActions.clcHesapla(anaPara,"*",clcSonuc);
    }
    @Then("Sonucun {double} TL geldigi gorulur")
    public void sonucunToplamGeldigiGorulur(double sayi1) {
        baseActions.testCompareDoubles(Double.parseDouble(clcSonuc),sayi1);
    }



    @Given("Kullanici {double} TL gelir ve {double} TL gider girisi yapar")
    public void kullaniciGelirTLGelirVeGiderTLGiderGirisiYapar(double gelir, double gider) {
        System.out.println("gelir degeri : "+ gelir);
        this.gelir=calcActions.doubleToString(gelir);
        this.gider=calcActions.doubleToString(gider);
    }

    @And("Gelir degerinden gider degeri cikarilir")
    public void gelirDegerindenGiderDegeriCikarilir() {
        calcActions.clcHesapla(gelir,"-",gider);
    }

    @Then("Sonuc {double} degerine esit olmalidir")
    public void sonucTasarrufDegerineEsitOlmalidir(double tasarruf) {
        baseActions.testCompareDoubles(Double.parseDouble(clcSonuc),tasarruf);
        calcActions.clcGetSonuc();
    }
}
//taskkill /F /IM chromedriver.exe /T