package crm.product;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseUtility.BaseClass;
import generic_utility.JavaUtility;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

import object_repository.HomePage;
import object_repository.ProductPage;

@Listeners(listeners_utility.List_Imp.class)

public class CreateProductTest extends BaseClass {
@Test
	public void createTest() {

	
		String productName = "AutoProduct" + JavaUtility.generateRandomNumber();
		String productCode = "PROD" + JavaUtility.generateRandomNumber();
        
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductButton().click();

		pp.getProductName().sendKeys(productName);
		pp.getProductCode().sendKeys(productCode);
		pp.getQtyPerUnit().sendKeys("1");
		pp.getUnitPrice().sendKeys("999.99");
		pp.getCommissionRate().sendKeys("10");
		pp.getQtyInStock().sendKeys("100");
		pp.getReorderLevel().sendKeys("10");

       Select categoryselect=new Select(pp.getProductCategory());
       categoryselect.selectByIndex(1);
		pp.getDescription().sendKeys("Automated test product created.");

		pp.getSaveButton().click();

		String actProductName = pp.getDetailViewProductName().getText();
		Assert.assertEquals(actProductName, productName);

	}
}
