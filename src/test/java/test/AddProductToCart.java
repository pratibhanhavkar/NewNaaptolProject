package test;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
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
	@Parameters({"browser"})
	@BeforeMethod
	public void launchApplication(String browser) {
		driver = Browser.LaunchApplication(browser);
					}
	
	
	@Test
	public void verifyAddProductToCartUsingQuickView() {
		test = reports.createTest("verifyAddProductToCartUsingQuickView");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("mobile");
		naaptolHomePage.clickOnSearch();
		
		NaaptolProductDetailQuickView naaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		naaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 1);
		naaptolProductDetailQuickView.clickOnQuickView(1);
		
		NaaptolProductDetailPage naaptolProductDetailPage = new NaaptolProductDetailPage(driver);
		
		String  productNameOnQuickView = naaptolProductDetailPage.getProductDetailPageProductName();
		
	    naaptolProductDetailPage.selectTheColour();
	    naaptolProductDetailPage.enterPinCode();
	    naaptolProductDetailPage.clickHereToBuy();

	    NaaptolCartPage  naaptolCartPage = new NaaptolCartPage(driver);
		    
		String cartProductName= naaptolCartPage.getCartProductName();
		
		Assert.assertEquals( productNameOnQuickView , cartProductName);
			
		naaptolCartPage.clickOnProceedToCheckOut();
			
		
	}
	@Test
	public void verifyAddproductToCartUsingProductDetailPage() {
		test = reports.createTest("verifyAddproductToCartUsingProductDetailPage");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("mobile");
		naaptolHomePage.clickOnSearch();
		
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
		
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("mobile");
		naaptolHomePage.clickOnSearch();
		
		NaaptolProductDetailQuickView naaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		naaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 1);
		naaptolProductDetailQuickView.clickOnQuickView(1);
		
		NaaptolProductDetailPage naaptolProductDetailPage = new NaaptolProductDetailPage(driver);
		
		naaptolProductDetailPage.selectTheColour();
		naaptolProductDetailPage.enterPinCode();
		naaptolProductDetailPage.clickHereToBuy();
		naaptolProductDetailPage.clickOnContinueShopping();
		naaptolProductDetailPage.clickOnCrossButton();
		
		 
	    naaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 2);
		naaptolProductDetailQuickView.clickOnQuickView(2);
		naaptolProductDetailPage.clickHereToBuy();
		
		
		
	}
	@Test
	public void verifyRemoveAproductFromCartList() {
		test = reports.createTest("verifyRemoveAproductFromCartList");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("mobile");
		naaptolHomePage.clickOnSearch();
		
		NaaptolProductDetailPage naaptolProductDetailPage = new NaaptolProductDetailPage(driver);
		naaptolProductDetailPage.selectDesiredProduct(1);
		switchToChildBrowser();
		naaptolProductDetailPage.selectTheColour();
		naaptolProductDetailPage.enterPinCode();
		naaptolProductDetailPage.clickHereToBuy();

		NaaptolCartPage  naaptolCartPage = new NaaptolCartPage(driver);
		naaptolCartPage.verifyRemoveProductFromCart();
		
	}
	
	@Test
	public void verifyRemoveMultipleProductFromCartList() throws InterruptedException {
		test = reports.createTest("verifyRemoveMultipleProductFromCartList");
		NaaptolHomePage naaptolHomePage = new NaaptolHomePage(driver);
		naaptolHomePage.enterProductToSearch("mobile");
		naaptolHomePage.clickOnSearch();
		
		NaaptolProductDetailQuickView naaptolProductDetailQuickView = new NaaptolProductDetailQuickView(driver);
		naaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 1);
		naaptolProductDetailQuickView.clickOnQuickView(1);
		
		NaaptolProductDetailPage naaptolProductDetailPage = new NaaptolProductDetailPage(driver);
		
		naaptolProductDetailPage.selectTheColour();
		naaptolProductDetailPage.enterPinCode();
		naaptolProductDetailPage.clickHereToBuy();
		naaptolProductDetailPage.clickOnContinueShopping();
		naaptolProductDetailPage.clickOnCrossButton();
		
		 
	    naaptolProductDetailQuickView.moveToQuickviewOnDesiredProduct(driver, 2);
		naaptolProductDetailQuickView.clickOnQuickView(2);
		naaptolProductDetailPage.clickHereToBuy();
		
		NaaptolCartPage  naaptolCartPage = new NaaptolCartPage(driver);
		Thread.sleep(5000);
		naaptolCartPage.verifyRemoveProductFromCart();
		
		
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	

	}


