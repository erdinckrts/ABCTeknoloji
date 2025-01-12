package util;

import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


public class Hooks {

        // Holds the WebDriver instance
        public static WebDriver webDriver;
        static String url = ConfigReader.initialize_Properties().getProperty("url");
        // Initialize a webDriver instance of required browser
        // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver


        @Before
        public static void initializeDriver(){
            System.out.println("before calisti");
            //WebDriverManager.chromedriver().setup();
            //webDriver =new ChromeDriver();
            //String browser = System.getProperty("browser");
            //System.out.println("Hooks icerisinde Browser Adi : "+browser);
            webDriver = DriverFactory.getDriver("chrome");
            System.out.println("before calisti driver degeri : "+ webDriver);
            //webDriver.manage().window().maximize();
            webDriver.get(url);
        }


        @BeforeStep
        public void BeforeStep(){System.out.println("beforestep calisti");}

        // Close the webDriver instance
        @AfterAll
        public static void quitDriver() {
            /*WebElement closeButton = webDriver.findElement(By.xpath("//button[@class='close' or @aria-label='Close']"));
            closeButton.click();*/
            if (webDriver != null) {
                webDriver.quit();  // Driver oturumunu sonlandırıyoruz
                System.out.println("Driver kapatıldı.");
            }
        }

    }
