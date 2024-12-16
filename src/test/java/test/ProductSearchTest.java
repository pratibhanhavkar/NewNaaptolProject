package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
	public void launchApplication() {
		driver = Browser.LaunchApplication();
					}
	@Test
	
	public void verifyIfUserIsAbleToSearchValidProduct() {
		test = reports.createTest("verifyIfUserIsAbleToSearchValidProduct");
		
		NaaptolHomePage naaptolehomepage = new NaaptolHomePage(driver);
		naaptolehomepage.enterProductToSearch("mobile");
		naaptolehomepage.clickOnSearch();
		
		Assert.assertTrue(naaptolehomepage.getNumberOfProductDisplayed()>0);
				
	}
     @Test
	public void verifyIfUserIsAbleToSearchInalidProduct() {
    	 test = reports.createTest("verifyIfUserIsAbleToSearchInalidProduct");
    		NaaptolHomePage naaptolehomepage = new NaaptolHomePage(driver);
    		naaptolehomepage.enterProductToSearch("iphone16");
    		naaptolehomepage.clickOnSearch();
    		
    		Assert.assertEquals(naaptolehomepage.getErrorMessage(), "Either no product matches the word entered by you or please remove some of filter options selected to see products.");
     }
     
 	@AfterMethod
 	public void closeBrowser()
 	{
 		driver.close();
 	}
 	

}
