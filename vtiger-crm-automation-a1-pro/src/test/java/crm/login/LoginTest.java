package crm.login;


import org.testng.annotations.Test;

import BaseUtility.BaseClass;


public class LoginTest extends BaseClass {
@Test
	public void login() {

      
		String pageTitle = driver.getTitle();
		if (pageTitle.toLowerCase().contains("vtiger")) {
			System.out.println("Login successful! Page title: " + pageTitle);
		} else {
			System.out.println("Login might have failed. Page title: " + pageTitle);
		}
	

		System.out.println("Login Test Completed.");
	}
}
