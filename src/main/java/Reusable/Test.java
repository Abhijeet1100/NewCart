package Reusable;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://v9-recette.lapeyre.fr/produits/meuble-bas-cuisine-preparation-1-porte-extractible-FPC3140552");
		
		driver.findElement(By.xpath("//a[@data-attribute-short-identifier='ATC-MODELE']")).click();
		
		Thread.sleep(4000);
		
		
		
		List<WebElement> finitions = driver.findElements(By.xpath("//div[@class='co-configuration-box-combo--sb-types-card-list'] //div[@class='co-card-image--content']"));
		
		
        System.out.println(finitions.size());
		
        
        
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
		
		for(int i=0;i<finitions.size();i++)
		{
	
		 Thread.sleep(4000); 
	
	     js.executeScript("arguments[0].click();", finitions.get(i));
	     
	     
		   System.out.println(i);
		   
		   Thread.sleep(4000);
		   
		   //texture
		   
		 List<WebElement> texture =  driver.findElements(By.cssSelector(".co-configuration-box-combo--sb-colors-card-list .co-card-color--content"));
		   
		 for(int k=0;k<texture.size();)
		 {
			 System.out.println(k);
			 
			 texture.get(k).click();
			 
			 Thread.sleep(4000);
		
		   
          // box color
		   
		   
		   driver.findElement(By.xpath("(//div[@class='co-box-composition--box'] //div[@class='co-accordion--header'])[3]")).click();
		   
		   Thread.sleep(4000);
		   
		 //  choose color for box
		   
		   List<WebElement> colors =  driver.findElements(By.xpath("//div[@class='co-configuration-box-colors--card-list'] //div //div[@class='co-card-color--circle']"));
		
        System.out.println(colors.size())
        ;
        for(int j=0;j<colors.size();)
        {
        	
        	
        	System.out.println(j);
        	Thread.sleep(4000);
        	
        	colors.get(j).click();
        	
        	Thread.sleep(4000);
	
        	driver.findElement(By.cssSelector(".co-pannel-step.elevated.s1456363794 .btn")).click();
 		   
 		    Thread.sleep(5000);
 		   
 		
 		 
 	 
 		   
   	         String ref = driver.findElement(By.cssSelector(".prod-refrate #product_SKU_237428")).getText();
 		 
 		      System.out.println("reference number="+ref);
 		 
 		      Thread.sleep(2000);
 		 
           String price =  driver.findElement(By.cssSelector(".prod-prix")).getText();
 		 
 		       System.out.println(price);
 		       
 		       Thread.sleep(4000);
 		 
 		      driver.findElement(By.xpath("//a[@data-attribute-short-identifier='ATC-MODELE']")).click();
 		 
 		 Thread.sleep(4000);
 		 j++;
 		 if(j<colors.size())
 		 {
 		
 		driver.findElement(By.xpath("(//div[@class='co-box-composition--box'] //div[@class='co-accordion--header'])[3]")).click();
		   
		    Thread.sleep(4000);
    	
    	colors =  driver.findElements(By.xpath("//div[@class='co-configuration-box-colors--card-list'] //div //div[@class='co-card-color--circle']"));
 		 }
		
		
	     
		     }
        
        
        Thread.sleep(4000);
        
          k++;
          
		 if(k<texture.size())
		 {
		
		    
		   
		    Thread.sleep(4000);
   	
		    texture =  driver.findElements(By.cssSelector(".co-configuration-box-combo--sb-colors-card-list .co-card-color--content"));
		    
		    Thread.sleep(4000);
		 }
        
        
        
		  }
		
		 
       }
	
	
	
			

	}

}


