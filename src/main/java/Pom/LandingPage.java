package Pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		
		
		PageFactory.initElements(driver,this);
	}
	
	
	
	//page factory create object of elements
	
	@FindBy(id="userEmail")
	WebElement userId;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='ng-trigger-flyInOut'")
	WebElement wrongData;
	
	
	
	//implementing action methods
	
	public void loginApp(String email,String pass)
	{
		
		userId.sendKeys(email);
		
		password.sendKeys(pass);

		submit.click();
		
	}
	
	public String wrongLoginData()
	{
		waitForElementToAppear(wrongData);
		return wrongData.getText();
	}
	
	
	
	public void goTOLandingPage()
	{

		driver.get("https://rahulshettyacademy.com/client");

		
	}
	
	

}
