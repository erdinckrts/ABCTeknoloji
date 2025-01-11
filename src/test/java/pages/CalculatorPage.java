package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import util.DriverFactory;

        import java.io.IOException;
        import java.time.Duration;

public class CalculatorPage extends BasePage {

    public CalculatorPage(WebDriver driver) throws IOException {
        super(driver);
    }
    static WebDriver driver = DriverFactory.getDriver();

    public By getCalculatorDigit(String digit) {
        return By.xpath("//div[text()='" + digit + "']");
    }
    public By getLabelBox() {
        return locatorFactory.getLocator("calculatorPage", "labelBox");
    }


    public By getSifirButton() {
        return locatorFactory.getLocator("calculatorPage", "sifirButton");
    }

    public By getBirButton() {
        return locatorFactory.getLocator("calculatorPage", "birButton");
    }

    public By getIkiButton() {
        return locatorFactory.getLocator("calculatorPage", "ikiButton");
    }

    public By getUcButton() {
        return locatorFactory.getLocator("calculatorPage", "ucButton");
    }

    public By getDortButton() {
        return locatorFactory.getLocator("calculatorPage", "dortButton");
    }

    public By getBesButton() {
        return locatorFactory.getLocator("calculatorPage", "besButton");
    }

    public By getAltiButton() {
        return locatorFactory.getLocator("calculatorPage", "altıButton");
    }

    public By getYediButton() {
        return locatorFactory.getLocator("calculatorPage", "yediButton");
    }

    public By getSekizButton() {
        return locatorFactory.getLocator("calculatorPage", "sekizButton");
    }

    public By getDokuzButton() {
        return locatorFactory.getLocator("calculatorPage", "dokuzButton");
    }

    public By getVirgulButton() {
        return locatorFactory.getLocator("calculatorPage", "virgulButton");
    }

    public By getArtiButton() {
        return locatorFactory.getLocator("calculatorPage", "artıButton");
    }

    public By getEksiButton() {
        return locatorFactory.getLocator("calculatorPage", "eksiButton");
    }

    public By getCarpiButton() {
        return locatorFactory.getLocator("calculatorPage", "carpiButton");
    }

    public By getBoluButton() {
        return locatorFactory.getLocator("calculatorPage", "boluButton");
    }

    public By getEsittirButton() {
        return locatorFactory.getLocator("calculatorPage", "esittirButton");
    }


}