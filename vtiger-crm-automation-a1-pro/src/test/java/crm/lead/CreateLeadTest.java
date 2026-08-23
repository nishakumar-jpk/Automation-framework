package crm.lead;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.Status;

import BaseUtility.BaseClass;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;

import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import object_repository.HomePage;
import object_repository.LeadPage;

@Listeners(listeners_utility.List_Imp.class)

public class CreateLeadTest extends BaseClass{
@Test
	public void createLead() throws InterruptedException {


		String lastName = "LeadTest" + JavaUtility.generateRandomNumber();
		String companyName = "TestCompany" + JavaUtility.generateRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		LeadPage leadPage = new LeadPage(driver);
		leadPage.getCreateLeadButton().click();

         WebDriverUtility wu=new WebDriverUtility(driver);
         wu.select("Mr.", leadPage.getSalutation());
		
		leadPage.getFirstName().sendKeys("AutoLead");
		leadPage.getLastName().sendKeys(lastName);
		leadPage.getCompany().sendKeys(companyName);
		leadPage.getPhone().sendKeys("044-98765432");
		leadPage.getMobile().sendKeys("7890123456");
		leadPage.getEmail().sendKeys("autolead@testcompany.com");
		leadPage.getTitle().sendKeys("Manager");
		leadPage.getWebsite().sendKeys("www.testcompany.com");
		leadPage.getAnnualRevenue().sendKeys("500000");
		leadPage.getNoOfEmployees().sendKeys("50");
        
		Select lsselect=new Select(leadPage.getLeadSource());
		lsselect.selectByVisibleText("Web Site");
		
		Select statusselect=new Select(leadPage.getLeadSource());
		statusselect.selectByIndex(1);
        	
		leadPage.getStreet().sendKeys("123 Test Street");
		leadPage.getCity().sendKeys("Bangalore");
		leadPage.getState().sendKeys("Karnataka");
		leadPage.getZipCode().sendKeys("560001");
		leadPage.getCountry().sendKeys("India");

		leadPage.getSaveButton().click();

		String actLastName = leadPage.getDetailViewLastName().getText();
		Assert.assertEquals(actLastName, lastName);

	
	}
}
