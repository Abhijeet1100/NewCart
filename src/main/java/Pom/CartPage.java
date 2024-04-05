package Pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(xpath="//div[@class='cart'] //div //h3[text()='adidas original']")
	WebElement productPurchase;
	
	@FindBy(css=".totalRow .btn.btn-primary")
	WebElement proceed;
	
	public void goTOCart() throws InterruptedException
	{
		Thread.sleep(5000);
		
		cart.click();
		
		Thread.sleep(5000);
		
		productCheckout();
	}
	
	public void productCheckout()
	{
		if(productPurchase.getText().equalsIgnoreCase("adidas original"))
		{
	    	proceed.click();
	    }
	}
	

}
