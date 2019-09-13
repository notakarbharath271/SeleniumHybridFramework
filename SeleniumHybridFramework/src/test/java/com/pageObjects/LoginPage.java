package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testCases.BaseClass;

public class LoginPage extends BaseClass{
	public WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement lnklogout;
	
	//User ID :	mngr221888
	//Password :	husAsem
	public void setusername(String UsreName) {
		username.sendKeys(UsreName);
	}
	
	public void setpasword(String Password) {
		pwd.sendKeys(Password);
	}
	
	public void clickonloginbtn() {
		loginbtn.click();
		//clickOnButton(loginbtn);
		
	}
	
	public void clickonLogoutlnk() {
		lnklogout.click();
	}
	
	
	
}
