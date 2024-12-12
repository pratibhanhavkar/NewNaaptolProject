package test;

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
	public void lunchApplication() {
		driver = Browser.LunchApplication();
		}
	
	@Test
	public void VerifyOnClickingShoppingCategories () {
		test = reports.createTest("VerifyOnClickingShoppingCategories");
		ShoppingCategoiesPage shoppingcat = new ShoppingCategoiesPage(driver);
		shoppingcat.clickonshoppingcategories(driver);
		shoppingcat.moveToMobiles(driver);
		shoppingcat.moveToSmartphones(driver);
		//shoppingcat.clickOnSmartPhone();
	}
	

}
