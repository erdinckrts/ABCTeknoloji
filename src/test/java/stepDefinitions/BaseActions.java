package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseActions {

    protected WebDriver driver;

    // Constructor to initialize WebDriver
    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    // Click on an element if it is present and visible
    public void click(By locator) {
        if (isElementPresent(locator)) {
            driver.findElement(locator).click();
        } else {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }

    // Write text into an input field if it is present and visible
    public void write(By locator, String text) {
        if (isElementPresent(locator)) {
            WebElement element = driver.findElement(locator);
            element.clear(); // Clear any existing text before entering new text
            element.sendKeys(text);
        } else {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }

    // Hover over an element
    public void hoverOver(By locator) {
        if (isElementPresent(locator)) {
            WebElement element = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } else {
            throw new RuntimeException("Element not found or not visible: " + locator);
        }
    }

    // Check if an element is enabled
    public boolean isElementEnabled(By locator) {
        if (isElementPresent(locator)) {
            return driver.findElement(locator).isEnabled();
        }
        return false; // Return false if element is not present
    }

    // Check if an element is selected (useful for checkboxes or radio buttons)
    public boolean isElementSelected(By locator) {
        if (isElementPresent(locator)) {
            return driver.findElement(locator).isSelected();
        }
        return false; // Return false if element is not present
    }
    // Clear the text from an input field if it is present and visible
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
            WebElement element = driver.findElement(locator);
            return element.isDisplayed(); // Return true if element is found and visible
        } catch (NoSuchElementException e) {
            return false; // Return false if element is not found
        }
    }
}
