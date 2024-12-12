package test;

import org.testng.Assert;
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
	public void lunchApplication() {
		driver = Browser.LunchApplication();
					}
	
	
	@Test
	public void verifyAddProductToCartUsingQuickView() {
		test = reports.createTest("verifyAddProductToCartUsingQuickView");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.EnterProductToSearch("mobile");
		naaptolhomepage.ClickOnSearch();
		
		NaaptolProductDetailQuickView NaaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		NaaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 2);
		NaaptolProductDetailQuickView.ClickOnQuickView(2);
		
		NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
		String ProductDetailProductName = naaptolproductdetailpage.getproductDetailPageProductName();
	    naaptolproductdetailpage.SelectTheColour();
	    naaptolproductdetailpage.EnterPinCode();
	    naaptolproductdetailpage.clickHereToBuy();

	    NaaptolCartPage  NaaptolCartPage = new NaaptolCartPage(driver);
		    
		String CartProductName= NaaptolCartPage.getcartProductName();
		Assert.assertEquals( ProductDetailProductName , CartProductName);
			
		NaaptolCartPage.ClickOnProceedToCheckOut();
			
		
	}
	@Test
	public void verifyAddproductToCartUsingProductDetailPage() {
		test = reports.createTest("verifyAddproductToCartUsingProductDetailPage");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.EnterProductToSearch("mobile");
		naaptolhomepage.ClickOnSearch();
		
		NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
		naaptolproductdetailpage.selectdesiredProduct(2);
		switchToChildBrowser();
		String ProductDetailProductName = naaptolproductdetailpage.getproductDetailPageProductName();
		naaptolproductdetailpage.SelectTheColour();
		naaptolproductdetailpage.EnterPinCode();
		naaptolproductdetailpage.clickHereToBuy();
		
	    NaaptolCartPage  NaaptolCartPage = new NaaptolCartPage(driver);
	    
		String CartProductName= NaaptolCartPage.getcartProductName();
		Assert.assertEquals( ProductDetailProductName , CartProductName);
		
		NaaptolCartPage.ClickOnProceedToCheckOut();
		
       //  Assert.assertEquals(NaaptolCartPage.getcartProductPrice(),productprice);
		
		}
	@Test
	public void verifyAddingMultipleProductToCart() {
		 test = reports.createTest("verifyAddingMultipleProductToCart");
		
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.EnterProductToSearch("mobile");
		naaptolhomepage.ClickOnSearch();
		
		NaaptolProductDetailQuickView NaaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		NaaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 2);
		NaaptolProductDetailQuickView.ClickOnQuickView(2);
		
		NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
		
		naaptolproductdetailpage.SelectTheColour();
		naaptolproductdetailpage.EnterPinCode();
		naaptolproductdetailpage.clickHereToBuy();
		naaptolproductdetailpage.ClickOnContinueShopping();
		naaptolproductdetailpage.ClickOnCrossButton();
		
		 
	    NaaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 3);
		NaaptolProductDetailQuickView.ClickOnQuickView(3);
		naaptolproductdetailpage.clickHereToBuy();
		//NaaptolCartPage  NaaptolCartPage = new NaaptolCartPage(driver);
		//NaaptolCartPage.ClickOnProceedToCheckOut();
		
		
	}
	@Test
	public void VerifyRemoveAproductFromCartList() {
		 test = reports.createTest("VerifyRemoveAproductFromCartList");
		NaaptolHomePage naaptolhomepage = new NaaptolHomePage(driver);
		naaptolhomepage.EnterProductToSearch("mobile");
		naaptolhomepage.ClickOnSearch();
		
		NaaptolProductDetailPage naaptolproductdetailpage = new NaaptolProductDetailPage(driver);
		naaptolproductdetailpage.selectdesiredProduct(2);
		switchToChildBrowser();
		naaptolproductdetailpage.SelectTheColour();
		naaptolproductdetailpage.EnterPinCode();
		naaptolproductdetailpage.clickHereToBuy();

		NaaptolCartPage  NaaptolCartPage = new NaaptolCartPage(driver);
		NaaptolCartPage.verifyRemoveProductFromCart();
		
	}
	

	}


