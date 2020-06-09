
package pageObjetcs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	 public WebDriver driver;
	
	 //public Properties prop;
	 Properties prop= new Properties();
	 FileInputStream fis;

	 public void readData() throws IOException
	 {
		fis=new FileInputStream("/home/avkolte/eclipse-workspace/coursera-testing/src/main/java/resources/config.properties");

			prop.load(fis);
	 }
	 
	public LandingPage(WebDriver driver) {

			
			this.driver=driver;
			
		}
	 
	
	public WebElement getLogin1() throws IOException 
	{
		
		readData();
		String loginbtn1=prop.getProperty("loginbtn1");
		
		return driver.findElement(By.xpath(loginbtn1));
	}
	
	public WebElement getEmail() throws IOException
	{
		readData();
		String email=prop.getProperty("email");
		return driver.findElement(By.xpath(email));
	}
	
	public WebElement getPassword() throws IOException
	{
		readData();
		String password=prop.getProperty("password");
		return driver.findElement(By.xpath(password));
	}
	
	public WebElement getLogin2() throws IOException 
	{
		
		readData();
		String loginbtn2=prop.getProperty("loginbtn2");
		
		return driver.findElement(By.xpath(loginbtn2));
	}
	
	
	public WebElement getSearchBox() throws IOException
	{
		readData();
		String searchbox=prop.getProperty("searchbox");
		
		return driver.findElement(By.xpath(searchbox));
	}
	
	public WebElement getSearchBtn() throws IOException
	{
		readData();
		String searchbtn=prop.getProperty("searchbtn");
		
		return driver.findElement(By.xpath(searchbtn));
	}
	
	
	

}
