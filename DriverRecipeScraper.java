package driverScraping;

import hooksScraping.HooksScraping;
import pageObject.AtoZ_Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import analyzer.MyRetryAnalyzer;

public class DriverRecipeScraper extends HooksScraping {
	 AtoZ_Page atozpage;
   @Test(retryAnalyzer = MyRetryAnalyzer.class)     
   public void RecipeScraping() {
        WebDriver driver = getDriver();
        AtoZ_Page atozpage=new AtoZ_Page(driver);
       

        // Your test code here
        //String expectedTitle = "Expected Title";
        String actualTitle = driver.getTitle();
        String url=driver.getCurrentUrl();
        System.out.println(" Actual Title is: " +actualTitle);
        System.out.println(" URL is: " +url);
        System.out.println("Resulting Page Title: " +driver.getTitle());
        atozpage.getMainPageLink().click();
        System.out.println("Resulting Page Title: " +driver.getTitle());
        int pagecount=atozpage.getPages().size();
        for(int p=1;p<=pagecount;p++)
      {
        WebElement activePageLink = driver.findElement(By.xpath("//div[@style='text-align:right;padding-bottom:15px;'][1]/a[text()='" + p + "']"));
        activePageLink.click();
        System.out.println("Resulting Page Title: " +driver.getTitle());
      }
      
//        for (Integer link : azLinks) {
//			String href = link.getAttribute("href");
//			if (link.getTextContent().equalsIgnoreCase("A"))
        
          }


}