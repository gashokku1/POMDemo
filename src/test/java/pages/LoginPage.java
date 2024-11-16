package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="user-name")
	WebElement uName;
	@FindBy(id="password")
	WebElement pw;
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	public void validLogin(String uName, String pwd) {
		this.uName.sendKeys(uName);
		pw.sendKeys(pwd);
		loginBtn.click();
	}

}
