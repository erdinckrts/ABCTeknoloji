package stepDefinitions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.time.Duration;

public class BaseActions {
    protected static AppiumDriver driver;
    protected WebDriverWait wait;


    public BaseActions(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Varsayılan 10 saniye bekleme süresi
    }

    //By tipinden Web Elemente Çevirme
    public static WebElement convertToElementFromBy(By ByElement) {
        return driver.findElement(ByElement);
    }

    public void waitForElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //By ile elemente tıklama
    public void clickElement(By ByElement) {
        clickElement(convertToElementFromBy(ByElement));
    }

     //Belirtilen elemente tıklar.
    public void clickElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (NoSuchElementException e) {System.out.println("Element bulunamadı: " + e.getMessage());}
    }

    public void sendKeysToElement(By ByElement, String text) {
        WebElement Element = convertToElementFromBy(ByElement);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(Element));
            Element.clear();
            Element.sendKeys(text);
        } catch (NoSuchElementException e) {System.out.println("Element bulunamadı: " + e.getMessage());
        }
    }

    // Element listesinden rastgele element bulma
    public WebElement findRandomElementWithBy(By ByElementList) {
        List<WebElement> ElementList = driver.findElements(ByElementList);
        if (ElementList != null && !ElementList.isEmpty()) { // Liste boş değilse
            Random random = new Random();
            int randomIndex = random.nextInt(ElementList.size()); // Rastgele bir indeks al
            WebElement returnElement = ElementList.get(randomIndex); // Rastgele butonu al
            return returnElement; // Tıklanan butonu döndür
        } else {
            System.out.println("Hic element bulunamadi."); // Buton yoksa mesaj ver
            return null; // Buton yoksa null döndür
        }
    }

    public WebElement clickRandomElementFromListWithBy(By ByElementList){
        findRandomElementWithBy(ByElementList).click();
        return findRandomElementWithBy(ByElementList);
    }

    //verilen elementin verilen listedeki yerini bulma
    public int getElementIndexFromList(List<WebElement> ElementList, By targetByElement) {
        WebElement targetElement=driver.findElement(targetByElement);
        for (int i = 0; i < ElementList.size(); i++) {
            if (ElementList.get(i).equals(targetElement)) {
                return (i+1); //
            }
        }
        return -1; // Element bulunamazsa -1 döndür
    }

    //verilen elementin verilen listedeki yerini bulma
    public int getElementIndexFromList(List<WebElement> ElementList, WebElement targetElement) {
        for (int i = 0; i < ElementList.size(); i++) {
            if (ElementList.get(i).equals(targetElement)) {
                return (i+1); //
            }
        }
        return -1; // Element bulunamazsa -1 döndür
    }


    // istenilen bir String değeri verilen boyutlu dizide arama
    public int getStringIndexFromList(String searchVaue, String[][] twoDimentionalist) {
        System.out.println("buton uzunlugu "+twoDimentionalist.length);
        //buttonData = getAlertTextAndIndex(); // Dizi verilerini al
        boolean found = false;
        // İki boyutlu dizinin her bir elemanını kontrol et
        for (int i = 0; i < twoDimentionalist.length; i++) {
            if (twoDimentionalist[i][1].equalsIgnoreCase(searchVaue)) {
                System.out.println("Bulundu: \"" + searchVaue + "\" - index: " + (i+1) );
                found = true;
                return (i+1);
            }
        }
        if (!found) {
            System.out.println("Değer bulunamadı: \"" + searchVaue + "\"");
        }
        return 0;
    }
    //By tipinden Element Listesi oluşturma
    public List<WebElement> ByToElementList(By ByElement){
       return driver.findElements(ByElement);
    }

    /**
     * Ekranı yukarı kaydırır.
     */
    public void scrollUp() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.8);
        int endY = (int) (driver.manage().window().getSize().height * 0.2);

            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(Arrays.asList(swipe));
    }


    //verilen elementin hizasından istelilen By elementi bulana kadar sağa kaydırma
    public void swipeTabsUntilVisible(WebElement scrollBar, By byelement, AndroidDriver driver) {
        WebElement  element1=driver.findElement(byelement);
        int width = driver.manage().window().getSize().width; // Ekranın genişliği
        int height = driver.manage().window().getSize().height; // Ekranın yüksekliği
        int startX = (int) (width * 0.8); // Başlangıç X koordinatı (sağ)
        int endX = (int) (width * 0.2); // Bitiş X koordinatı (sol)
        int startY = scrollBar.getLocation().getY(); // Kaydırma işlemi için Y koordinatı
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        while (!"TAB 30".equals(element1.getText())) { // Element görünene kadar döngü
            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)); // Başlangıç noktasına git
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i aşağı indir
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, startY)); // Sola kaydır
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i kaldır
            driver.perform(Arrays.asList(swipe)); // Sürükleme işlemini gerçekleştir
            element1=driver.findElement(byelement) ;
            try {
                Thread.sleep(500); // Her kaydırma sonrası yarım saniye bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //verilen elementin hizasından istelilen By elementi bulana kadar aşağı kaydırma denemesi
    public void swipeDownsUntilVisible(By ByTargetElement, AndroidDriver driver) {
        WebElement  element1=convertToElementFromBy(ByTargetElement);
        int width = driver.manage().window().getSize().width; // Ekranın genişliği
        int height = driver.manage().window().getSize().height; // Ekranın yüksekliği
        int startX = (int) (width * 0.5); // Başlangıç X koordinatı (sağ)
        int endX = (int) (width * 0.5); // Bitiş X koordinatı (sol)
        int startY = (int) (width * 0.99); // Kaydırma işlemi için Y koordinatı
        int endY = (int) (width * 0.001);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        while (!"Tabs".equals(element1.getText())) { // Element görünene kadar döngü
            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)); // Başlangıç noktasına git
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i aşağı indir
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i kaldır
            driver.perform(Arrays.asList(swipe)); // Sürükleme işlemini gerçekleştir
            element1=driver.findElement(ByTargetElement) ;
            try {
                Thread.sleep(500); // Her kaydırma sonrası yarım saniye bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //Uzun tıklama
    public void longPress(AndroidDriver driver, By Byelement){
        WebElement element=driver.findElement(Byelement);
        Point location=element.getLocation();
        Dimension size=element.getSize();

        PointerInput finger1 =new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence = new Sequence(finger1,1);
        sequence.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), location.x, location.y));
        sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger1, Duration.ofSeconds(2)));
        sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    /**
     * Ekranı aşağı kaydırır.
     */
    public void scrollDown() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.2);
        int endY = (int) (driver.manage().window().getSize().height * 0.8);

        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
    // Tab'ları sağdan sola sürükle

    /**
     * Elementin görünür olup olmadığını kontrol eder.
     * @param element WebElement - Görünürlüğü kontrol edilecek element
     * @return boolean - true: görünür, false: görünmez
     */
    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
            return false;
        }
    }


    /**
     * Belirtilen element görünür hale gelene kadar bekler.
     * @param by By - Görünür hale gelmesi beklenen element
     */



    /**
     * Beklenen sonuç ile gerçek sonucu karşılaştırır.
     * @param actual String - Gerçek sonuç
     * @param expected String - Beklenen sonuç
     */
    public void verifyText(String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("Doğrulama başarılı: Beklenen = " + expected + ", Gerçek = " + actual);
        } else {
            System.out.println("Doğrulama başarısız: Beklenen = " + expected + ", Gerçek = " + actual);
        }
    }


    // By Ekranı kaydırıp elemana tıklayan metod
    public void scrollToElementAndClick(By by) {
        try {
            // Elemanı UiScrollable ile kaydırarak görünür hale getirme
            WebElement element = (WebElement) driver.findElement(
                    new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().resourceId(\"" + by.toString() + "\"));"));
            // Elemana tıklama işlemi
            element.click();
        } catch (Exception e) {
            System.out.println("Elemente ulaşılamadı veya tıklanamadı: " + e.getMessage());
        }
    }

    // By ile tanımlı elementi bulana kadar kaydırma ve tıklama
    public void sscrollToElementAndClick(By by) {
        boolean isElementFound = false;
        int maxScrollAttempts = 10; // Maksimum kaydırma deneme sayısı
        int scrollAttempts = 0;

        while (!isElementFound && scrollAttempts > maxScrollAttempts) {
            try {
                // By.id ile elementi bulmayı dene
                WebElement element = driver.findElement(by);
                element.click(); // Element bulunduğunda tıkla
                isElementFound = true; // Element bulunduğunda döngüyü sonlandır
            } catch (NoSuchElementException e) {
                // Element yoksa aşağı kaydırma işlemi yap
                scrollAttempts--;
                //scrollDown();
            }
        }
        if (!isElementFound) {
            System.out.println("Element bulunamadı.");
        }
    }


    //bildirim izni verme
    public void allowtoAlert(){
        try {
            // Alert varsa geçiş yapıp kabul et
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert mesajı kabul edildi.");
        } catch (NoAlertPresentException e) {
            // Alert yoksa devam et
            System.out.println("Alert mesajı bulunamadı, devam ediliyor.");
        }
    }
}
