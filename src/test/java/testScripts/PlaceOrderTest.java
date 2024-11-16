package testScripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage productListPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
		productListPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}
	
	@BeforeTest
	public void setUp() {
		TestBase.openUrl("https://www.saucedemo.com/");
		loginPage.validLogin("standard_user", "secret_sauce");
	}
  @Test
  public void login() {
	//  loginPage.validLogin("standard_user", "secret_sauce");
  }
  @Test(priority = 1)
  public void addToCart() throws InterruptedException {
	  boolean title = productListPage.isOnProducts();
	  Assert.assertTrue(title);
	  productListPage.addTocart();
	  Thread.sleep(2000);
	  productListPage.validateCart();
	  Assert.assertTrue(cartPage.isItemAdded());
	  
  }
  @Test(priority = 2)
  public void checkOut() throws InterruptedException {
	  
	  cartPage.checkoutItems();
	  Thread.sleep(2000);
	  Assert.assertTrue(true);
	
}
  @Test(priority = 3)
  public void checkoutConfirmation() throws InterruptedException {
	  checkoutPage.validateTitle();
	  checkoutPage.checkoutInformation("Testname", "TestPassword", "123");
	  checkoutPage.finish();
	  checkoutPage.validateThanksMessage();
	
}
  
}
