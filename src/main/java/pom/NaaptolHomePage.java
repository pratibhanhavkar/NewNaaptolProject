package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaaptolHomePage {
	
	@FindBy (xpath ="//div[@class='grid_Square ']") private List<WebElement> productList;  //12product
	@FindBy (xpath="//input[@id='header_search_text']")private WebElement searchField;
	@FindBy (xpath ="(//div[@class='search']//a)[2]") private WebElement search;
    @FindBy (xpath="//div[@class='errorMsg']")private WebElement errorMessage;
    @FindBy (xpath="//div[@class='item_title']")private List<WebElement> productName;
	@FindBy (xpath = "(//span[@class='offer-price'])[2]")private WebElement productPriceOnHomePage;
	@FindBy (xpath="//a[@id='login-panel-link']")private WebElement login;
	@FindBy (xpath="//a[text()='Track Order']")private WebElement trackOrderField;
    @FindBy (xpath="//select[@id='localization_dropdown']")private List<WebElement> languageField;
    @FindBy (xpath="//span[@class='mobApp-Icon']")private WebElement downloadAppField;
    @FindBy (xpath="//span[@class='cartIcon']")private WebElement cartIcon;
  
    
    public NaaptolHomePage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
	}
	
    public void clickOnSearch() {
    	search.click();
    }
    public void enterProductToSearch(String product) {
    	searchField.sendKeys(product);
    }
    public void clickOnLogin() {
    	login.click();
    }
    public void clickOnTrackOrder() {
    	trackOrderField.click();
    }
 
	public int getNumberOfProductDisplayed() {
	
		return productList.size();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	
	}
	public String getProductNameFromHomePage(int index) {
		return productName.get(index).getText();
	}
	
	
}
