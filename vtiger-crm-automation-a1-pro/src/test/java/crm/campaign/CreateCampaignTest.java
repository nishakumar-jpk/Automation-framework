package crm.campaign;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import BaseUtility.BaseClass;
import generic_utility.JavaUtility;
import object_repository.CampaignPage;

@Listeners(listeners_utility.List_Imp.class)
public class CreateCampaignTest extends BaseClass {
	@Test
	public void createCampaign() {

		String campaignName = "AutoCampaign" + JavaUtility.generateRandomNumber();

		String url = "http://localhost:8888/";

		driver.get(url + "index.php?module=Campaigns&action=index");

		CampaignPage cp = new CampaignPage(driver);
		cp.getCreateCampaignButton().click();

		cp.getCampaignName().sendKeys(campaignName);

		Select typeSelect = new Select(cp.getCampaignType());
		typeSelect.selectByContainsVisibleText("Email");

		Select statusSelect = new Select(cp.getCampaignStatus());
		statusSelect.selectByVisibleText("Active");

		cp.getClosingDate().sendKeys("12/31/2026");
		cp.getBudget().sendKeys("10000");
		cp.getActualCost().sendKeys("7500");
		cp.getExpectedRevenue().sendKeys("50000");
		cp.getExpectedResponseCount().sendKeys("200");

		cp.getDescription().sendKeys("Automated test campaign created by selenium POM scipt. "
				+ "This is an email marketing campaign for testing.");

		cp.getSaveButton().click();
		String actCampaignName = cp.getDetailViewCampaignName().getText();
		Assert.assertEquals(actCampaignName, campaignName);
	}
}
