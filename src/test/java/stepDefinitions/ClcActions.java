package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ClcActions extends BaseActions{
    protected WebDriver driver;

    public ClcActions(WebDriver driver) throws IOException {
        super(driver);
    }

    ////////////////////////////////////////////////////Hesaap Makinesi//////////////////////
    public void clcIslemGir(String islem) { // -,+,*,/ işaretleri girilir
        click(By.xpath("//div[text()='" + islem + "']"));
    }
    public void clcAcButonuTıkla() {
        click(By.xpath("//div[text()='AC']"));
    }

    public void clcSayiGir(String sayi) {
        for (int i = 0; i < sayi.length(); i++) {
            char digit = sayi.charAt(i);
            if (digit == '.') {
                driver.findElement(By.xpath("//div[text()=',']")).click();
            } else {
                driver.findElement(By.xpath("//div[text()='" + digit + "']")).click();
            }
        }
    }

    public void clcHesapla(String sayi1, String islem, String sayi2) {
        clcSayiGir(sayi1);
        clcIslemGir(islem);
        clcSayiGir(sayi2);
        click(By.xpath("//div[text()='=']"));
        driver.findElement(By.xpath("//div[text()='=']")).click();
    }

}
