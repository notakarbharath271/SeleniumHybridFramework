package stepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import baseClass.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SearchCustomerPage;

public class StepDefination extends TestBase {
	
	@Before
	public void setup() throws IOException {
		
		
		 logger=Logger.getLogger("nopCommerce"); // added logger
		 PropertyConfigurator.configure("log4j.properties");// added logger
		   
		   
		//Reading properties
		configprop = new Properties();
		FileInputStream configpropfile=new FileInputStream("config.properties");
		configprop.load(configpropfile);
		
		 String desire_browser=configprop.getProperty("browser");
		   
		if(desire_browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
		driver=new ChromeDriver();
		}
		else if(desire_browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", configprop.getProperty("firefoxpath"));
			driver=new FirefoxDriver();
			}
		else if(desire_browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", configprop.getProperty("iepath"));
			driver=new InternetExplorerDriver();
			}
		
		logger.info("**************Launching Browser***************");
		driver.manage().deleteAllCookies();
		logger.info("**************deleting all cookies***************");
		driver.manage().window().maximize();
		logger.info("**************Maximizing the browser window***************");
		
	}
	
	@Given("User launch Chrome Browser")
	public void user_launch_Chrome_Browser() {
		  
		lp=new LoginPageObjects(driver);
	
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
		
		logger.info("**************Open the URL***************");
		driver.get(url);
	   
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_Email_as_and_Password_as(String username, String pwd) {
		
	    lp.setcustUserName(username);
	    logger.info("**************Entered the UserName to text field***************");
	    lp.setcustpassword(pwd);
	    logger.info("**************Entered the Password to text field***************");
	}

	@When("Click on Login Button")
	public void click_on_Login_Button() throws InterruptedException {
	   lp.clickonloginbtn();
	   logger.info("**************Clicked on Login Button***************");
	   Thread.sleep(3000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		
		logger.info("**************Verfying Login is Sucessfull are not***************");
	    if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }else {
	    	Assert.assertEquals(title,driver.getTitle());
	    }
	}

	@When("Usre click on log out link")
	public void usre_click_on_log_out_link() throws InterruptedException {
		lp.clicklogoutbtn();
		logger.info("**************Clicked on Logout Button***************");
		Thread.sleep(3000);
	    
	}

	@Then("Close the browser")
	public void close_the_browser() {
		logger.info("**************After completction of all functionalies closing the Browser***************");
	   driver.close();
	}
// AddNew Customer stepDefination 
	

@Then("User can view Dashboard")
public void user_can_view_Dashboard() {
	
	ad = new AddCustomerObjects(driver);
	logger.info("**************Verfying is ***************");
	Assert.assertEquals("Dashboard / nopCommerce administration",ad.getPageTitle());
	logger.info("**************After Login Dashoard page is opened ***************");
}

@When("User click on customers Menu")
public void user_click_on_customers_Menu() throws InterruptedException {
	Thread.sleep(3000);
   ad.clickOnCustomersMenu();
   logger.info("**************Clicked on Customers Menu***************");
}

@When("click on customer Menu Item")
public void click_on_customer_Menu_Item() throws InterruptedException {
	Thread.sleep(3000);
    ad.clickOnCustomersMenuItem();
    logger.info("**************Clicked on Customer Menu Item***************");
}

@When("click on Add New button")
public void click_on_Add_New_button() throws InterruptedException {
   ad.clickOnAddnew();
   Thread.sleep(3000);
   logger.info("**************Clicked on Add New Customer link Button***************");
}

@Then("User can view Add New customer page")
public void user_can_view_Add_New_customer_page() {
	Assert.assertEquals("Add a new customer / nopCommerce administration",ad.getPageTitle());
    
}

@When("User enter customer info")

public void user_enter_customer_info() throws InterruptedException {
	logger.info("**************Adding New Customer***************");
	logger.info("**************Providing Customer Details***************");
   ad.click_plus_Button();
   Thread.sleep(2000);
   String email= generateRandomstring()+"@gmail.com";
   ad.setEmail(email);
   ad.setPassword("cucumber123");
   ad.setFirstName("Bharath");
   ad.setLastName("N");
   ad.setGender("Male");
   ad.setDob("02/07/1994");
   ad.setCompanyName("Testing Solutions");
   ad.setAdminContent("This is for Testing purpose---------------");
   //Register is default
   //The customer cannot be in both 'Guest' and 'Registered' customer role
   //Add customer to 'Guest' or'Registered' customer role
   ad.setCustomerRoles("Guest");
   Thread.sleep(3000);
   ad.setManagerOfVendor("Vendor 2");
   
}

@When("click on save button")
public void click_on_save_button() throws InterruptedException {
	ad.clickOnSave();
	Thread.sleep(3000);
	logger.info("**************Clicked on Save Button***************");
	
    
}

@Then("User can view confirmation message {string}")
public void user_can_view_confirmation_message(String message) {
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	logger.info("**************Customer is saved***************");
}

// steps Definition for Searching a customer by using email id

@When("Enter customer EmailId")
public void enter_customer_EmailId() {
	
	logger.info("**************Searching the customer By Email id***************");
	scp=new SearchCustomerPage(driver);
	scp.setEmail("victoria_victoria@nopCommerce.com");
	
	
   
}

@When("Click on search button")
public void click_on_search_button() throws InterruptedException {
	scp.clickOnSearchbtn();
	logger.info("**************Clicked on search button***************");
	Thread.sleep(3000);
	
    
}

@Then("User should found Email in the search table")
public void user_should_found_Email_in_the_search_table() {
	logger.info("**************Checking the Email id which we provied is present in the Table are not ***************");
    boolean status=scp.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
    Assert.assertEquals(true,status);
    
    
}

//steps Definition for Searching a customer by using Name

@When("Enter customer FirstName")
public void enter_customer_FirstName() {
	
	logger.info("**************Searching the Customer By providing Name***************");
	scp=new SearchCustomerPage(driver);
	scp.setFirstname("Victoria ");
}

@When("Enter customer LastName")
public void enter_customer_LastName() {
  scp.setLastName("Terces");
}

@Then("User should found Name in the search table")
public void user_should_found_Name_in_the_search_table() {
	logger.info("**************Checking the Name which we provied is present in the Table are not ***************");
 boolean status=scp.searchCustomerByName("Victoria Terces") ;
 Assert.assertEquals(true, status);

}

}
