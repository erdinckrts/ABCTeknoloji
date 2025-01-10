package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


    public class Hooks {

        // Holds the WebDriver instance
        public static WebDriver webDriver;

        // Initialize a webDriver instance of required browser
        // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
        @Before
        public void initializeDriver(){
            webDriver = DriverFactory.getDriver();
        }

        // Close the webDriver instance
        @After
        public void closeDriver(){
            webDriver.quit();
        }

    }
