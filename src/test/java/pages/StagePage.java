package pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

        import java.io.IOException;

public class StagePage extends BasePage {

    public StagePage(WebDriver driver) throws IOException {
        super(driver);
    }

    public static By getOpenCalculatorButton() {
        return locatorFactory.getLocator("stagePage", "openCalculatorButton");
    }
    public static By getLogoutButton() {
        return locatorFactory.getLocator("stagePage", "logoutButton");
    }

}
