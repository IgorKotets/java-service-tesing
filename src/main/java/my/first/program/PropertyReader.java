package my.first.program;

import java.nio.file.Files;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

public class PropertyReader {

    private static Properties properties = loadProperties();

    private static Properties loadProperties() {

        Properties properties = new Properties();

        try{
            properties.load(Files.newInputStream(new File("config.properties").toPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }

    public static String getProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }


}