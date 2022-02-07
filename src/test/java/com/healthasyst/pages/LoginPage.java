package com.healthasyst.pages;

import org.openqa.selenium.By;

import com.healthasyst.base.WebDriverWrapper;

public class LoginPage {
	
	public static void enterUsername(String userName) {
		WebDriverWrapper.driver.findElement(By.id("authUser")).sendKeys(userName);
	}

}
