package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pagefactory.BookFlightLandingPage;
import pagefactory.LoginPageNCS;


import org.testng.asserts.SoftAssert;


public class LoginPageNCSstepDefinitions {
	

	 WebDriver driver;
	LoginPageNCS loginPage;
	private	 ChromeOptions options = new ChromeOptions();
    SoftAssert softAssert = new SoftAssert();
 
	

	
	

	
	@Before
	public void setupDriver(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mjrlo/Downloads/newLocation/deltaChrome/chromedriver.exe");
		
		  options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  driver = new ChromeDriver(options);
		  loginPage = new LoginPageNCS(driver);
		  
		  
		
	}
	
	
	@Given("I am on the login webpage")
	public void i_am_on_the_login_webpage() {

		loginPage.gotoTestPage();
	}

	@And("I enter an invalid username")
	public void i_enter_an_invalid_username() {
	  loginPage.inValidUsername();
	}

	@And("I enter a valid password")
	public void i_enter_a_valid_password() {

		loginPage.validPassword();
	}

	@And("I hit the submit button")
	public void i_hit_the_submit_button() {
		 
	  loginPage.hitSubmitButton();
	}

	@Then("I should get an invalid username error")
	public void i_should_get_an_invalid_username_error() {
       softAssert.assertTrue(loginPage.isUsernameErrorValid());
       
       
	
	}

	@And("I should remain on the login page an not the profile page")
	public void i_should_remain_on_the_login_page_an_not_the_profile_page() {
	  
	}

}
