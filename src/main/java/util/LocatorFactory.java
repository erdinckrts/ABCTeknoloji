package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

public class LocatorFactory {

    private static JsonNode rootNode;
    static WebDriver driver = DriverFactory.getterDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    // Constructor to initialize WebDriver
    public LocatorFactory(WebDriver driver) {

    }
    // Load JSON file and set root node
    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            rootNode = mapper.readTree(new File("src/test/resources/elements.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the locator based on the page name and element name
    public static By getLocator(String pageName, String elementName) {
        JsonNode pageNode = rootNode.path(pageName);

        if (!pageNode.isMissingNode()) {
            JsonNode elementArray = pageNode.path(elementName);

            // Try each locator type in order
            if (elementArray.isArray()) {
                Iterator<JsonNode> elements = elementArray.elements();

                while (elements.hasNext()) {
                    JsonNode elementNode = elements.next();
                    String type = elementNode.path("type").asText();
                    By locator = createBy(type, elementNode);

                    // If the locator is valid and element is present, return it
                    if (locator != null && isElementPresent(driver, locator)) {
                        return locator; // Return valid locator
                    }

                }
            }

        }

        // If no locator is found, throw an exception
        throw new RuntimeException("Locator not found or not visible for: " + pageName + " -> " + elementName);
    }

    // Create a By object based on the locator type
    private static By createBy(String type, JsonNode elementNode) {
        switch (type) {
            case "id":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementNode.path("value").asText())));
                return By.id(elementNode.path("value").asText());
            case "name":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementNode.path("value").asText())));
                return By.name(elementNode.path("value").asText());
            case "cssSelector":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementNode.path("value").asText())));
                return By.cssSelector(elementNode.path("value").asText());
            case "xpath":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementNode.path("value").asText())));
                return By.xpath(elementNode.path("value").asText());
            case "placeholder":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format("input[placeholder='%s']", elementNode.path("value").asText()))));
                return By.cssSelector(String.format("input[placeholder='%s']", elementNode.path("value").asText()));
            case "className":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(elementNode.path("value").asText())));
                return By.className(elementNode.path("value").asText());
            case "attribute":
                String attributeName = elementNode.path("attributeName").asText();
                String attributeValue = elementNode.path("attributeValue").asText();
                return By.xpath(String.format("//*[@%s='%s']", attributeName, attributeValue));
            case "aria-label":
                return By.xpath(String.format("//*[@aria-label='%s']", elementNode.path("value").asText()));
            default:
                return null; // Return null if the locator type is unknown
        }
    }

    // Check if the element is present on the page
    private static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed(); // Return true if element is found and visible
        } catch (NoSuchElementException e) {
            return false; // Return false if element is not found
        }
    }
}
