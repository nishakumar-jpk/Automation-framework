package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_utility.fileUtility2;

public class Login {
	

	    @DataProvider(name = "loginData")
	    public Object[][] getLoginData() throws Exception {
	        return fileUtility2.getData();
	    }

	    @Test(dataProvider = "loginData")
	    public void login(String username, String password) {

	        WebDriver driver = new ChromeDriver();

	        driver.manage().window().maximize();
	        driver.get("https://www.saucedemo.com/");

	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	        driver.findElement(By.id("login")).click();

	        driver.quit();
	    }
	}



