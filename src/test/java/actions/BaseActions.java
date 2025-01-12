package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class BaseActions {

    protected WebDriver driver;

    public BaseActions(WebDriver driver) throws IOException {
        this.driver = driver;
    }
    public String getElementText(By locator){
        if (isElementPresent(locator)) {
            driver.findElement(locator).click();
        } else {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
      return driver.findElement(locator).getText();
    }
    public void click(By locator) {
        if (isElementPresent(locator)) {
            driver.findElement(locator).click();
        } else {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }

    public void write(By locator, String text) {
        if (isElementPresent(locator)) {
            WebElement element = driver.findElement(locator);
            element.clear(); // Clear any existing text before entering new text
            element.sendKeys(text);
        } else {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }

    public void clear(By locator) {
        if (isElementPresent(locator)) {
            WebElement element = driver.findElement(locator);
            element.clear();
        } else {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }
    // Check if an element is present and visible on the page
    private boolean isElementPresent(By locator) {
        try {
            elementWaiter(locator);
            WebElement element = driver.findElement(locator);
            return element.isDisplayed(); // Return true if element is found and visible
        } catch (NoSuchElementException e) {
            return false; // Return false if element is not found
        }
    }

    private void elementWaiter(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (NoSuchElementException e) {
        }
    }
    public void clickElementIfPresent(By locator) {
        if (isElementPresent(locator)) {  // Eğer eleman varsa
            click(locator);
        } else {
            // Eğer eleman yoksa, hata verilmez ve işlem devam eder
        }
    }


    /////////////////////////////////////////////////////Assertions//////////////////////////
    public void testCompareDoubles(double actualResult, double expectedResult) {
        Assert.assertEquals(actualResult,expectedResult,"HATA! sayilar esit degildir");
    }


}
