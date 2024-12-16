package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ShoppingCategoiesPage;
import utility.Reports;

public class ShoppingCategoriesTest extends BaseTest {
    @BeforeTest
	   public void configureReports() {
		  reports = Reports.createReport();
	   }
	@BeforeMethod
	public void launchApplication() {
		  driver = Browser.LaunchApplication();
		}
	
	@Test
	public void verifyOnClickingShoppingCategories () {
		test = reports.createTest("verifyOnClickingShoppingCategories");
		ShoppingCategoiesPage shoppingcat = new ShoppingCategoiesPage(driver);
		shoppingcat.clickonshoppingcategories(driver);
		shoppingcat.moveToMobiles(driver);
		shoppingcat.moveToSmartphones(driver);

	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	

}
