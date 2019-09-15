package utlities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void waitforElement(WebElement element, long timeinseconds) {
		
		WebDriverWait wait =new  WebDriverWait(driver,timeinseconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

}
