package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webDriverManager.WebDriverManager;

public class AtoZ_Page {
	
		
	public AtoZ_Page(WebDriver driver) {
		
	PageFactory.initElements(WebDriverManager.getDriver(), this);

	}
	
	@FindBy(xpath = "//a[text()=\"B\"]")
	private WebElement pageMainLink;
	
	@FindBy(xpath = "//div[@id='maincontent']/div/div[2]/a")
	private List<WebElement> pages;
	   
	
	@FindBy(xpath = "//div[@class='rcc_recipecard']")
	private List<WebElement> recipeIDs;
	
	
	@FindBy(xpath = "//table/tbody/tr/td/a")
	private List<WebElement> azLinks;
	
	@FindBy(xpath = "//div[2]/a[contains(@href,'RecipeAtoZ.aspx?')]")
	private List<WebElement> azPage;
	
		
//creating getter methods to access private web elements outside the method

//Get RecipeIDs
	
	public WebElement getMainPageLink() {
		return pageMainLink;
	}
	
	public List<WebElement> getrecipeIDs() {
	return recipeIDs;
	}
	
	public List<WebElement> getazLinks() {
		return azLinks;
		}
	public List<WebElement> getazPage() {
		return azPage;
		}
	
	public List<WebElement> getPages() {
		return pages;
		
	}
	

}

