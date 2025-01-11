package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


public class Hooks {

        // Holds the WebDriver instance
        public static WebDriver webDriver;

        // Initialize a webDriver instance of required browser
        // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver


        @BeforeAll
        public static void initializeDriver(){
            System.out.println("before calisti");
            //WebDriverManager.chromedriver().setup();
            //webDriver =new ChromeDriver();
            webDriver = DriverFactory.getDriver();
            //webDriver.manage().window().maximize();
            webDriver.get("https://catchylabs-webclient.testinium.com/");
        }


        @BeforeStep
        public void BeforeStep(){System.out.println("beforestep calisti");}

        // Close the webDriver instance
        //@After
        public void closeDriver(){
            webDriver.quit();
        }

    }
