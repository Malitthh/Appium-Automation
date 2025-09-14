package com.appium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void loadProperties() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/resources/config.properties");
        prop.load(fis);
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}

