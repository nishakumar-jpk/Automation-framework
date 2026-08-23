package crm.cases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import org.testng.*;
import object_repository.CasePage;

@Listeners(listeners_utility.List_Imp.class)

public class CreateCaseTest extends BaseClass{
@Test
	public void createCase() {

		String ticketTitle = "AutoTicket" + JavaUtility.generateRandomNumber();
        String url="http://localhost:8888/";
        driver.get(url+"index.php?module=HelpDesk&action=index");

		CasePage cp = new CasePage(driver);
		cp.getCreateCaseButton().click();

		cp.getTicketTitle().sendKeys(ticketTitle);
        
    	WebDriverUtility wu=new WebDriverUtility(driver);
        wu.select("Open",cp.getTicketStatus());
		wu.select("High",cp.getTicketPriority());
        wu.select("Major", cp.getTicketSeverity());
		
		cp.getDescription().sendKeys("This is an automated test ticket created. "
				+ "Testing the create ticket functionality of VTiger CRM.");

		cp.getSolution().sendKeys("Automated resolution - ticket was created for testing purposes.");
		cp.getSaveButton().click();
		String actTitle = cp.getDetailViewTitle().getText();
		Assert.assertEquals(actTitle, ticketTitle);

		System.out.println("Create Case Test Completed.");
	}
}
