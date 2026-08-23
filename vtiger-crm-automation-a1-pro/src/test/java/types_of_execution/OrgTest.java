package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrgTest {
@Test(groups="smoke")
public void createOrgTest() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	Thread.sleep(2000);
	driver.quit();
}
@Test(groups="regression")
public void modifyOrgTest() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	Thread.sleep(2000);
	driver.quit();
}	

@Test(groups="regression")
public void deleteOrgTest() throws InterruptedException {
WebDriver driver=new ChromeDriver();
Thread.sleep(2000);
driver.quit();
}
}