package com.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.pageObjects.LoginPage;
import com.utlities.ReadingConfigProperties;

public class BaseClass {
	
	ReadingConfigProperties rcp= new ReadingConfigProperties();
	public  String baseURL=rcp.getApplicationURL();
	public  String Username=rcp.getUaseName();
	public  String Pasword=rcp.getPassword();
	public  static  WebDriver driver;
	LoginPage  lp;
	public static long page_Load_Timeout=30;
	public static long Imp_Wait=30;
	
	public static Logger logger; //Adding logger
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("SeleniumHybridFramework");//Adding logger
		PropertyConfigurator.configure("log4j.properties");//Adding logger
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", rcp.getchromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rcp.getffpath());
			driver=new FirefoxDriver();
		}
		else if (br.equals("iexplore")) {
			System.setProperty("webdriver.ie.driver", rcp.iepath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Imp_Wait, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Imp_Wait, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public static String randomString() {
		 String generateString1=RandomStringUtils.randomAlphabetic(8);
		 return(generateString1);
	 }
	
	

	public static void clickOnButton(WebElement element) {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", element);
	}

		

}
