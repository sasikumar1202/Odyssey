package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginApp {

	WebDriver driver;

	
	@Given("user should navigate to the application")
	public void userShouldNavigateToTheApplication() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\USER\\eclipse-workspace1\\Amazon\\driver folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://odyssey.in/");
	}

	@Given("user should login by providing {string} and {string}")
	public void userShouldLoginByProvidingAnd(String username, String password)  {
		
		driver.findElement(By.xpath("//a[@aria-controls='account-popover' and text()='My account ']")).click();
		driver.findElement(By.xpath("//input[@id='login-customer[email]']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='login-customer[password]']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit' and text()='Login']")).click();
		
	}

	@Given("user should search the {string}")
	public void userShouldSearchThe(String book)  {
		driver.findElement(By.xpath("//div[@class='search-bar__input-wrapper']")).click();
	    driver.findElement(By.xpath("//div[@class='search-bar__input-wrapper']/input")).sendKeys(book);
	    driver.findElement(By.xpath("//button[@class='search-bar__submit']")).click();
	    driver.findElement(By.xpath("//a[@class='product-item__title text--strong link']")).click();  
	}

	@When("user clicks the Add to cart button")
	public void userClicksTheAddToCartButton() {
	    driver.findElement(By.xpath("//button[@data-action='add-to-cart']")).click();
	   
	}

	@Then("user should check the cart item quantity")
	public void userShouldCheckTheCartItemQuantity() throws InterruptedException  {
	//   Thread.sleep(5000);
	   WebDriverWait w = new WebDriverWait(driver, 5);
	   w.until(ExpectedConditions.textToBe(By.xpath("//span[@class='header__cart-count']"), "1"));
	   String qty = driver.findElement(By.xpath("//span[@class='header__cart-count']")).getText();
	   Assert.assertEquals(Integer.parseInt(qty)>0, true);
	}
	
}
