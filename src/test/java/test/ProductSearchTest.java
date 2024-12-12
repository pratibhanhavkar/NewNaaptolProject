package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaaptolHomePage;
import utility.Reports;

public class ProductSearchTest extends BaseTest {
	 @BeforeTest
	   public void configureReports() {
		  reports = Reports.createReport();
	   }
	@BeforeMethod
	public void lunchApplication() {
		driver = Browser.LunchApplication();
					}
	@Test
	
	public void VerifyIfUserIsAbleToSearchValidProduct() {
		test = reports.createTest("VerifyIfUserIsAbleToSearchValidProduct");
		
		NaaptolHomePage naaptolehomepage = new NaaptolHomePage(driver);
		naaptolehomepage.EnterProductToSearch("mobile");
		naaptolehomepage.ClickOnSearch();
		
		Assert.assertTrue(naaptolehomepage.getNumberOfProductDisplayed()>0);
				
	}
     @Test
	public void VerifyIfUserIsAbleToSearchInalidProduct() {
    	 test = reports.createTest("VerifyIfUserIsAbleToSearchInalidProduct");
    		NaaptolHomePage naaptolehomepage = new NaaptolHomePage(driver);
    		naaptolehomepage.EnterProductToSearch("iphone16");
    		naaptolehomepage.ClickOnSearch();
    		
    		Assert.assertEquals(naaptolehomepage.getErrorMessage(), "Either no product matches the word entered by you or please remove some of filter options selected to see products.");
     }

}
