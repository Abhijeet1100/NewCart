package Pom;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Reusable.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath="//tr[@class='ng-star-inserted'][1] //td[2]")
	WebElement ordersPresent;
	
	
	
	public void verifyOrderPresent()
	{
		System.out.println(ordersPresent.getText());
//		
//		String ordername=null;
//		
//		
//		for(int i=0;i<ordersPresent.size();i++)
//		{
//			
//			if(ordersPresent.get(i).getText().contains("adidas original"))
//			{
//				 ordername = ordersPresent.get(i).getText();
//				 System.out.println(ordername);
//				 break;
//			}
//		}
//		return ordername;
	}

}
