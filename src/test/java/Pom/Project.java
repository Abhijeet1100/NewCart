package Pom;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestComponent.BaseTest;


public class Project extends BaseTest{

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		
		
		//abc333@gmail.com --> Qwer1234
		
//        WebDriver driver = new ChromeDriver();
//        
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	//	driver.get("https://rahulshettyacademy.com/client");
		
		//findElement will return--> WebElement object
		
		//By is abstract class and id()--> static method
		
		
		
		
		//landing
		
		
		
//		LandingPage landingPage = new LandingPage(driver);
		
		ProductCatalog catalog = new ProductCatalog(driver);
		
//		driver.findElement(By.id("userEmail")).sendKeys("abc333@gmail.com");
//		
//		driver.findElement(By.id("userPassword")).sendKeys("Qwer1234");
//		
//		driver.findElement(By.id("login")).click();
		
//      LandingPage landingPage = launchApplication();
		
		landingPage.loginApp("abc333@gmail.com", "Qwer1234");
		
		
		//home page
		
	//	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='container'] //b"));
		
		List<WebElement> elements = catalog.getProductList();
		
//		for(WebElement element:elements)
//		{
//			if(element.getText().equalsIgnoreCase("adidas original"))
//			{
//				
//				element.findElement(By.xpath("(//div[@class='d-flex flex-row my-2'])[2] //following-sibling::button[2]")).click();
//				break;
//			}
//			else
//			{
//				continue;
//			}
//		}
		WebElement addToCartProduct =catalog.getProductByName("adidas original");
		addToCartProduct.click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    
	    CartPage cartPage = new CartPage(driver);
	    cartPage.goTOCart();
	    //cart
//	    Thread.sleep(5000);
//	    driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	    
	    //inside cart
	    
//	    WebElement product = driver.findElement(By.xpath("//div[@class='cart'] //div //h3[text()='adidas original']"));
	    
//	    Thread.sleep(5000);
	    
//	    if(product.getText().equalsIgnoreCase("adidas original"))
//	    {
//	    	System.out.println(product.getText());
//	    	driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
//	    }
		
	    //payment page
	    
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
	    
	    Thread.sleep(5000);
	    
	    WebElement drop = driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']"));
	    
	    List<WebElement> countries = drop.findElements(By.xpath("//button //span"));
	    System.out.println(countries.size());
	    	//System.out.println(country.getSize());
            int i=1;
            for(WebElement country:countries)
            {
	    	System.out.println(country.getText());
	    	if(country.getText().equalsIgnoreCase("India"))
	    	{
	    		String x = "//button"+"["+i+"]";
	    		country.findElement(By.xpath(x)).click();
	    		break;
	    		
	    	}
	    	else
	    	{
	    		i++;
	    	}
	    	
          }
            
            driver.findElement(By.xpath("//div[@class='actions'] //a")).click();
	    	
	    }
		
		// verify addidas is displaying in order page
	
//	@Test(dependsOnMethods={"submitOrder"})
//	public void validateOrderHistoryPage() throws InterruptedException
//	{
//		landingPage.goTOLandingPage();
//		
//		Thread.sleep(5000);
//		
//		 String ordername=orderPageCart();
//		 
//		 System.out.println(ordername);
//		 
//		 assertEquals("adidas original",ordername);		
//	
//	}	
		
		
	    
	
		
	}


