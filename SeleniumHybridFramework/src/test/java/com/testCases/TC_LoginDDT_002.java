package com.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.utlities.ExcelUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user,String pwd) throws InterruptedException 
	{
		LoginPage lp =new LoginPage(driver);
		lp.setusername(user);
		logger.info("username is provieded");
		lp.setpasword(pwd);
		logger.info("password is provieded");
		lp.clickonloginbtn();
		logger.info("clicked on login btn");
		Thread.sleep(3000);
		logger.info("waiting 3sec");
		if(isAlertPresent()==true) //negative Scenario
		{
			driver.switchTo().alert().accept();
			logger.info("clicking on ok btn of the alert box");
			driver.switchTo().defaultContent();
			logger.info("it comes to default login page");
			Assert.assertTrue(false);
			logger.info("if the allert is present it the failed scenario");
			Thread.sleep(3000);
			logger.info("waiting 3sec");
		}
		else //Positive Scenario
		{
			Assert.assertTrue(true);
			logger.info("if alert window is not come it is positve scenario");
			lp.clickonLogoutlnk();
			logger.info("clicking on logout link");
			driver.switchTo().alert().accept(); // close  the alert box of the logout
			logger.info("alert window of the logout and clickig on the ok btn to removing the alert box");
			driver.switchTo().defaultContent();
			logger.info("it comes to default login page");
			Thread.sleep(3000);
			logger.info("waiting 3sec");
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
	}
	@DataProvider(name="LoginData")
	
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/testData/LoginDAta.xlsx";
		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colnum=ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				logindata[i-1][j]=ExcelUtils.getCellData(path, "Sheet1", i, j);//i=1 j=0
			}
		}
		return logindata;
		
	}

}
