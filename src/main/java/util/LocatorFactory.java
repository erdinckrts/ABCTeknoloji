package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class LocatorFactory {
    private static JsonNode rootNode;
    static AndroidDriver driver;

    public LocatorFactory(AndroidDriver driver) {this.driver = driver;}

    // JSON dosyasını yükler ve kök düğümü alır
    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            rootNode = mapper.readTree(new File("src/test/resources/elements.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Tüm locatörleri sırayla denemek için getLocator metodunu oluşturur
    public static By getLocator(String pageName, String elementName) {
        JsonNode pageNode = rootNode.path(pageName);

        if (!pageNode.isMissingNode()) {
            JsonNode elementArray = pageNode.path(elementName);

            // Eğer locatörler bulunduysa, sırayla dene
            if (elementArray.isArray()) {
                Iterator<JsonNode> elements = elementArray.elements();

                while (elements.hasNext()) {
                    JsonNode elementNode = elements.next();
                    String type = elementNode.path("type").asText();
                    By locator = createBy(type, elementNode);

                    // Locatör geçerli ise, elementi kontrol et
                    if (locator != null && isElementPresent(driver, locator)) {
                        return locator; // Geçerli locatörü bulunca döner
                    }
                }
            }
        }

        // Eğer locatör bulunamazsa hata fırlat
        throw new RuntimeException("Locator not found or not visible for: " + pageName + " -> " + elementName);
    }

    // Locatör tipine göre uygun By nesnesini oluşturur
    private static By createBy(String type, JsonNode elementNode) {
        switch (type) {
            case "xpath":
                return By.xpath(elementNode.path("value").asText());
            case "id":
                return By.id(elementNode.path("value").asText());
            case "attribute":
                String attributeName = elementNode.path("attributeName").asText();
                String attributeValue = elementNode.path("attributeValue").asText();
                return By.xpath(String.format("//*[@%s='%s']", attributeName, attributeValue));
            case "className":
                return By.className(elementNode.path("value").asText());
            case "name":
                return By.name(elementNode.path("value").asText());
            default:
                return null; // Bilinmeyen bir locatör tipi durumunda null döner
        }
    }

    // Elementin sayfada mevcut olup olmadığını kontrol eder
    private static boolean isElementPresent(WebDriver driver, By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed(); // Elementi bulursa ve görünürse true döner
        } catch (NoSuchElementException e) {
            return false; // Element bulunamazsa false döner
        }
    }
}
