package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage {
	
	@FindBy(css="div.cart_item")
	WebElement cartList;
	@FindAll(value= @FindBy(css ="div.cart_item"))
	List<WebElement> items;
	@FindBy(id="remove-sauce-labs-backpack")
	WebElement rmvBtn;
	@FindBy (css = "button[data-test='continue-shopping']")
	WebElement contBtn;
	@FindBy(css = "button[data-test='checkout']")
	WebElement chkOutBtn;
	
	public CartPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean  isItemAdded() {
		return cartList.isDisplayed();
	}
	
	public void checkoutItems() {
		Actions act = new Actions(TestBase.getDriver());
		act.moveToElement(chkOutBtn);
		//JavascriptExecutor
		chkOutBtn.click();
	}
	

}
