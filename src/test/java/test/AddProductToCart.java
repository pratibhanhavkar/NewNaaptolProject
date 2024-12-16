package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaaptolCartPage;
import pom.NaaptolHomePage;
import pom.NaaptolProductDetailPage;
import pom.NaaptolProductDetailQuickView;
import utility.Reports;

public class AddProductToCart extends BaseTest{
	 @BeforeTest
	   public void configureReports() {
		  reports = Reports.createReport();
	   }
	@BeforeMethod
	public void launchApplication() {
		driver = Browser.LaunchApplication();
					}
	
	
	@Test
	public void verifyAddProductToCartUsingQuickView() {
		test = reports.createTest("verifyAddProductToCartUsingQuickView");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.enterProductToSearch("mobile");
		naaptolhomepage.clickOnSearch();
		
		NaaptolProductDetailQuickView naaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		naaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 1);
		naaptolProductDetailQuickView.clickOnQuickView(1);
		
		NaaptolProductDetailPage naaptolProductDetailPage = new NaaptolProductDetailPage(driver);
		
		String ProductDetailProductName = naaptolProductDetailPage.getProductDetailPageProductName();
		
	    naaptolProductDetailPage.selectTheColour();
	    naaptolProductDetailPage.enterPinCode();
	    naaptolProductDetailPage.clickHereToBuy();

	    NaaptolCartPage  NaaptolCartPage = new NaaptolCartPage(driver);
		    
		String CartProductName= NaaptolCartPage.getCartProductName();
		Assert.assertEquals( ProductDetailProductName , CartProductName);
			
		NaaptolCartPage.clickOnProceedToCheckOut();
			
		
	}
	@Test
	public void verifyAddproductToCartUsingProductDetailPage() {
		test = reports.createTest("verifyAddproductToCartUsingProductDetailPage");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.enterProductToSearch("mobile");
		naaptolhomepage.clickOnSearch();
		
		NaaptolProductDetailPage naaptolProductDetailPage = new NaaptolProductDetailPage(driver);
		naaptolProductDetailPage.selectDesiredProduct(1);
		switchToChildBrowser();
		
		String productDetailProductName = naaptolProductDetailPage.getProductDetailPageProductName();
		
		naaptolProductDetailPage.selectTheColour();
		naaptolProductDetailPage.enterPinCode();
		naaptolProductDetailPage.clickHereToBuy();
		
	    NaaptolCartPage  naaptolCartPage = new NaaptolCartPage(driver);
	    
		String cartProductName= naaptolCartPage.getCartProductName();
		Assert.assertEquals( productDetailProductName , cartProductName);
		
		naaptolCartPage.clickOnProceedToCheckOut();
		
		
		}
	@Test
	public void verifyAddingMultipleProductToCart() {
	    test = reports.createTest("verifyAddingMultipleProductToCart");
		
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.enterProductToSearch("mobile");
		naaptolhomepage.clickOnSearch();
		
		NaaptolProductDetailQuickView NaaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		NaaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 1);
		NaaptolProductDetailQuickView.clickOnQuickView(1);
		
		NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
		
		naaptolproductdetailpage.selectTheColour();
		naaptolproductdetailpage.enterPinCode();
		naaptolproductdetailpage.clickHereToBuy();
		naaptolproductdetailpage.clickOnContinueShopping();
		naaptolproductdetailpage.clickOnCrossButton();
		
		 
	    NaaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 2);
		NaaptolProductDetailQuickView.clickOnQuickView(2);
		naaptolproductdetailpage.clickHereToBuy();
		
		
		
	}
	@Test
	public void verifyRemoveAproductFromCartList() {
		test = reports.createTest("verifyRemoveAproductFromCartList");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.enterProductToSearch("mobile");
		naaptolhomepage.clickOnSearch();
		
		NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
		naaptolproductdetailpage.selectDesiredProduct(1);
		switchToChildBrowser();
		naaptolproductdetailpage.selectTheColour();
		naaptolproductdetailpage.enterPinCode();
		naaptolproductdetailpage.clickHereToBuy();

		NaaptolCartPage  NaaptolCartPage = new NaaptolCartPage(driver);
		NaaptolCartPage.verifyRemoveProductFromCart();
		
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	

	}


