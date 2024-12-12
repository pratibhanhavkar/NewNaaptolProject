package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolProductDetailQuickView {
	@FindBy (xpath="//div[@class='grid_Square ']")private List<WebElement> products;
	@FindBy (xpath="//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement> productquickview;
    @FindBy (xpath="//div[@id='square_Details']//h1")private WebElement productnameonquickview;
	@FindBy (xpath="//div[@id='square_Details']//span[@class=\"offer-price\"]")private WebElement productPriceOnQuickView;
	
	
	public NaaptolProductDetailQuickView(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void moveToQuickviewOnDesiredProduct(WebDriver driver, int index) {
		Actions actions = new Actions(driver);
		actions.moveToElement(products.get(index));
		actions.perform();
	}
	
	public void ClickOnQuickView(int index) {
		  productquickview.get(index).click();
	}
	
	public String getProductNameOnQuickView() {
		return productnameonquickview.getText();
	}
	
	//public double getProductPriceOnQuickView(int index) {
	//	String [] p= productPriceOnQuickView.getText().split(" ");
	//	return Double.parseDouble(removeCommaFromString(p[0]));
	//}

	
}
