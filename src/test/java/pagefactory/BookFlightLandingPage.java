package pagefactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;


public class BookFlightLandingPage {

	 private WebDriver driver;
		
		

	
	@FindBy(xpath="//span[normalize-space()='To']")
    private WebElement _arrivalCityButton;

    @FindBy(xpath="//span[normalize-space()='ATL']")
    private WebElement _departureCityButton;

    @FindBy(xpath="//div[@class='airport-lookup-tablist-container pl-0 pr-0 mt-2']")
    private WebElement _destinationAlertBox;

    @FindBy(id="search_input")
    private  WebElement _destinationTextArea;
    
    ////div[@class='tab-content']//li[2]
    @FindBy(xpath="//div[@class='tab-content']//li[2]")
    private WebElement _citySelectionValue;
	
  @FindBy(css=".search-flyout-close")
    private WebElement _closeDestinationTextAreaButton;
	//
	
	//Select selectRoomAccessibility = new Select(accessibleTrueFalse);
		
	public BookFlightLandingPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
			
		}
	
	public BookFlightLandingPage() {
		
		
	}
	
	public void gotoDeltaWebsite() {
		driver.navigate().to("https://www.delta.com/");
	}
	
	
	public void ChooseDestination()
    {
		/*
		 * _arrivalCityButton.click();
		 * 
		 * 
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_input"
		 * )));
		 * 
		 * driver.manage().window().setSize(new Dimension(1024, 768));
		 * 
		 * _destinationTextArea.sendKeys("HOU");
		 * _closeDestinationTextAreaButton.click();
		 */
		   Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		// the destination city 
	    driver.findElement(By.xpath("//span[normalize-space()='To']")).click();

	    driver.manage().window().setSize(new Dimension(1024, 768));
	    
	// destination city text Alert box
	    driver.findElement(By.id("search_input")).sendKeys("NYC");
	    
	  
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_input")));

	///close the arriving city alert box (the x button)
	    driver.findElement(By.cssSelector(".search-flyout-close")).click();

    }
	
	
	
	public void chooseDates () {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		   driver.findElement(By.cssSelector(".calDateSeparator")).click();

		// the date July 21st
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='19 July 2025, Saturday']")));
		    driver.findElement(By.xpath("//a[@aria-label='19 July 2025, Saturday']")).click();

		// the date July 25st
		  //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("25")));
		    
		    driver.manage().window().maximize();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='25 July 2025, Friday']")));
		    driver.findElement(By.xpath("//a[@aria-label='25 July 2025, Friday']")).click();
		    
		  //button[@value='done']
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@value='done']")));
		    driver.findElement(By.xpath("//button[@value='done']")).click();
		  //  driver.findElement(By.cssSelector(".donebutton")).click();
		  //  driver.findElement(By.id("btn-book-submit")).click();
	}
	
	
	
	

}
