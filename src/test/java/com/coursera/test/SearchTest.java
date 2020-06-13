
package com.coursera.test;

import java.io.IOException;
import java.security.Key;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjetcs.LandingPage;
import resources.Driver;
import resources.readExcel;
import resources.ScreenShot;


public class SearchTest {

	public WebDriver driver;
	//Open Broswer with coursera website
	@BeforeTest
	public void createDriver() throws IOException
	{
		Driver obj = new Driver();
		driver=obj.initializeDriver();
	}
	//Test function for correct search
	@Test
	public void rightSearch() throws IOException, InterruptedException
	{
		LandingPage l = new LandingPage(driver);
		readExcel e = new readExcel();
		String input=e.getexcel(0,0);
		l.getSearchBox().sendKeys(input);
		l.getSearchBtn().click();
		Thread.sleep(10000);
		ScreenShot s = new ScreenShot();
		s.screenShotCapture(driver);
	
	}
	//Test function for wrong search by entering wrong keywords
	@Test
	public void wrongSearch() throws IOException, InterruptedException
	{
		LandingPage l = new LandingPage(driver);
		readExcel e = new readExcel();
		String input=e.getexcel(1,0);
		l.getSearchBox().sendKeys(Keys.CONTROL+"a");
		l.getSearchBox().sendKeys(Keys.DELETE);
		l.getSearchBox().sendKeys(input);
		l.getSearchBtn().click();
		Thread.sleep(10000);
		ScreenShot s = new ScreenShot();
		s.screenShotCapture(driver);
	
	}
	//Test function for empty search i.e. nothing is passs as keywords
	@Test
	public void emptySearch() throws IOException, InterruptedException
	{
		LandingPage l = new LandingPage(driver);
		l.getSearchBox().sendKeys(Keys.CONTROL+"a");
		l.getSearchBox().sendKeys(Keys.DELETE);
		l.getSearchBtn().click();
		Thread.sleep(10000);
		ScreenShot s = new ScreenShot();
		s.screenShotCapture(driver);
	
	}
	//close browser
@AfterClass
	public void closeDriver()
	{
		driver.close();
		driver=null;
	}
}
