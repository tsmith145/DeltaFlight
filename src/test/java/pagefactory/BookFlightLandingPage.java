package pagefactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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
  
  
  
  ////b[normalize-space()='Your username is invalid!']
  
  
  @FindBy(id="onetrust-accept-btn-handler")
  private WebElement _popUp;
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
		driver.manage().window().setSize(new Dimension(1024, 768));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	//	   Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   driver.manage().window().setSize(new Dimension(1024, 768));
		
		 // wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
		 	synchronized (_departureCityButton) {
	        	try {
	        		_departureCityButton.wait(10000);
	        	} catch (InterruptedException e) {
	        		e.printStackTrace();
	        	}
	        }
		  
		  driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	//   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='To']")));

	    driver.findElement(By.xpath("//span[normalize-space()='To']")).click();

	  
	    
	// destination city text Alert box
	    driver.findElement(By.id("search_input")).sendKeys("NYC");
	    driver.findElement(By.id("search_input")).sendKeys(Keys.ENTER);
	    
      
        
     
        
        

	   
	   
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_input")));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	///close the arriving city alert box (the x button)
	    driver.findElement(By.cssSelector(".search-flyout-close")).click();

    }
	
	
	
	public void chooseDates () {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".calDateSeparator")));

		   driver.findElement(By.cssSelector(".calDateSeparator")).click();

		// the date July 21st
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='19 July 2025, Saturday']")));
		    driver.findElement(By.xpath("//a[@aria-label='19 July 2025, Saturday']")).click();

		// the date July 25st
		  //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("25")));
		    
		    driver.manage().window().maximize();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='25 July 2025, Friday']")));
		    driver.findElement(By.xpath("//a[@aria-label='25 July 2025, Friday']")).click();
		    
		  //button[@value='done']elementToBeClickable
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='done']")));
		    driver.findElement(By.xpath("//button[@value='done']")).click();
		  //  driver.findElement(By.cssSelector(".donebutton")).click();
		  //  driver.findElement(By.id("btn-book-submit")).click();
	}
	
	
	
	

}
