package Pom;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import TestComponent.BaseTest;

public class ErrorValidation extends BaseTest{
	
	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		
			
		landingPage.loginApp("abc333@gmail.com", "Qwer12345");
		
		assertEquals("Incorrect email or password.",landingPage.wrongLoginData());
	}
	
	
}
