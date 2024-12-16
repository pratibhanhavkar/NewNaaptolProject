package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
	@BeforeMethod
	public void launchApplication() {
		driver = Browser.LaunchApplication();
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
        
		Assert.assertEquals(productNameOnHomePage, productNameOnQuickView);
	}
		
		@Test
		public void verifyProductDetailsAreCorrectlyViewUsingProductDetailPage() {
			 test = reports.createTest("verifyAddProductToCartUsingProductDetailPage");
			 
			NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
			naaptolhomepage.enterProductToSearch("mobile");
			naaptolhomepage.clickOnSearch();
			
			String productNameOnHomePage = naaptolhomepage.getProductNameFromHomePage(1);
			
			NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
			naaptolproductdetailpage.selectDesiredProduct(1);
			switchToChildBrowser();
			
			String ProductNameOnProductDetailPage = naaptolproductdetailpage.getProductDetailPageProductName();
			
			Assert.assertEquals(productNameOnHomePage, ProductNameOnProductDetailPage);
			
			
		}
		@AfterMethod
		public void closeBrowser()
		{
			driver.close();
		}
		
		
	
}	

