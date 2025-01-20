package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolCartPage {
	@FindBy (xpath = "//ul[@id='cartData']") private List<WebElement> products;
	@FindBy (xpath = "//div[@class='cart_info']//h2") private List<WebElement> productName;
	@FindBy (xpath = "//li[@class='head_UPrice']") private List<WebElement> productPrice;
	@FindBy (xpath = "//li[@class='head_ship']") private List<WebElement> shippingPrice;
	@FindBy (xpath = "//li[@class='head_Amount']") private List<WebElement> orderAmount;
    @FindBy (xpath="(//a[@class='red_button2'])[2]")private WebElement proceedToCheckout;
    @FindBy (xpath="//a[text()='Remove']")private WebElement removeProduct; 
    @FindBy (xpath="//a[text()='Dual Sim Foldable Flip Mobile With Camera - Gamma (M2 Mini)']")private WebElement cartProductName; 
    @FindBy (xpath="//li[text()='1,999']")private WebElement cartProductPrice; 
    @FindBy (xpath="//button[@class='fancybox-button fancybox-close-small']")private WebElement crossButton;
 

	
	public NaaptolCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getNumberOfProductsInCart() {
		return products.size();
	}
	
	public String getCartProductName() {
		return cartProductName.getText();
	}
	public void getCartProductPrice(){
		String text = cartProductPrice.getText();
		System.out.println(text);
		
	}	
	public void verifyRemoveProductFromCart() {
		removeProduct.click();
	}
	public void clickOnCrossButton() {
		crossButton.click();
	}
	public void clickOnProceedToCheckOut() {
		proceedToCheckout.click();
	}
}


