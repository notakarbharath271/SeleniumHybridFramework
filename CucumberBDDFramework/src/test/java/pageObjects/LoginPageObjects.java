package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.TestBase;

public class LoginPageObjects extends TestBase{
	

	
	public LoginPageObjects(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	@CacheLookup
	WebElement loginbtn;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	@CacheLookup
	WebElement logootbtn;
	
	
	public void setcustUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void setcustpassword(String password) {
		pwd.sendKeys(password);
	}
	
	public void clickonloginbtn() {
		loginbtn.click();
	}
	
	public void clicklogoutbtn() {
		logootbtn.click();
	}

}
