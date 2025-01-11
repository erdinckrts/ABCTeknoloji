package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

        import java.io.IOException;


public class CalculatorPage extends BasePage {

    public CalculatorPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public static By getCalculatorDigit(String digit) {
        return By.xpath("//div[text()='" + digit + "']");
    }
    public static By getLabelBox() {
        return locatorFactory.getLocator("calculatorPage", "labelBox");
    }


}