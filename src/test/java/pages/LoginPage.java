package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) throws IOException {super(driver);
    }

    public static By getLoginTextBox(){
        return locatorFactory.getLocator("loginPage","usernameTextBox");
    }
    public static By getPasswordTextBox(){
        return locatorFactory.getLocator("loginPage","passwordTextBox");
    }
    public static By getLoginButton(){
        return locatorFactory.getLocator("loginPage","loginButton");
    }

}
