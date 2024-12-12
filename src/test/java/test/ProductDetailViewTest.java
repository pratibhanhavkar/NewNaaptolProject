package test;

import org.testng.Assert;
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
	@BeforeTest
	public void lunchApplication() {
		driver = Browser.LunchApplication();
					}
	@Test
	
	public void VerifyIfProdutDetailsAreCorrectIfViewInQuickView() {
        test = reports.createTest("VerifyIfProdutDetailsAreCorrectIfViewInQuickView");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.EnterProductToSearch("mobile");
		naaptolhomepage.ClickOnSearch();
		String name = naaptolhomepage.getProductNameFromHomePage(2);
		
		NaaptolProductDetailQuickView NaaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		NaaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 2);
		NaaptolProductDetailQuickView.ClickOnQuickView(2);
	
		String productname = NaaptolProductDetailQuickView.getProductNameOnQuickView();
        
		Assert.assertEquals(name, productname);
	}
		
		@Test
		public void VerifyProductDetailAreCorrectlyViewUsingProductDetailPage() {
			 test = reports.createTest("VerifyAddProductToCartUsingProductDetailPage");
			NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
			naaptolhomepage.EnterProductToSearch("mobile");
			naaptolhomepage.ClickOnSearch();
			String name = naaptolhomepage.getProductNameFromHomePage(2);
			NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
			naaptolproductdetailpage.selectdesiredProduct(2);
			switchToChildBrowser();
			
			String ProductName = naaptolproductdetailpage.getproductDetailPageProductName();
			Assert.assertEquals(name, ProductName);
			
			
		}
		
	
}	

