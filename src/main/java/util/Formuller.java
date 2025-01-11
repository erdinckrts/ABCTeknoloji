package util;

public class Formuller {

    public static double yatirimHesaplamasi(double anapara, double faizOrani, int yil) {
        // Faiz hesaplamasını formül üzerinden yapıyoruz
        double sunuc = anapara * (1 + (faizOrani * yil));

        // Sonucu döndürüyoruz
        return sunuc;
    }
}
