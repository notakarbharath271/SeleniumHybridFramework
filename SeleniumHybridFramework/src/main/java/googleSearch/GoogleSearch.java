package googleSearch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		BingSearch();
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers1/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Core java");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"));
		System.out.println(list.size());
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			if(ele.getText().contains(" interview questions pdf")) {
				ele.click();
				break;
			}
		}
		driver.quit();
	}
	
	public static void BingSearch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers1/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.bing.com/");
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("Selenium");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='sa_ul']//li/descendant::div[@class='sa_tm']"));
		System.out.println(list.size());
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			
			if(ele.getText().contains(" interview questions")) {
			
				ele.click();
				break;
			}
		}
		driver.quit();
	}

}
