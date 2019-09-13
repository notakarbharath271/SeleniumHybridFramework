package com.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		
		lp=new LoginPage(driver);
		Thread.sleep(3000);
		lp.setusername(Username);
		logger.info("Entered user Name");
		lp.setpasword(Pasword);
		logger.info("Entered password");
		lp.clickonloginbtn();
		logger.info("Clicked login button");
		driver.manage().timeouts().implicitlyWait(Imp_Wait, TimeUnit.SECONDS);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("verifying the title of the Login page ");
			Assert.assertTrue(true);
		}else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
	

}
