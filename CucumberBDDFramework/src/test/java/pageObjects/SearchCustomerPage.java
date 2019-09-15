package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utlities.WaitHelper;

public class SearchCustomerPage {

	WebDriver ldriver;
	WaitHelper waithelper;
	public SearchCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
	
	
	@FindBy(how=How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(how=How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtfirstname;
	
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtlastname;
	
	@FindBy(how=How.ID,using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdwn_month;
	
	@FindBy(how=How.ID,using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdwn_day;
	
	@FindBy(how=How.ID,using="SearchCompany")
	@CacheLookup
	WebElement txtcmpy;
	
	@FindBy(how=How.ID,using="SearchIpAddress")
	@CacheLookup
	WebElement txtipaddress;
	
	@FindBy(how=How.XPATH,using="//button[@id='search-customers']")
	@CacheLookup
	WebElement searchbtn;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	@CacheLookup
	WebElement tbsearchResult;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tbrows;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tbcolumns;
	
	
	public void setEmail(String email) {
		waithelper.waitforElement(txtemail, 30);
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	
	public void setFirstname(String fstName) {
		waithelper.waitforElement(txtfirstname, 30);
		txtfirstname.clear();
		txtfirstname.sendKeys(fstName);
	}
	
	public void setLastName(String lstName) {
		waithelper.waitforElement(txtlastname, 30);
		txtlastname.clear();
		txtlastname.sendKeys(lstName);
	}
	
	public void clickOnSearchbtn() {
		waithelper.waitforElement(searchbtn, 30);
		searchbtn.click();
	}
	
	public int getNoofRows() {
		return(tbrows.size());
	}
	
	public int getNoofColumns() {
		return (tbcolumns.size());
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag=false;
			for(int i=1;i<=getNoofRows();i++) {
				String emailID=	table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(emailID);
				if(emailID.equals(email)) {
					flag=true;
				}
			}
			return flag;
		
	}
	
	public boolean searchCustomerByName(String Name) {
		boolean flag=false;
		for(int i=1;i<=getNoofRows();i++) {
			String name=	table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			//String names[]=name.split(" ");
			if(name.equals(Name)) {
				flag=true;
			}
		}
		return flag;
	}
	
	
	
}
