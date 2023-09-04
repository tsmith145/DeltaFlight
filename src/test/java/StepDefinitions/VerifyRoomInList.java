package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BookRoomBookingPage_PF;
import pagefactory.BookRoomLoginPage_PF;

public class VerifyRoomInList {
	
	public	WebDriver driver;
	public WebDriver driver1 = null;
	private BookRoomLoginPage_PF bookRoomLoginPage_PF;
	 BookRoomBookingPage_PF bookRoomBookingPage_PF;
	 private ChromeOptions options = new ChromeOptions();
	
	
	 @Before
	    public void setUp() {
		 
		 options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		 System.setProperty("webdriver.chrome.driver", "C:/Users/Mjrlo/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		 
		 driver = new ChromeDriver(options);
		// originalWindow = driver.getWindowHandle();
		 bookRoomLoginPage_PF= new BookRoomLoginPage_PF(driver);
		 
		 bookRoomLoginPage_PF.gotWebSite();
		 bookRoomLoginPage_PF.enterUserNameAndPassword("admin", "password");
		 
		 WebDriverWait wdw = new WebDriverWait(driver, 30);
		 
		  String roomNumberVariable=" ";
		  String roomPriceVariable=" ";
	      
	    }
	
	
	@Given("I navigated to the book page")
	public void i_navigated_to_the_book_page() {
		
	}

	@When("I choose settings")
	public void i_choose_settings() {
		driver.findElement(By.id("wifiCheckbox")).click();
		
		
	}

	@And("I choose the room")
	public void i_choose_the_room() {
		WebElement roomTypeDropDown = driver.findElement(By.id("type"));
		Select selectRoomType = new Select(roomTypeDropDown);
		selectRoomType.selectByVisibleText("Family");
	}

	@And("I make it accessible")
	public void i_make_it_accessible() {
		WebElement accessibleTrueFalse = driver.findElement(By.id("accessible"));
		Select selectRoomAccessibility = new Select(accessibleTrueFalse);
		selectRoomAccessibility.selectByVisibleText("true");
	}

	@And("I choose (.*)$ and (.*)$")
	public void i_choose_room_number_and_room_price(String roomNumber, String price) {
		
		driver.findElement(By.id("roomPrice")).sendKeys(price);
		driver.findElement(By.id("roomName")).sendKeys(roomNumber);
	   
	}

	@And("I submit the booking")
	public void i_submit_the_booking() {
		
		
	 
	}

	@Then("my booking should be listed")
	public void my_booking_should_be_listed() {
	   driver.findElement(By.id("frontPageLink")).click();
	   
	}

}
