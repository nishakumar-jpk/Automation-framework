package crm.organization;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.*;
import object_repository.HomePage;
import object_repository.OrganizationPage;



@Listeners(listeners_utility.List_Imp.class)
public class CreateOrgTest extends BaseClass{
   @Test
	public void OrgTest () throws EncryptedDocumentException, IOException {
	   FileUtility futil=new FileUtility();
	   String orgname=futil.getDataFromExcelFile("org", 1, 0)+JavaUtility.generateRandomNumber();
	
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationButton().click();

		op.getOrganizationName().sendKeys(orgname);
		op.getPhone().sendKeys("9876543210");
		op.getEmail().sendKeys("testorg@vtiger.com");
		op.getWebsite().sendKeys("www.testorg.com");
		op.getSaveButton().click();

		String actOrgName = op.getDetailViewOrganizationName().getText();
		Assert.assertEquals(actOrgName, orgname);
        
	

	}	
}
