package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCategoiesPage {
	
	@FindBy (xpath="//span[text()='Shopping Categories']")private WebElement shoppingCategories;
	@FindBy (xpath="(//a[text()='Smartphones'])[1]")private WebElement smartPhones;
	@FindBy (xpath ="//div[@id='mainMenuContent']//ul//li[1]//a//span") private WebElement listOfItem;
	@FindBy (xpath = "(//a[@class='current'])[1]")private WebElement mobiles;
	public ShoppingCategoiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	 public void clickonshoppingcategories(WebDriver driver) {
	    	Actions actions = new Actions(driver);
			actions.moveToElement(shoppingCategories);
			actions.perform();
	       shoppingCategories.isDisplayed();
	    }
	 public void moveToMobiles(WebDriver driver) {
		 Actions act1 = new Actions(driver);
		 act1.moveToElement(mobiles);
	 }
	 
	 public void moveToSmartphones(WebDriver driver) {
		 Actions act2 = new Actions(driver);
		 act2.moveToElement(smartPhones);
	
	 }
	 public void clickOnSmartPhone() {
		 smartPhones.click();
	 }
	
}
