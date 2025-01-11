package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    // Singleton WebDriver instance
    private static WebDriver driver;

    // Private constructor to prevent instantiation
    private DriverFactory() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getenv("BROWSER");
            browser = (browser == null) ? "CHROME" : browser;

            switch (browser.toUpperCase()) {
                case "IE":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "CHROME":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    // Uncomment if you need headless mode based on environment variable
                    // if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                    //     options.addArguments("--headless");
                    //     options.addArguments("--disable-gpu");
                    // }
                    driver = new ChromeDriver(options);
                    break;
            }
        }
        return driver;
    }

    // Method to close the driver instance
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver instance
        }
    }
}
