package actions;

import org.openqa.selenium.WebDriver;
import pages.CalculatorPage;

import java.io.IOException;

public class CalcActions extends BaseActions {
    protected WebDriver driver;

    public CalcActions(WebDriver driver) throws IOException {
        super(driver);
    }
    ////////////////////////////////////////////////////Hesap Makinesi//////////////////////
    public void clcIslemGir(String islem) { // -,+,*,/ işaretleri girilir
        click(CalculatorPage.getCalculatorDigit(islem));
        //click(By.xpath("//div[text()='" + islem + "']"));
    }
    public void clcAcButonuTıkla() {
        click(CalculatorPage.getCalculatorDigit("AC"));
        //click(By.xpath("//div[text()='AC']"));
    }
    public void clcSayiGir(String sayi) { //verilen string tipindeki sayiyi tek tek hesap makinesine yazar
        for (int i = 0; i < sayi.length(); i++) {
            char digit = sayi.charAt(i);
            if (digit == '.') {
                click(CalculatorPage.getCalculatorDigit(","));
                //click(By.xpath("//div[text()=',']"));
            } else {
                click(CalculatorPage.getCalculatorDigit(Character.toString(digit)));
                //click(By.xpath("//div[text()='" + digit + "']"));
            }
        }
    }
    public void clcHesapla(String sayi1, String islem, String sayi2) {
        clcSayiGir(sayi1);
        clcIslemGir(islem);// (+ - / *)
        clcSayiGir(sayi2);
        click(CalculatorPage.getCalculatorDigit("="));
        //click(By.xpath("//div[text()='=']"));
    }
    public String clcGetSonuc(){//hesap makinesindeki ekrandaki sonucu döndürür
        return (virgulToNokta(getElementText(CalculatorPage.getLabelBox()).split(" ")[1]));
    }

    public String virgulToNokta(String input) {//verilen değerdeki virgülleri noktaya çevirir
        return input.replace(",", ".");
    }

    public String doubleToString(double number) {
        // Sayının tam sayı olup olmadığını kontrol et
        if (number == (long) number) {
            return String.valueOf((int) number);  // Tam sayı ise, integer'a dönüştür
        }
        return Double.toString(number);  // Eğer tam sayı değilse, double olarak döndür
    }

}
