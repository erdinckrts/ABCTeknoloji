package testRunners;

import io.appium.java_client.AppiumDriver;
import util.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "util"},
        tags = "",//parallel.xml içinde tanımlıyorum
        plugin = {
                "summary", "pretty", "html:Reports/CucumberReport/Reports.html",
        }
)

public class runner extends AbstractTestNGCucumberTests {
        // TestNG parametrelerini alıyoruz
        /*@BeforeClass
        @Parameters("browser")
        public void setup(String browser) {
                // Parametreyi sistem özelliği olarak ayarlıyoruz
                System.out.println("Parametre Before class : "+browser);

                System.setProperty("browser", browser);
        }

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }*/
}