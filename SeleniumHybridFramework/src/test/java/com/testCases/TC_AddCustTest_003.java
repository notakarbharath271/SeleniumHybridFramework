package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.AddNewCustomerPage;
import com.pageObjects.LoginPage;

public class TC_AddCustTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setusername(Username);
		lp.setpasword(Pasword);
		lp.clickonloginbtn();
		logger.info("login is complected");
		
Thread.sleep(3000);
		
		AddNewCustomerPage addcust=new AddNewCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Nani");
		addcust.custgender("male");
		Thread.sleep(3000);
		addcust.custdob("10","5","1994");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("517127");
		addcust.custtelephoneno("9494335417");
		
		String email=randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			Assert.assertTrue(false);
			captureScreen(driver,"addNewCustomer");
		}
			
	}
	
	 

}
