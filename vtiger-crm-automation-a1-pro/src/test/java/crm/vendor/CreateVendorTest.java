package crm.vendor;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import BaseUtility.BaseClass;
import generic_utility.JavaUtility;
import org.testng.*;
import object_repository.VendorPage;
@Listeners(listeners_utility.List_Imp.class)

public class CreateVendorTest extends BaseClass{
@Test
	public void createvendor() {
	String url="http://localhost:8888/";
	driver.get(url+"index.php?module=Vendors&action=index");

		String vendorName = "AutoVendor" + JavaUtility.generateRandomNumber();


		VendorPage vp = new VendorPage(driver);
		vp.getCreateVendorButton().click();

		vp.getVendorName().sendKeys(vendorName);
		vp.getPhone().sendKeys("040-88776655");
		vp.getEmail().sendKeys("autovendor@vendortest.com");
		vp.getWebsite().sendKeys("www.autovendor.com");
		vp.getGlAccount().sendKeys("GL-001");

		vp.getStreet().sendKeys("456 Vendor Street");
		vp.getCity().sendKeys("Hyderabad");
		vp.getState().sendKeys("Telangana");
		vp.getPostalCode().sendKeys("500001");
		vp.getCountry().sendKeys("India");
		vp.getDescription().sendKeys("Automated test vendor created by Selenium POM script.");
		vp.getSaveButton().click();

		String actVendorName = vp.getDetailViewVendorName().getText();
		Assert.assertEquals(actVendorName, vendorName);

	}
}
