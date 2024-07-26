package hooksScraping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import pageObject.AtoZ_Page;
import utilities.ConfigReaderScraping;
import utilities.LoggerLoad;
import webDriverManager.WebDriverManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HooksScraping {

	
	 private WebDriver driver;
	 private AtoZ_Page atozpage;

    @BeforeClass
    public void setUp() {
        ConfigReaderScraping config = new ConfigReaderScraping();
        String browser = config.getBrowser();
        String applicationUrl = config.getApplicationUrl();
        driver = WebDriverManager.initializeDriver(browser);
        LoggerLoad.info("Opening application URL: " + applicationUrl);
        driver.get(applicationUrl);
        driver.manage().window().maximize();   
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (driver != null && ITestResult.FAILURE == result.getStatus()) {
            LoggerLoad.info("Taking screenshot for a failed scenario: " + result.getName());

            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            Path path = Paths.get("./screenshots/" + result.getName() + ".png");
            try {
                Files.createDirectories(path.getParent());
                Files.write(path, screenshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            LoggerLoad.info("Quitting the browser");
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}