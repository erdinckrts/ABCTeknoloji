package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverFactory;
import util.ElementHelper;

import java.io.IOException;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) throws IOException {super(driver);
    }
    static WebDriver driver = DriverFactory.getDriver();


    /*public static WebElement getLoginTextBox(){
        return driver.findElement(By.cssSelector("input[placeholder='Username']"));
    }*/
    public By getLoginTextBox(){
        return locatorFactory.getLocator("loginPage","usernameTextBox");
    }
    public By getPasswordTextBox(){
        return locatorFactory.getLocator("loginPage","passwordTextBox");
    }
    public By getLoginButton(){
        return locatorFactory.getLocator("loginPage","loginButton");
    }

}
