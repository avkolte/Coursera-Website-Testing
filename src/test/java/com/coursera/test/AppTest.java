package com.coursera.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Driver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
   public WebDriver driver;
    @Test
    public void shouldAnswerWithTrue() throws IOException
    {
        Driver driver = new Driver();
        driver.initializeDriver();
        
    	assert( true );
    }
}
