package crm.contact;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.ContactPage;
import object_repository.HomePage;

@Listeners(listeners_utility.List_Imp.class)

public class CreateContactTest extends BaseClass{
@Test
	public void createContact() {
      
       
		String lastName = "TestContact" + JavaUtility.generateRandomNumber();
		String firstName = "Auto";

		WebDriverUtility wu = new WebDriverUtility(driver);
		HomePage hp = new HomePage(driver);
		wu.waitAndClick(hp.getContactsLink());

		ContactPage cp = new ContactPage(driver);
		wu.waitAndClick(cp.getCreateContactButton());

		wu.select("Mr.", cp.getSalutation());

		cp.getFirstName().sendKeys(firstName);
		cp.getLastName().sendKeys(lastName);
		cp.getOfficePhone().sendKeys("080-12345678");
		cp.getMobile().sendKeys("9988776655");
		cp.getEmail().sendKeys("autocontact@test.com");
		cp.getTitle().sendKeys("QA Engineer");
		cp.getDepartment().sendKeys("Quality Assurance");

		wu.select("Web Site", cp.getLeadSource());

		wu.waitAndClick(cp.getSaveButton());

		wu.waitForElementVisible(cp.getDetailViewLastName());
		String actLastName = cp.getDetailViewLastName().getText();
		Assert.assertEquals(actLastName, lastName);

		System.out.println("Create Contact Test Completed.");
	}
}
