package com.coursera.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import resources.Driver;

import com.beust.jcommander.Parameter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
 
public class SignUpTest{
   

    boolean status = false;
    public WebDriver driver;

     //Opening browser with the given URL and navigate to Registration Page

    @BeforeTest
	public void createDriver() throws IOException
	{
		Driver obj = new Driver();
        driver=obj.initializeDriver();
        WebElement signUpButton = driver.findElement(By.xpath("//a[contains(text(),'Join for Free')]"));
        signUpButton.click();
	}
   /*
    //Verifying Privacy policy page redirection
    @Test
    public void privacyPolicyRedirectionTest()
    {
    WebElement privacyPolicyLink = driver.findElement(By.xpath("//a[contains(text(),'Privacy')]"));
    privacyPolicyLink.click();
   
    Set <String> allWindows = driver.getWindowHandles();
   
    for(String handle : allWindows)
    {
    driver.switchTo().window(handle);
    }            
     
    String expectedURL = "https://www.coursera.org/about/privacy";
    String actualURL = driver.getCurrentUrl();
    //System.out.println(actualURL);
    Assert.assertEquals(actualURL, expectedURL);
   
    String expectedTitle = "Privacy Policy";
    String actualTitle = driver.getTitle();
    //System.out.println(actualTitle);
    Assert.assertEquals(actualTitle, expectedTitle);
    }    
   */

  
    // Registration without providing Name field
    @Test
    public void emptyNameTest()
    {
         
        //WebElement fullName = driver.findElement(By.name("name"));
        //fullName.sendKeys("");
         
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@test.com");
                 
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("Test@123");
       
         
        WebElement signUp = driver.findElement(By.xpath("/html/body/div[3]/div/div/span/div[3]/div/div/div[3]/div/div/div/div[3]/div[1]/div[1]/form/div/button/span"));
        signUp.click();
       
        String expectedErrorMsg = "Please enter a name";
       
        String actualErrorMsg = driver.findElement(By.name("name")).getAttribute("validationMessage");

       
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
       
    }
   
    // Registration without providing user email field
    @Test
    public void emptyEmailTest()
    {
         
        WebElement fullName = driver.findElement(By.name("name"));
        fullName.sendKeys("test");
         
        
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(Keys.CONTROL+"a");
        email.sendKeys(Keys.DELETE);
        email.sendKeys("");
                 
        WebElement password = driver.findElement(By.name("password"));
       // password.sendKeys(Keys.CONTROL+"a");
        //password.sendKeys(Keys.DELETE);
        password.sendKeys("Test@123");
         
         
        WebElement signUp = driver.findElement(By.xpath("/html/body/div[3]/div/div/span/div[3]/div/div/div[3]/div/div/div/div[3]/div[1]/div[1]/form/div/button/span"));
        signUp.click();
       
        String expectedErrorMsg = "Please enter an email address";
       
        String actualErrorMsg = driver.findElement(By.name("email")).getAttribute("validationMessage");
       
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
   
   
    // Registration without providing password field
    @Test
    public void emptyPasswordTest()
    {
   
         
       /* WebElement fullName = driver.findElement(By.name("name"));
        fullName.sendKeys("TestName");*/
         
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@test.com");
                 
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys(Keys.CONTROL+"a");
        password.sendKeys(Keys.DELETE);
        password.sendKeys("");
   
        WebElement signUp = driver.findElement(By.xpath("/html/body/div[3]/div/div/span/div[3]/div/div/div[3]/div/div/div/div[3]/div[1]/div[1]/form/div/button/span"));
        signUp.click();
       
        String expectedErrorMsg = "Please enter a password";
       
        String actualErrorMsg = driver.findElement(By.name("password")).getAttribute("validationMessage");

       
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }
   
      // Registration with all valid data
      @Test
      public void validRegistrationTest(){            
               
               
          //WebElement fullName = driver.findElement(By.name("name"));
          //fullName.sendKeys("TestName");
               
          //WebElement email = driver.findElement(By.name("email"));
          //email.sendKeys("test6.lambdatest@gmail.com");
           
          WebElement password = driver.findElement(By.name("password"));
          password.sendKeys("Test@12345");
   
           WebElement signUp = driver.findElement(By.xpath("/html/body/div[3]/div/div/span/div[3]/div/div/div[3]/div/div/div/div[3]/div[1]/div[1]/form/div/button/span"));
          signUp.click();
      }
 
   
    // Closing the browser session after completing each test case
    @AfterClass
    public void tearDown() throws Exception {
       /*if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("Coursera-status=" + status);
            driver.quit();*/
            driver.close();
            driver=null;
        
    }
}

