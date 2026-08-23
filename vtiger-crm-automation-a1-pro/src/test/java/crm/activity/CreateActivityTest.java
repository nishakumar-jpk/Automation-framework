package crm.activity;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.ActivityPage;

@Listeners(listeners_utility.List_Imp.class)

public class CreateActivityTest extends BaseClass{
@Test
	public void createActivity() {

		String activitySubject = "AutoMeeting" + JavaUtility.generateRandomNumber();



        String url="http://localhost:8888/";

		driver.get(url + "index.php?module=Calendar&action=EditView&activity_mode=Events");

		ActivityPage ap = new ActivityPage(driver);

		ap.getSubject().sendKeys(activitySubject);

    	WebDriverUtility wu=new WebDriverUtility(driver);
    	wu.select("Meeting",ap.getActivityType());
		wu.select("Planned",ap.getEventStatus());
		
		ap.getStartDate().clear();
		ap.getStartDate().sendKeys("2027-12-31");
		ap.getLocation().sendKeys("Conference Room A");
        ap.getDescription().sendKeys("Automated test meeting created .");
        ap.getSaveButton().click();
		
		String actSubject = ap.getDetailViewSubject().getText();
		Assert.assertEquals(actSubject, activitySubject);
        	
		System.out.println("Create Activity Test Completed.");
	}
}
