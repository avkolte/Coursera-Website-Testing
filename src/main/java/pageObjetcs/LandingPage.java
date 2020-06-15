
package pageObjetcs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	 public WebDriver driver;

	String searchbox="//input[@placeholder='What do you want to learn?']";
	String searchbtn="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']";
	String signUpButton="//a[contains(text(),'Join for Free')]";
	
	 //public Properties prop;
	 Properties prop= new Properties();
	 FileInputStream fis;

	 
	public LandingPage(WebDriver driver) 
		{	
			this.driver=driver;	
		}

	
	public WebElement getSearchBox() throws IOException
	{
		
		return driver.findElement(By.xpath(searchbox));
	}
	
	public WebElement getSearchBtn() throws IOException
	{
		
		return driver.findElement(By.xpath(searchbtn));
	}
	
	
	

}
