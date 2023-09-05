package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BookRoomBookingPage_PF;
import pagefactory.BookRoomLoginPage_PF;
import pagefactory.HotelRoom;

public class BookRoom {
 public	WebDriver driver;
	public WebDriver driver1 = null;
	private BookRoomLoginPage_PF bookRoomLoginPage_PF;
	 BookRoomBookingPage_PF bookRoomBookingPage_PF;
	 private	 ChromeOptions options = new ChromeOptions();
	 HotelRoom hotelRoom;
	 
	 String originalWindow=" ";

	/*
	 * //Scenario 1
	 * 
	 * @Given("I am on the login") public void i_am_on_the_login() { ChromeOptions
	 * options = new ChromeOptions();
	 * options.addArguments("--remote-allow-origins=*");
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:/Users/Mjrlo/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe"
	 * ); driver = new ChromeDriver(options); bookRoomLoginPage_PF= new
	 * BookRoomLoginPage_PF(driver);
	 * 
	 * 
	 * 
	 * ChromeOptions options1 = new ChromeOptions();
	 * options1.addArguments("--remote-allow-origins=*");
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:/Users/Mjrlo/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe"
	 * ); driver1 = new ChromeDriver(options1);
	 * 
	 * 
	 * bookRoomLoginPage_PF.gotWebSite(); }
	 * 
	 * @When("^user enters (.*) and (.*)$") public void
	 * user_enters_username_and_password(String username, String password) {
	 * 
	 * 
	 * bookRoomLoginPage_PF.enterUserNameAndPassword(username, password);
	 * 
	 * }
	 * 
	 * @Then("I should be on the booking page") public void
	 * i_should_be_on_the_booking_page() {
	 * 
	 * 
	 * 
	 * bookRoomBookingPage_PF = new BookRoomBookingPage_PF(driver);
	 * 
	 * bookRoomBookingPage_PF.validateUserReachedBooking();
	 * 
	 * }
	 */

	// scenario 2

	@Given("I am on the booking page")
	public void i_am_on_the_booking_page() {
	
		 options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		 System.setProperty("webdriver.chrome.driver", "C:/Users/Mjrlo/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		 
		 driver = new ChromeDriver(options);
		// originalWindow = driver.getWindowHandle();
		 bookRoomLoginPage_PF= new BookRoomLoginPage_PF(driver);
		 
		 bookRoomLoginPage_PF.gotWebSite();
		 bookRoomLoginPage_PF.enterUserNameAndPassword("admin", "password");
		 
		 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.navigate().to("https://automationintesting.online/#/admin");
		

         
	}

	@When("I select the setting")
	public void i_select_the_setting() {
		
		
		
		driver.findElement(By.id("wifiCheckbox")).click();
	}

	@And("I select the room type")
	public void i_select_the_room_type() {
	//	bookRoomBookingPage_PF.selectRoomType();
		WebElement roomTypeDropDown = driver.findElement(By.id("type"));
		Select selectRoomType = new Select(roomTypeDropDown);
		selectRoomType.selectByVisibleText("Family");

	}

	@And("I set Accessible to true")
	public void i_set_accessible_to_true() {

		//bookRoomBookingPage_PF.setRoomAccessibility();
		WebElement accessibleTrueFalse = driver.findElement(By.id("accessible"));
		Select selectRoomAccessibility = new Select(accessibleTrueFalse);
		selectRoomAccessibility.selectByVisibleText("true");

	}

	@And("I enter (.*) and (.*)$")
	public void i_enter_and(String roomNumber, String price) {

		//bookRoomBookingPage_PF.enterRoomNumber(roomNumber);

		//bookRoomBookingPage_PF.enterRoomPrice(price);
		
		driver.findElement(By.id("roomPrice")).sendKeys(price);
		driver.findElement(By.id("roomName")).sendKeys(roomNumber);
		
		int rn=Integer.parseInt(roomNumber);
		int rp=Integer.parseInt(price);
		
		hotelRoom= new HotelRoom(roomNumber,price);
	}

	@And("I hit create")
	public void i_hit_create() {
		
		driver.findElement(By.id("createRoom")).click();
		//bookRoomBookingPage_PF.createRoom();
	}
	
	@Then("booking is listed")
	public void booking_is_listed() {
		//checks if booking is in the list 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement roomTable = driver.findElement(By.className("row.detail"));
		Select selectRoomNumber = new Select(roomTable);
		
		List<WebElement>dynamicDiv=driver.findElements(By.xpath("//div//div//div//div//div//div[@class='row.detail']"));
		
		
		for(WebElement div:dynamicDiv) {
			
			if(div.getText().equals(hotelRoom.getHotelRoomNumber().toString())) {
				System.out.print("your booking is listed");
			}
			
		}
	
		//Assert.assertTrue(!driver.findElement(By.xpath("//div[@id='alert alert-danger']")).isDisplayed());
		
		
		
	
	}
	
	

}
