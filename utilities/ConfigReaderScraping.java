package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderScraping {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/config/config.properties"; // Path to your config file

    public ConfigReaderScraping() {
        try (FileInputStream fis = new FileInputStream(propertyFilePath)) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Configuration file not found at " + propertyFilePath, e);
        }
    }

    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) {
            return browser;
        } else {
            throw new RuntimeException("browser not specified in the config.properties file");
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("applicationUrl");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("applicationUrl not specified in the config.properties file");
        }
    }
}