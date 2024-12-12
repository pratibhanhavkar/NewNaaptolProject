package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolHomePage {
	
	@FindBy (xpath ="//div[@class='grid_Square ']") private List<WebElement> productList;  //12product
	@FindBy (xpath="//input[@id='header_search_text']")private WebElement searchfield;
	@FindBy (xpath ="(//div[@class='search']//a)[2]") private WebElement search;
    @FindBy (xpath="//div[@class='errorMsg']")private WebElement errormsg;
    @FindBy (xpath="//div[@class='item_title']")private List<WebElement> ProductName;
   // @FindBy (xpath = "//a[text()='Dual Sim Foldable Flip Mobile With Camera - Gamma (M2 Mini)']")private WebElement ProductName;
	@FindBy (xpath = "(//span[@class='offer-price'])[2]")private WebElement ProductPriceOnHomePage;
	//Additional Xpath
	@FindBy (xpath="//a[@id='login-panel-link']")private WebElement login;
	@FindBy (xpath="//a[text()='Track Order']")private WebElement trackorder;
    @FindBy (xpath="//select[@id='localization_dropdown']")private List<WebElement> language;
    @FindBy (xpath="//span[@class='mobApp-Icon']")private WebElement downloadapp;
    @FindBy (xpath="//span[@class='cartIcon']")private WebElement carticon;
  
    
    public NaaptolHomePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
	}
	
    public void ClickOnSearch() {
    	search.click();
    }
    public void EnterProductToSearch(String product) {
    	searchfield.sendKeys(product);
    }
    public void clickOnLogin() {
    	login.click();
    }
    public void ClickOnTrackOrder() {
    	trackorder.click();
    }
 
	public int getNumberOfProductDisplayed() {
	
		return productList.size();
	}
	
	public String getErrorMessage() {
		return errormsg.getText();
	
	}
	public String getProductNameFromHomePage(int index) {
		return ProductName.get(index).getText();
	}
	//public String getProductPriceOnHomePage(int index) {
	//	return ProductPriceOnHomePage.getText();
	//}
	
}
