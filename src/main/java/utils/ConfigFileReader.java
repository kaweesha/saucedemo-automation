package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader(){
        BufferedReader reader;
        String propertyFilePath = System.getProperty("user.dir") + "//src//main//resources//system.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            this.properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("system.properties not found at " + propertyFilePath);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
