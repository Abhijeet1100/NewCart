package TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pom.LandingPage;
import Pom.OrderPage;
 

public class BaseTest {

	public WebDriver driver;
	
	public LandingPage landingPage;
	
	public OrderPage orderPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		//Properties Class
		
		Properties property = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/GlobalData.properties");
		
		property.load(fis);
		
		String browser = property.getProperty("browser");
		
		
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		
         driver = new ChromeDriver();
        
		
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.manage().window().maximize();
		
		return driver;
		
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		
		landingPage = new LandingPage(driver);
		
		landingPage.goTOLandingPage();
		
		return  landingPage;
		
		
	}
	
//	public String orderPageCart()
//	{
//		orderPage = new OrderPage(driver);
//		return orderPage.verifyOrderPresent();
//	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
