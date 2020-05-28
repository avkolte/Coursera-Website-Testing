package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Driver {

	public static WebDriver driver;
	public Properties prop;

public WebDriver initializeDriver() throws IOException
{
	
 prop= new Properties();
FileInputStream fis=new FileInputStream("/home/avkolte/eclipse-workspace/coursera-testing/src/main/java/resources/data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", "/home/avkolte/eclipse-workspace/coursera-testing/drivers/chromedriver");
	driver= new ChromeDriver();
		
	System.out.println("Driver Initalizeed...");
	driver.get(prop.getProperty("url"));
	
}
else if (browserName.equals("firefox"))
{
	
	 System.setProperty("webdriver.gecko.driver", "/home/avkolte/eclipse-workspace/coursera-testing/drivers/geckodriver");
;
	 driver= new FirefoxDriver();
	 driver.get(prop.getProperty("url"));
	
}

else if(browserName.equals("opera"))
{
	 System.setProperty("webdriver.chrome.driver", "/home/avkolte/eclipse-workspace/coursera-testing/drivers/operadriver");
	driver= new OperaDriver();
		
	System.out.println("Driver Initalizeed...");
	driver.get(prop.getProperty("url"));
	
}


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;


}



}