package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolProductDetailPage {

   	@FindBy (xpath="//div[@class='grid_Square ']")private List<WebElement> products;
    @FindBy (xpath="//a[@class='red_button icon chat']")private WebElement clickHereToBuy;
    //@FindBy (xpath="//div[@id='pincodeForDeliveryDiv_provide_0']//input[@placeholder='Enter Pincode']")private WebElement pinCode;
    @FindBy (xpath="//input[@placeholder='Enter Pincode']")private WebElement pinCode;
    @FindBy (xpath="(//input[@placeholder='Enter mobile number'])[2]")private WebElement mobileNumber;
    @FindBy (xpath="(//input[@class='btn-login btn-blueBg'])[3]")private WebElement continueButton;
    @FindBy (xpath = "//a[text()='Gold']")private WebElement selectColour;
    @FindBy (xpath ="//h1[text()='Dual Sim Foldable Flip Mobile With Camera - Gamma (M2 Mini)']")private WebElement productName;
	@FindBy (xpath = "(//span[@class='offer-price'])[2]")private List<WebElement> productPrice;
    @FindBy (xpath="//button[@class='fancybox-button fancybox-close-small']")private WebElement crossButton;
	@FindBy (xpath="(//a[@class='link_Continue'])[1]")private WebElement continueShopping;
	 
	public NaaptolProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void moveToDesiredProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index));
		actions.perform();
	}
	 
	public void selectDesiredProduct(int index) {
		products.get(index).click();
	}
	public String getProductDetailPageProductName() {
		return productName.getText();
	}
	
	public String getProductPrice(int index) {
		return productPrice.get(index).getText();
	}
	
	public void selectTheColour() {
		selectColour.click();
	}
	public void clickHereToBuy() {
		clickHereToBuy.click();
	}
	public void enterPinCode() {
		pinCode.sendKeys("443001");
	}
	
	public void enterMobileNumber() {
		mobileNumber.sendKeys("9850996016");
	}
	public void clickOnCrossButton() {
		crossButton.click();
	}
	public void clickOnContinueShopping() {
		 continueShopping.click();
	}
	
}


