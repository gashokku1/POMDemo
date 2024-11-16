package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy(id="first-name")
	WebElement firstName;
	@FindBy(id="last-name")
	WebElement lastName;
	@FindBy(id="postal-code")
	WebElement postalCode;
	@FindBy (xpath = "//*[@id='continue']")
	WebElement continueBtn;
	@FindBy(id="finish")
	WebElement finishBtn;
	
	@FindBy (xpath = "(//*[text()='Swag Labs'])[1]")
	WebElement title;
	@FindBy (xpath = "//*[text()='Thank you for your order!']")
	WebElement thanksBtn;
	
	public CheckoutPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void checkoutInformation(String fName, String lName, String code) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		postalCode.sendKeys(code);
		continueBtn.click();
		
	}
	public void finish() {
		finishBtn.click();
	}
	
	public boolean validateTitle() {
		return title.isDisplayed();
	}
	
	public boolean validateThanksMessage() {
		return thanksBtn.isDisplayed();
	}
	
	

}
