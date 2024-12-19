package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaaptolHomePage;
import utility.Reports;

public class ProductSearchTest extends BaseTest {
	 @BeforeTest
	   public void configureReports() {
		  reports = Reports.createReport();
	   }
    @Parameters({"browser"})
	@BeforeMethod
	public void launchApplication(String browser) {
		driver = Browser.LaunchApplication(browser);
					}
	@Test
	
	public void verifyIfUserIsAbleToSearchValidProduct() {
		test = reports.createTest("verifyIfUserIsAbleToSearchValidProduct");
		
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("mobile");
		naaptolHomePage.clickOnSearch();
		
		Assert.assertTrue(naaptolHomePage.getNumberOfProductDisplayed()>0);
				
	}
     @Test
	public void verifyIfUserIsAbleToSearchInalidProduct() {
    	 test = reports.createTest("verifyIfUserIsAbleToSearchInalidProduct");
    		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
    		naaptolHomePage.enterProductToSearch("iphone16");
    		naaptolHomePage.clickOnSearch();
    		
    		Assert.assertEquals(naaptolHomePage.getErrorMessage(), "Either no product matches the word entered by you or please remove some of filter options selected to see products.");
     }
     
 	@AfterMethod
 	public void closeBrowser()
 	{
 		driver.close();
 	}
 	

}
