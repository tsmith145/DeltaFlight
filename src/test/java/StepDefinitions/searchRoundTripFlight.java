package StepDefinitions;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BookFlightLandingPage;
import pagefactory.BookFlightResultsPage;

public class searchRoundTripFlight {
	
	
	
	 WebDriver driver;
	BookFlightLandingPage bookFlight;
	private	 ChromeOptions options = new ChromeOptions();
    private SoftAssert softAssert = new SoftAssert();
    BookFlightResultsPage flightResult;
    
    TakesScreenshot screenShot;

	

	
	
 
	
	@Before
	public void setupDriver(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mjrlo/Downloads/newLocation/deltaChrome/chromedriver.exe");
		
		  options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  driver = new ChromeDriver(options);
		  bookFlight = new BookFlightLandingPage(driver);
		  flightResult= new BookFlightResultsPage(driver);
	}
	
	
	@Given("I am on Delta.com")
	public void i_am_on_delta_com() {
		
		
		
        bookFlight.gotoDeltaWebsite();
        bookFlight.acceptPopup();
	  
	}

	@When("I select the round trip button")
	public void i_select_the_round_trip_button() {
	 
		bookFlight.selectRoundTrip();
		
	}

	@And("I select my arriving city")
	public void i_select_my_arriving_city() {
		bookFlight.ChooseDestination();
	}

	@And("I select my departing and arriving dates")
	public void i_select_my_departing_and_arriving_dates() {
	   bookFlight.chooseDates();
	}

	@And("I hit the search button")
	public void i_hit_the_search_button() {
	
		bookFlight.submitSearch();
	}

	@Then("I should be on the Flight Results Page")
	public void i_should_be_on_the_flight_results_page() {
		
		String expectedTitle="Flight Results : Find & Book Airline Tickets : Delta Air Lines";
	  softAssert.assertEquals(flightResult.getWebsiteTitle(), expectedTitle);
		/*
		 * if(!flightResult.getWebsiteTitle().equals(expectedTitle)) { }
		 */
	}

	@And("I should see the words round trip in the items list for each flight grid item")
	public void i_should_see_the_words_round_trip_in_the_items_list_for_each_flight_grid_item() {
	    softAssert.assertTrue(flightResult.isSearchPageRoundtrip());
	}
	
	
	@After 
	public void tearDown() {
		softAssert.assertAll();
		
	}


}
