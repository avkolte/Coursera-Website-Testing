package com.coursera.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjetcs.LandingPage;
import resources.Driver;
import resources.readExcel;

public class FilterTest {
public WebDriver driver;
	
    /*************** To open website *********************/
	
	@BeforeTest
	public void createDriver() throws IOException
	{
		Driver obj = new Driver();
        driver=obj.initializeDriver();
    
	}
	
	@Test
	public void runtest() throws Exception {
		
		
		
		/*************** To wait for page load *********************/		
		
		/*************** To searching for web development *********************/
		Thread.sleep(10000);     
		LandingPage l = new LandingPage(driver);
		readExcel e = new readExcel();
		String input=e.getexcel(0,0);
		l.getSearchBox().sendKeys(input);
		l.getSearchBtn().click();
		Thread.sleep(10000);    
		
		
		/*************** For setting Language as English *********************/
	
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div[1]/div/div/div/div/div[1]")).click();
	    WebElement dropdownValue1 = driver.findElement(By.xpath("//*[@id=\"filter_all_languages_checked_button\"]/label/input"));
	    dropdownValue1.click();									 
		Thread.sleep(10000);
		
		
		/*************** For setting Level as Beginner *********************/
	
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).click();
	    WebElement dropdownValue2 = driver.findElement(By.xpath("//*[@id=\"filter_skills_checked_button\"]"));
	    dropdownValue2.click();
		Thread.sleep(10000);
		
		
		/*************** For setting Learning product as Course *********************/
	
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/div/div/div[5]/div/div/div/div/div[1]")).click();
	    WebElement dropdownValue3 = driver.findElement(By.xpath("//*[@id=\"filter_partners_checked_button\"]/label/input"));
	    dropdownValue3.click();
		
		Thread.sleep(10000);
		
	}
	
	@AfterMethod
	public void closedriver(){
		
		/***************** To close browser *******************/
        driver.close();
        driver=null;
	}
}