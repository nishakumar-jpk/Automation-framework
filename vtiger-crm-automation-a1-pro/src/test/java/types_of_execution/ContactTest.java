package types_of_execution;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	public class ContactTest {

	@Test(groups="smoke")
	public void createConTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(groups="regression")
	public void modifyConTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.quit();
	}	

	@Test(groups="regression")
	public void deleteConTest() throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	Thread.sleep(2000);
	driver.quit();
	}
	}


