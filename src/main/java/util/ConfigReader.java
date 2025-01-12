package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // properties dosyasını başlatan metod
    public static Properties initialize_Properties() {
        properties = new Properties();
        try {
            // config.properties dosyasını okuma
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    // properties üzerinden değer okuma
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Integer değer döndürmek için
    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}
