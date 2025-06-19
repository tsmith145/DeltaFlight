package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.BookFlightLandingPage;

public class searchRoundTripFlight {
	
	
	
	 WebDriver driver;
	BookFlightLandingPage bookFlight;
	private	 ChromeOptions options = new ChromeOptions();
	

	
	
 
	
	@Before
	public void setupDriver(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Mjrlo/Downloads/newLocation/deltaChrome/chromedriver.exe");
		
		  options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  driver = new ChromeDriver(options);
		  bookFlight = new BookFlightLandingPage(driver);
	}
	
	
	@Given("I am on Delta.com")
	public void i_am_on_delta_com() {
		
        bookFlight.gotoDeltaWebsite();
	  
	}

	@When("I select the round trip button")
	public void i_select_the_round_trip_button() {
	 
		
		
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
	
	}

	@Then("I should see My departing and arriving city in the top left div")
	public void i_should_see_my_departing_and_arriving_city_in_the_top_left_div() {
	  
	}

	@And("I should see the words round trip in the items list for each flight grid item")
	public void i_should_see_the_words_round_trip_in_the_items_list_for_each_flight_grid_item() {
	    
	}


}
