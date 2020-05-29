
package com.coursera.test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjetcs.LandingPage;
import resources.Driver;

public class SearchTest {

	public WebDriver driver;
	
	@BeforeClass
	public void createDriver() throws IOException
	{
		Driver obj = new Driver();
		driver=obj.initializeDriver();
	}
	
	@Test
	public void search() throws IOException, InterruptedException
	{
		LandingPage l = new LandingPage(driver);
		//l.getLogin1().click();
		//l.getEmail().sendKeys("");
		//l.getPassword().sendKeys("");
		//l.getLogin2().click();
		l.getSearchBox().sendKeys("Computer Science");
		l.getSearchBtn().click();
		Thread.sleep(10000);

	}
	
@AfterClass
	public void closeDriver()
	{
		driver.close();
		driver=null;
	}
}
