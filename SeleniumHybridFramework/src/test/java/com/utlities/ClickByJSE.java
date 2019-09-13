package com.utlities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickByJSE {
	
	public static void clickOnButton(WebElement element,WebDriver driver) {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click", element);
	}

}
