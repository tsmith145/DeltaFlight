package pagefactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookFlightResultsPage {
	
	 private WebDriver driver;
	 
	 

	 
	 
		
		

		
   @FindBy(id="flight-results-grid-0")
   private WebElement flightGridView;
	
	public BookFlightResultsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public String getWebsiteTitle() {
		String websiteTitle = driver.getTitle();
		
		return websiteTitle;
	}
	
	public boolean isSearchPageRoundtrip() {
		List<WebElement> elements = driver.findElements(By.id("div")); // Example using tagName, replace with your desired locator

		boolean isRoundTrip=false;
		for (WebElement div: elements) {
			if (div.getText().contains("Round Trip")) {
				isRoundTrip= true;
			}
			
			
			
		}
		return isRoundTrip;
	}
	
	
}
