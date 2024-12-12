package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolProductDetailPage {

   	@FindBy (xpath="//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy (xpath = "(//span[@class='offer-price'])[2]")private List<WebElement> productprice;
    @FindBy (xpath="//a[@class='red_button icon chat']")private WebElement clickheretobuy;
    @FindBy (xpath="//div[@id='pincodeForDeliveryDiv_provide_0']//input[@placeholder='Enter Pincode']")private WebElement pincode;
    @FindBy (xpath="(//input[@placeholder='Enter mobile number'])[2]")private WebElement mobilenumber;
    @FindBy (xpath="(//input[@class='btn-login btn-blueBg'])[3]")private WebElement continuebutton;
    @FindBy (xpath = "//a[text()='Gold']")private WebElement selectcolour;
    @FindBy (xpath ="//h1[text()='Dual Sim Foldable Flip Mobile With Camera - Gamma (M2 Mini)']")private WebElement ProductName;
    @FindBy (xpath="//button[@class='fancybox-button fancybox-close-small']")private WebElement CrossButton;
	@FindBy (xpath="(//a[@class='link_Continue'])[1]")private WebElement ContinueShopping;
	 
	public NaaptolProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void moveToDesiredProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index));
		actions.perform();
	}
	 
	public void selectdesiredProduct(int index) {
		products.get(index).click();
	}
	public String getproductDetailPageProductName() {
		return ProductName.getText();
	}
	
	public String getProductPrice(int index) {
		return productprice.get(index).getText();
	}
	
	public void SelectTheColour() {
		selectcolour.click();
	}
	public void clickHereToBuy() {
		clickheretobuy.click();
	}
	public void EnterPinCode() {
		pincode.sendKeys("443001");
	}
	
	public void EnterMobileNumber() {
		mobilenumber.sendKeys("9850996016");
	}
	public void ClickOnCrossButton() {
		CrossButton.click();
	}
	public void ClickOnContinueShopping() {
		 ContinueShopping.click();
	}
	
}


