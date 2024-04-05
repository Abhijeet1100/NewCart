package Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.AbstractComponent;

public class ProductCatalog extends AbstractComponent{
	
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='container'] //b")
	List<WebElement> productList;
	
	
	
	By addToCart = By.xpath("(//div[@class='d-flex flex-row my-2'])[2] //following-sibling::button[2]");
	
	By products = By.cssSelector(".mb-3");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(products);
		return productList;
	}
	
	public WebElement getProductByName(String productName)
	{
		List<WebElement> elements = getProductList();
		
		WebElement product=null;
		
		for(WebElement element:elements)
		{
			if(element.getText().equalsIgnoreCase(productName))
			{
				
			product = element.findElement(addToCart);
				break;
			}
			else
			{
				continue;
			}
		}
		return product;
	}
	
	
	

}
