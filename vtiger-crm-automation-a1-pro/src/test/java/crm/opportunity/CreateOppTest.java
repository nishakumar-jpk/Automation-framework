package crm.opportunity;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import object_repository.HomePage;
import object_repository.OpportunityPage;

@Listeners(listeners_utility.List_Imp.class)

public class CreateOppTest extends BaseClass {
	 
	 @Test

	public void createOrg () throws EncryptedDocumentException, IOException{

		 FileUtility futil=new FileUtility();
		 String oppName=futil.getDataFromExcelFile("opp", 1, 1)+JavaUtility.generateRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getOpportunitiesLink().click();


		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOpportunityButton().click();

		//String oppName1 = "OppTest" + JavaUtility.generateRandomNumber();
		op.getOpportunityName().sendKeys(oppName);
		op.getAmount().sendKeys("75000");
		op.getClosingDate().sendKeys("2026-08-23");
         
		Select stageSelect = new Select(op.getSalesStage());
		stageSelect.selectByVisibleText("Prospecting");
		
		Select typeSelect = new Select(op.getOpportunityType());
		typeSelect.selectByVisibleText("Existing Business");
		
		Select lsSelect = new Select(op.getLeadSource());
		lsSelect.selectByVisibleText("Web Site");
		
      

	
		String parentWindowHandle = driver.getWindowHandle();

		op.getRelatedToPickerIcon().click();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.switchToWindowByUrl("Organizations");

		driver.findElement(org.openqa.selenium.By.partialLinkText("AutomationWithNish")).click();

		driver.switchTo().window(parentWindowHandle);

		op.getSaveButton().click();

		String actOppName = op.getDetailViewOpportunityName().getText();
		Assert.assertEquals(actOppName, oppName);

	 }
}
