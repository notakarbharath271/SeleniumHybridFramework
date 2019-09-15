package baseClass;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SearchCustomerPage;

public class TestBase {
	
	public static WebDriver driver;
	
	public LoginPageObjects lp;
	
	public AddCustomerObjects ad;
	public SearchCustomerPage scp;
	public static Logger logger;
	public Properties configprop; 
	
	
	
	// generate random string of length of 5
	public static String generateRandomstring() {
		
		String Randomstring=RandomStringUtils.randomAlphabetic(5);
		return Randomstring;
		
	}

}
