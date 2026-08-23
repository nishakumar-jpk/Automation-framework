package types_of_execution;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	public class LeadsTest {
	@Test(groups="smoke")
	public void createLeadTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(groups="regression")
	public void modifyLeadTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}	

	@Test(groups="regression")
	public void deleteLeadTest() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	Thread.sleep(2000);
	driver.quit();
	}
	}

