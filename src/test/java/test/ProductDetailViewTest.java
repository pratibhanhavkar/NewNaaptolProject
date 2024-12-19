package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojo.Browser;
import utility.Reports;
import pom.NaaptolHomePage;
import pom.NaaptolProductDetailPage;
import pom.NaaptolProductDetailQuickView;

public class ProductDetailViewTest extends BaseTest{
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
	
	public void verifyIfProdutDetailsAreCorrectIfViewInQuickView() {
        test = reports.createTest("verifyIfProdutDetailsAreCorrectIfViewInQuickView");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.enterProductToSearch("mobile");
		naaptolhomepage.clickOnSearch();
		String productNameOnHomePage = naaptolhomepage.getProductNameFromHomePage(1);
		
		NaaptolProductDetailQuickView naaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		naaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 1);
		naaptolProductDetailQuickView.clickOnQuickView(1);
	
		String productNameOnQuickView = naaptolProductDetailQuickView.getProductNameOnQuickView();
        
		Assert.assertTrue( productNameOnQuickView.contains(productNameOnHomePage));
	}
		
		@Test
		public void verifyProductDetailsAreCorrectlyViewUsingProductDetailPage() {
			 test = reports.createTest("verifyAddProductToCartUsingProductDetailPage");
			 
			NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
			naaptolhomepage.enterProductToSearch("mobile");
			naaptolhomepage.clickOnSearch();
			
			String productNameOnHomePage = naaptolhomepage.getProductNameFromHomePage(0);
			
			NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
			naaptolproductdetailpage.selectDesiredProduct(0);
			switchToChildBrowser();
			
			String productNameOnProductDetailPage = naaptolproductdetailpage.getProductDetailPageProductName();
			
		
			Assert.assertTrue(productNameOnProductDetailPage.contains(productNameOnHomePage));
			
		}	
	
		@AfterMethod
		public void closeBrowser()
		{
			driver.close();
		}
		
		
	
}	

