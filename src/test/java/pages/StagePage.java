package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import util.DriverFactory;

        import java.io.IOException;
        import java.time.Duration;

public class StagePage extends BasePage {

    public StagePage(WebDriver driver) throws IOException {
        super(driver);
    }

    static WebDriver driver = DriverFactory.getDriver();

    public By getOpenCalculatorButton() {
        return locatorFactory.getLocator("stagePage", "openCalculatorButton");
    }

}
